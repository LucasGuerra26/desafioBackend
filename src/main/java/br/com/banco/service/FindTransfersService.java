package br.com.banco.service;

import br.com.banco.model.Transferencia;

import java.util.Date;
import java.util.List;

public interface FindTransfersService {

    List<Transferencia> findTranfers(String contaId, String nomeOperador, Date fromDate, Date toDate);
}
