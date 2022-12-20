package br.com.banco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transferencia {

    @Column(name = "ID")
    @Id
    private long id;

    @Column(name = "DATA_TRANSFERENCIA")
    private Date dataTransacao;

    @Column(name = "VALOR")
    private double valorTransacao;

    @Column(name = "TIPO")
    private String tipoTransacao;

    @Column(name = "NOME_OPERADOR_TRANSACAO")
    private String operadorTransacao;

    @Column(name = "CONTA_ID")
    private long contaId;
}
