package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(value="select * from TRANSFERENCIA where CONTA_ID=:contaId", nativeQuery = true)
    List<Transferencia> findTransfersByContaId(long contaId);

    @Query(value="select * from TRANSFERENCIA where NOME_OPERADOR_TRANSACAO=:operador", nativeQuery = true)
    List<Transferencia> findTransfersByOperador(String operador);

    @Query(value="select * from TRANSFERENCIA where NOME_OPERADOR_TRANSACAO=:operador and DATA_TRANSFERENCIA>=:fromDate and DATA_TRANSFERENCIA<=:toDate", nativeQuery = true)
    List<Transferencia> findTransfersByFullFilters(String operador, Date fromDate, Date toDate);

    @Query(value="select * from TRANSFERENCIA where DATA_TRANSFERENCIA>=:fromDate and DATA_TRANSFERENCIA<=:toDate", nativeQuery = true)
    List<Transferencia> findTransfersByDate(Date fromDate, Date toDate);



}
