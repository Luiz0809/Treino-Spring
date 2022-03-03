package com.example.treinospring.config;

import com.example.treinospring.entidades.Banco;
import com.example.treinospring.entidades.Cliente;
import com.example.treinospring.entidades.ContaCorrente;
import com.example.treinospring.entidades.Transacao;
import com.example.treinospring.entidades.enums.TipoTransacao;
import com.example.treinospring.repositorio.BancoRepositorio;
import com.example.treinospring.repositorio.ClienteRepositorio;
import com.example.treinospring.repositorio.ContaCorrenteRepositorio;
import com.example.treinospring.repositorio.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private BancoRepositorio bancoRepositorio;

    @Autowired
    private ContaCorrenteRepositorio contaCorrenteRepositorio;

    @Autowired
    private TransacaoRepositorio transacaoRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null,"Monica Nunes","213.486.658.41","monica@hotmail.com","1185269841","Rua Sonhos Dourados, 86");
        Cliente c2 = new Cliente(null,"Pedro Henrique","054.001.924.32","Pedro@hotmail.com","1154213395","Rua Mombaça de Cima, 86");

        Banco b1 = new Banco(null,"Itaú", 1225);
        Banco b2 = new Banco(null,"Bradesco",1713);
        Banco b3 = new Banco(null,"Caixa",8954);

        ContaCorrente cc1 = new ContaCorrente(null,"0244","24513",b1, BigDecimal.valueOf(5000.00), Instant.parse("2022-03-03T08:31:55Z"),c1);
        ContaCorrente cc2 = new ContaCorrente(null,"1459","79845",b2, BigDecimal.valueOf(6521.79), Instant.parse("2022-03-03T08:31:55Z"),c2);
        ContaCorrente cc3 = new ContaCorrente(null,"9756","21450",b2, BigDecimal.valueOf(25.63), Instant.parse("2022-03-03T08:31:55Z"),c1);
        ContaCorrente cc4 = new ContaCorrente(null,"3782","43165",b3, BigDecimal.valueOf(104561.97), Instant.parse("2022-03-03T08:31:55Z"),c2);

        Transacao t1 = new Transacao(null,Instant.parse("2022-03-03T08:31:55Z"), cc1, cc3, BigDecimal.valueOf(20.00), TipoTransacao.PIX);
        Transacao t2 = new Transacao(null,Instant.parse("2022-03-03T08:31:55Z"), cc2, cc4, BigDecimal.valueOf(29.88), TipoTransacao.DOC);
        Transacao t3 = new Transacao(null,Instant.parse("2022-03-03T08:31:55Z"), cc2, cc3, BigDecimal.valueOf(77.63), TipoTransacao.TED);

        bancoRepositorio.saveAll(Arrays.asList(b1,b2,b3));
        clienteRepositorio.saveAll(Arrays.asList(c1,c2));
        contaCorrenteRepositorio.saveAll(Arrays.asList(cc1,cc2,cc3,cc4));
        transacaoRepositorio.saveAll(Arrays.asList(t1,t2,t3));


    }
}
