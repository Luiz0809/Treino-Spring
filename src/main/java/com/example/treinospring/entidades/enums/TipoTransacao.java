package com.example.treinospring.entidades.enums;

public enum TipoTransacao {
    SAQUE(1),
    DEPOSITO(2),
    TED(3),
    DOC(4),
    PIX(5),
    EMPRESTIMO(6);

    private int codigo;

    private TipoTransacao(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoTransacao valueOf(int codigo){
        for(TipoTransacao valor : TipoTransacao.values()){
            if(valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalArgumentException("Codigo inválido");
    }
}


