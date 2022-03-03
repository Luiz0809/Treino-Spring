package com.example.treinospring.recursos;

import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.entidades.ContaCorrente;
import com.example.treinospring.servicos.ClienteService;
import com.example.treinospring.servicos.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/conta-corrente")
public class ContaCorrenteRecurso {

    @Autowired
    private ContaCorrenteService service;

    @GetMapping
    public ResponseEntity<List<ContaCorrente>> buscar() {
        List<ContaCorrente> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaCorrente> buscarPorId(@PathVariable Long id){
        ContaCorrente objeto = service.buscarPorId(id);
        return ResponseEntity.ok().body(objeto);
    }
}
