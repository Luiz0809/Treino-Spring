package com.example.treinospring.repositorio;

import com.example.treinospring.entidades.Banco;
import com.example.treinospring.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepositorio extends JpaRepository<Banco, Long> {

}
