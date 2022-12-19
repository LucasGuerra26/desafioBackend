package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Transferencia {

    @Column(name = "ID")
    private long id;

    @Column(name = "DATA_TRANSFERENCIA")
    private Date dataTransacao;

    @Column(name = "VALOR")
    private double valorTransacao;

    @Column(name = "TIPO")
    private TipoTransacao tipoTransacao;

    @Column(name = "NOME_OPERADOR_TRANSACAO")
    private String operadorTransacao;

    @Column(name = "CONTA_ID")
    private long contaId;
}
