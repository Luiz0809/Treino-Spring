package com.example.treinospring.recursos.exceptions;

import com.example.treinospring.servicos.exceptions.BancoDeDadosException;
import com.example.treinospring.servicos.exceptions.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;


@ControllerAdvice
public class ManipuladorExcecoesDeRecurso {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erro = new ErroPadrao(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(BancoDeDadosException.class)
    public ResponseEntity<ErroPadrao> database(BancoDeDadosException e, HttpServletRequest request){
        String error = "Erro no Banco de Dados";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erro = new ErroPadrao(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
}

