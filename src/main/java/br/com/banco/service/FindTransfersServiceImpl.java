package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FindTransfersServiceImpl implements FindTransfersService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;



    @Override
    public List<Transferencia> findTransfersByContaId(String contaId) {
        long id = java.lang.Long.parseLong(contaId);
        return transferenciaRepository.findTransfersByContaId(id);
    }

    @Override
    public List<Transferencia> findTransfersByOperador(String operador) {
        return transferenciaRepository.findTransfersByOperador(operador);
    }

    @Override
    public List<Transferencia> findTransfersByFullFilters(Date fromDate, Date toDate, String operador) {
        return transferenciaRepository.findTransfersByFullFilters(operador, fromDate, toDate);
    }

    @Override
    public List<Transferencia> findTransfersByDate(Date fromDate, Date toDate) {

        return transferenciaRepository.findTransfersByDate(fromDate, toDate);
    }
}
