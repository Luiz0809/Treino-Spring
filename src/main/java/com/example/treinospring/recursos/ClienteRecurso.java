package com.example.treinospring.recursos;

import com.example.treinospring.entidades.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteRecurso {

    @GetMapping
    public ResponseEntity<Cliente> buscar() {
        Cliente cliente = new Cliente(1L, "Luiz", "490.450.688-25","luiz@hotmail.com","11910632694","Rua Sonhos Dourados, 86", 2554L, 52750L);
        return ResponseEntity.ok().body(cliente);
    }
}
