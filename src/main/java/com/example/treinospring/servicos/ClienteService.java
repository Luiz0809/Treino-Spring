package com.example.treinospring.servicos;

import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.repositorio.ClienteRepositorio;
import com.example.treinospring.servicos.exceptions.BancoDeDadosException;
import com.example.treinospring.servicos.exceptions.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        try {
            repositorio.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException(id);
        } catch (DataIntegrityViolationException e){
            throw new BancoDeDadosException(e.getMessage());
        }
    }

    public Cliente atualizar(Long id, Cliente objeto){
        try {
            Cliente entidade = repositorio.getOne(id);
            atualizarDados(entidade, objeto);
            return repositorio.save(entidade);
        } catch (EntityNotFoundException e){
            throw new RecursoNaoEncontradoException(id);
        }
    }

    private void atualizarDados(Cliente entidade, Cliente objeto) {
        entidade.setNome(objeto.getNome());
        entidade.setEmail(objeto.getEmail());
        entidade.setTelefone(objeto.getTelefone());
        entidade.setEndereco(objeto.getEndereco());

    }
}
