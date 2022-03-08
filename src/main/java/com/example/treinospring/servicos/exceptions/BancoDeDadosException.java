package com.example.treinospring.servicos.exceptions;

public class BancoDeDadosException extends RuntimeException{

    public BancoDeDadosException(String mensagem){
        super(mensagem);
    }
}
