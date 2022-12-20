package br.com.banco.controller;


import br.com.banco.model.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.banco.service.FindTransfersService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransferenciaController {

    @Autowired
    FindTransfersService findTransfersService;

    @GetMapping("/{contaId}/transferencias")
    public ResponseEntity<Object> getTransferenciasConta(@PathVariable String contaId) {

        try {
                List<Transferencia> transferencias = findTransfersService.findTransfersByContaId(contaId);
                return new ResponseEntity<>(transferencias, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/transferencias")
    public ResponseEntity<Object> getTransferenciasContaFilter(
                                                         @RequestParam(value="nomeOperador", required = false) String nomeOperador,
                                                         @RequestParam(value="dataInicial", required = false) @DateTimeFormat(pattern="MMddyyyy") Date fromDate,
                                                         @RequestParam(value="dataFinal", required = false) @DateTimeFormat(pattern="MMddyyyy") Date toDate
    ) {

        try {
            if (nomeOperador != null && fromDate != null && toDate != null) {
                List<Transferencia> transferencias = findTransfersService.findTransfersByFullFilters(fromDate, toDate, nomeOperador);
                return new ResponseEntity<>(transferencias, HttpStatus.OK);
            } else if (nomeOperador != null && fromDate == null && toDate == null) {
                List<Transferencia> transferencias = findTransfersService.findTransfersByOperador(nomeOperador);
                return new ResponseEntity<>(transferencias, HttpStatus.OK);
            } else if (nomeOperador == null && fromDate != null && toDate != null){
                List<Transferencia> transferencias = findTransfersService.findTransfersByDate(fromDate, toDate);
                return new ResponseEntity<>(transferencias, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
