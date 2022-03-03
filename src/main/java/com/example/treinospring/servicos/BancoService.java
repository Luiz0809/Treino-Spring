package com.example.treinospring.servicos;

import com.example.treinospring.entidades.Banco;
import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.repositorio.BancoRepositorio;
import com.example.treinospring.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepositorio repositorio;

    public List<Banco> buscarTodos(){
        return repositorio.findAll();
    }

    public Banco buscarPorId(Long id){
        Optional<Banco> objeto = repositorio.findById(id);
        return objeto.get();
    }
}
