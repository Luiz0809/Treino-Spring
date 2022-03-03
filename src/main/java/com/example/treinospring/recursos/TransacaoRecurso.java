package com.example.treinospring.recursos;

import com.example.treinospring.entidades.Banco;
import com.example.treinospring.entidades.Transacao;
import com.example.treinospring.servicos.BancoService;
import com.example.treinospring.servicos.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoRecurso {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public ResponseEntity<List<Transacao>> buscar() {
        List<Transacao> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id){
        Transacao objeto = service.buscarPorId(id);
        return ResponseEntity.ok().body(objeto);
    }
}
