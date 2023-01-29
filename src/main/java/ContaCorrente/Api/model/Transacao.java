package ContaCorrente.Api.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransacao;

    private Conta conta;

    @Column
    private double valor;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dataTransacao;

    public Long getIdTransacao(){
        return idTransacao;
    }
    public void setIdTransacao(
            Long idTransacao) {
        this.idTransacao = idTransacao;
    }
    public Conta getConta() {

        return conta;
    }
    public void setConta(Conta conta) {

        this.conta = conta;
    }
    public double getValor() {

        return valor;
    }
    public void setValor(double valor) {

        this.valor = valor;
    }
    public Date getDataTransacao() {

        return dataTransacao;
    }
    public void setDataTransacao(Date dataTransacao) {

        this.dataTransacao = dataTransacao;
    }
}
