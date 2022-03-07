package com.example.treinospring.entidades;

import com.example.treinospring.entidades.enums.TipoTransacao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "Transacao")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant dataTransacao;
    @ManyToOne
    private ContaCorrente contaOrigem;
    @ManyToOne
    private ContaCorrente contaDestino;
    private BigDecimal valor;
    private Integer tipoTransacao;
    @OneToOne(mappedBy = "transacao", cascade = CascadeType.ALL)//Mapeando as entidades para terem o mesmo ID
    private StatusPagamento statusPagamento;

    public Transacao(Long id, Instant dataTransacao, ContaCorrente contaOrigem, ContaCorrente contaDestino, BigDecimal valor, TipoTransacao tipoTransacao) {
        this.id = id;
        this.dataTransacao = dataTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        setTipoTransacao(tipoTransacao);
    }

    public Transacao() {
    }
    
    public BigDecimal getSaque(){
        if(contaOrigem.getSaldo().compareTo(valor) >= 0){
            return contaOrigem.getSaldo().subtract(valor);
        }
        else {
            return contaOrigem.getSaldo();
        }

    }

    public BigDecimal getDeposito(){
        return contaDestino.getSaldo().add(valor);
    }

    public BigDecimal getPIX() {
        if(contaOrigem.getSaldo().compareTo(valor) >= 0){
            return contaDestino.getSaldo().add(valor);
        }
        return contaOrigem.getSaldo().subtract(valor);
    }

    public BigDecimal getTED() {
        if(contaOrigem.getSaldo().compareTo(valor) >= 0){
            return contaDestino.getSaldo().add(valor);
        }
        return contaOrigem.getSaldo().subtract(valor.add(valor.multiply(new BigDecimal(0.15))));
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Instant dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public ContaCorrente getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaCorrente contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaCorrente getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaCorrente contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return TipoTransacao.valueOf(tipoTransacao);
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        if (tipoTransacao != null) {
            this.tipoTransacao = tipoTransacao.getCodigo();
        }
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
