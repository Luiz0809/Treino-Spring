package com.example.treinospring.repositorio;

import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.entidades.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepositorio extends JpaRepository<ContaCorrente, Long> {

}
