package com.example.treinospring.recursos;

import ch.qos.logback.core.net.server.Client;
import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.servicos.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente objeto){
        objeto = service.inserir(objeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).body(objeto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente objeto){
        objeto = service.atualizar(id,objeto);
        return ResponseEntity.ok().body(objeto);
    }

}
