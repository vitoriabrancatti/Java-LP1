package com.exemplo.tabuleiroxadrez;

public class MovimentoInvalidoException extends Exception {
    public MovimentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
