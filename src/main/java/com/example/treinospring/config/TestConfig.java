package com.example.treinospring.config;

import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null,"Monica Nunes","213.486.658.41","monica@hotmail.com","1185269841","Rua Sonhos Dourados, 86",4784L, 25855L);
        Cliente c2 = new Cliente(null,"Pedro Henrique","054.001.924.32","Pedro@hotmail.com","1154213395","Rua Mombaça de Cima, 86",5001L, 36214L);

        clienteRepositorio.saveAll(Arrays.asList(c1,c2));
    }
}
