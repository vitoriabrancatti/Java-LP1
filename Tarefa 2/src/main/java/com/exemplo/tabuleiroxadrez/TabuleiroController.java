package com.exemplo.tabuleiroxadrez;

import com.exemplo.tabuleiroxadrez.TabuleiroService;

public class TabuleiroController {
    private TabuleiroService tabuleiroService;

    public TabuleiroController(TabuleiroService service) {
        this.tabuleiroService = service;
    }

    public void exibirTabuleiro() {
        String[][] casas = tabuleiroService.obterTabuleiro();
        System.out.println("Tabuleiro:");
        for (int i = 0; i < casas.length; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < casas[i].length; j++) {
                System.out.print(casas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a  b  c  d  e  f  g  h");
    }

    // Declara que o método pode lançar MovimentoInvalidoException
    public void moverPeca(int linhaOrigem, int colOrigem, int linhaDestino, int colDestino) throws MovimentoInvalidoException {
        tabuleiroService.moverPeca(linhaOrigem, colOrigem, linhaDestino, colDestino);
    }

    public String getCasa(int linha, int coluna) {
        return tabuleiroService.obterTabuleiro()[linha][coluna];
    }
}
