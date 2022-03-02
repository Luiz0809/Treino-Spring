package com.example.treinospring.servicos;

import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio repositorio;

    public List<Cliente> buscarTodos(){
        return repositorio.findAll();
    }

    public Cliente buscarPorId(Long id){
        Optional<Cliente> objeto = repositorio.findById(id);
        return objeto.get();
    }
}
