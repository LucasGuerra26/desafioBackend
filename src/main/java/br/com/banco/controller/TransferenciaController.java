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

    @GetMapping("/transferencias")
    public ResponseEntity<Object> getTransferenciasContaFilter(@RequestParam(value="contaId", required = false) String contaId,
                                                         @RequestParam(value="nomeOperador", required = false) String nomeOperador,
                                                         @RequestParam(value="dataInicial", required = false) @DateTimeFormat(pattern="MMddyyyy") Date fromDate,
                                                         @RequestParam(value="dataFinal", required = false) @DateTimeFormat(pattern="MMddyyyy") Date toDate
    ) {

        try {
            List<Transferencia> transferencias= findTransfersService.findTranfers(contaId, nomeOperador, fromDate, toDate);
            return new ResponseEntity<>(transferencias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
