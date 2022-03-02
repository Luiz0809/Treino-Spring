package com.example.treinospring.repositorio;

import com.example.treinospring.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
