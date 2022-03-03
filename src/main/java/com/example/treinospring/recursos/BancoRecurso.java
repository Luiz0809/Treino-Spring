package com.example.treinospring.recursos;

import com.example.treinospring.entidades.Banco;
import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.servicos.BancoService;
import com.example.treinospring.servicos.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bancos")
public class BancoRecurso {

    @Autowired
    private BancoService service;

    @GetMapping
    public ResponseEntity<List<Banco>> buscar() {
        List<Banco> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Banco> buscarPorId(@PathVariable Long id){
        Banco objeto = service.buscarPorId(id);
        return ResponseEntity.ok().body(objeto);
    }
}
