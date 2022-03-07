package com.example.treinospring.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "ContaCorrente")
public class ContaCorrente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
    private String conta;
    @OneToOne
    @JoinColumn(name = "Banco_ID")
    private Banco numeroDoBanco;
    private BigDecimal saldo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant dataUsuario;

    @ManyToOne
    private Cliente cliente;

    public ContaCorrente(){}

    public ContaCorrente(Long id, String agencia, String conta, Banco numeroDoBanco, BigDecimal saldo, Instant dataUsuario, Cliente cliente) {
        this.id = id;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroDoBanco = numeroDoBanco;
        this.saldo = saldo;
        this.dataUsuario = dataUsuario;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Banco getNumeroDoBanco() {
        return numeroDoBanco;
    }

    public void setNumeroDoBanco(Banco numeroDoBanco) {
        this.numeroDoBanco = numeroDoBanco;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Instant getDataUsuario() {
        return dataUsuario;
    }

    public void setDataUsuario(Instant dataUsuario) {
        this.dataUsuario = dataUsuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
