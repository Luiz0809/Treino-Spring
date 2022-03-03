package com.example.treinospring.repositorio;

import com.example.treinospring.entidades.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepositorio extends JpaRepository<Transacao, Long> {

}
