package ContaCorrente.Api.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;


@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConta;

    private Pessoa pessoa;

    private List<Transacao> transacoes;

    @Column(nullable = false)
    private double saldo;

    @Column
    private double limiteSaqueDiario;

    @Column
    private boolean flagAtivo;

    @Column
    private String tipo;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @Column
    private Date dataCriacao;

}
