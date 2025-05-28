package com.exemplo.tabuleiroxadrez;

import com.exemplo.tabuleiroxadrez.TabuleiroService;
import com.exemplo.tabuleiroxadrez.MovimentoInvalidoException;

public class Main {
    private TabuleiroService tabuleiroService;

    public Main(TabuleiroService service) {
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

    // Declarando que o método pode lançar a exceção
    public void moverPeca(int linhaOrigem, int colOrigem, int linhaDestino, int colDestino) throws MovimentoInvalidoException {
        tabuleiroService.moverPeca(linhaOrigem, colOrigem, linhaDestino, colDestino);
    }

    public String getCasa(int linha, int coluna) {
        return tabuleiroService.obterTabuleiro()[linha][coluna];
    }

    // Método main para teste, tratando a exceção
public static void main(String[] args) {
    TabuleiroRepository repository = new TabuleiroRepository();  // ajuste conforme necessário
    TabuleiroService service = new TabuleiroService(repository);
    Main mainApp = new Main(service);

    mainApp.exibirTabuleiro();

    try {
        mainApp.moverPeca(6, 4, 4, 4);
        System.out.println("Movimento realizado com sucesso.");
    } catch (MovimentoInvalidoException e) {
        System.out.println("Erro ao mover peça: " + e.getMessage());
    }

    mainApp.exibirTabuleiro();
}
}
