package com.example.treinospring.servicos;

import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.repositorio.ClienteRepositorio;
import com.example.treinospring.servicos.exceptions.RecursoNaoEncontradoException;
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
        return objeto.orElseThrow(()-> new RecursoNaoEncontradoException(id));
    }

    public Cliente inserir(Cliente objeto){
        return repositorio.save(objeto);
    }

    public void deletar(Long id){
        repositorio.deleteById(id);
    }

    public Cliente atualizar(Long id, Cliente objeto){
        Cliente entidade = repositorio.getOne(id);
        atualizarDados(entidade, objeto);
        return repositorio.save(entidade);
    }

    private void atualizarDados(Cliente entidade, Cliente objeto) {
        entidade.setNome(objeto.getNome());
        entidade.setEmail(objeto.getEmail());
        entidade.setTelefone(objeto.getTelefone());
        entidade.setEndereco(objeto.getEndereco());

    }
}
