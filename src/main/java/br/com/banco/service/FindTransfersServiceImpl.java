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
    public List<Transferencia> findTranfers(String contaId, String nomeOperador, Date fromDate, Date toDate) {
        if (contaId != null){
            if (nomeOperador != null && fromDate != null && toDate != null) {
                return transferenciaRepository.findTransfersByContaAndFullFilters(contaId, nomeOperador, fromDate, toDate);
            }
            else if (nomeOperador != null && fromDate == null && toDate == null){
                return transferenciaRepository.findTransfersByContaAndOperador(contaId, nomeOperador);
            }
            else if (nomeOperador == null && fromDate == null && toDate == null) {
                return transferenciaRepository.findTransfersByContaId(contaId);
            }
            else {
                return transferenciaRepository.findTransfersByContaAndDate(contaId,fromDate, toDate);
            }
        }
        else {
            if (nomeOperador != null && fromDate != null && toDate != null) {
                return transferenciaRepository.findTransfersByFullFilters(nomeOperador, fromDate, toDate);
            }
            else if (nomeOperador != null && fromDate == null && toDate == null){
                return transferenciaRepository.findTransfersByOperador(nomeOperador);
            } else {
                return transferenciaRepository.findTransfersByDate(fromDate, toDate);
            }
        }

    }
}
