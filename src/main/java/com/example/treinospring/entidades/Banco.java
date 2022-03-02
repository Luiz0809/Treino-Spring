package com.example.treinospring.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Banco")
public class Banco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoBanco;
    private int numeroDoBanco;

    public Banco(){}

    public Banco(Long id, String nomeDoBanco, int numeroDoBanco) {
        this.id = id;
        this.nomeDoBanco = nomeDoBanco;
        this.numeroDoBanco = numeroDoBanco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public int getNumeroDoBanco() {
        return numeroDoBanco;
    }

    public void setNumeroDoBanco(int numeroDoBanco) {
        this.numeroDoBanco = numeroDoBanco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(id, banco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
