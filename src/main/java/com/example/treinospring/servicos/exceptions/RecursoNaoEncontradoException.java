package com.example.treinospring.servicos.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException(Object id){
        super("Recurso não encontrado. Id : " + id);
    }
}
