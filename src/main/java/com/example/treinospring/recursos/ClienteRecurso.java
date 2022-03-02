package com.example.treinospring.recursos;

import ch.qos.logback.core.net.server.Client;
import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.servicos.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteRecurso {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscar() {
        List<Cliente> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        Cliente objeto = service.buscarPorId(id);
        return ResponseEntity.ok().body(objeto);
    }
}
