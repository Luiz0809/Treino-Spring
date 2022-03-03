package com.example.treinospring.servicos;

import com.example.treinospring.entidades.Banco;
import com.example.treinospring.entidades.Transacao;
import com.example.treinospring.repositorio.BancoRepositorio;
import com.example.treinospring.repositorio.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepositorio repositorio;

    public List<Transacao> buscarTodos(){
        return repositorio.findAll();
    }

    public Transacao buscarPorId(Long id){
        Optional<Transacao> objeto = repositorio.findById(id);
        return objeto.get();
    }
}
