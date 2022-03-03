package com.example.treinospring.servicos;

import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.entidades.ContaCorrente;
import com.example.treinospring.repositorio.ClienteRepositorio;
import com.example.treinospring.repositorio.ContaCorrenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaCorrenteService {

    @Autowired
    private ContaCorrenteRepositorio repositorio;

    public List<ContaCorrente> buscarTodos(){
        return repositorio.findAll();
    }

    public ContaCorrente buscarPorId(Long id){
        Optional<ContaCorrente> objeto = repositorio.findById(id);
        return objeto.get();
    }
}
