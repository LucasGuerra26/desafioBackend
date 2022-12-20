package br.com.banco.service;

import br.com.banco.model.Transferencia;

import java.util.Date;
import java.util.List;

public interface FindTransfersService {
    List<Transferencia> findTransfersByContaId(String id_conta);

    List<Transferencia> findTransfersByOperador(String operador);

    List<Transferencia> findTransfersByFullFilters(Date fromDate, Date toDate, String operador);

    List<Transferencia> findTransfersByDate(Date fromDate, Date toDate);
}
