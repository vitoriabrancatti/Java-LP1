package com.exemplo.tabuleiroxadrez;

public class TabuleiroRepository {
    private String[][] casas;

    public TabuleiroRepository() {
        casas = new String[8][8];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        // Preenche com "-" todas as casas
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = "-";
            }
        }

        // Peças pretas - linha 0 e linha 1
        casas[0][0] = "TR-B"; // Torre preta
        casas[0][1] = "KN-B"; // Cavalo preto
        casas[0][2] = "BP-B"; // Bispo preto
        casas[0][3] = "QN-B"; // Rainha preta
        casas[0][4] = "RK-B"; // Rei preto
        casas[0][5] = "BP-B"; // Bispo preto
        casas[0][6] = "KN-B"; // Cavalo preto
        casas[0][7] = "TR-B"; // Torre preta
        for (int j = 0; j < 8; j++) {
            casas[1][j] = "PN-B"; // Peões pretos na linha 1
        }

        // Peças brancas - linha 7 e linha 6
        casas[7][0] = "TR-W"; // Torre branca
        casas[7][1] = "KN-W"; // Cavalo branco
        casas[7][2] = "BP-W"; // Bispo branco
        casas[7][3] = "QN-W"; // Rainha branca
        casas[7][4] = "RK-W"; // Rei branco
        casas[7][5] = "BP-W"; // Bispo branco
        casas[7][6] = "KN-W"; // Cavalo branco
        casas[7][7] = "TR-W"; // Torre branca
        for (int j = 0; j < 8; j++) {
            casas[6][j] = "PN-W"; // Peões brancos na linha 6
        }
    }

    public String[][] getCasas() {
        return casas;
    }

    public void atualizarPosicao(int linhaOrigem, int colOrigem, int linhaDestino, int colDestino) {
        casas[linhaDestino][colDestino] = casas[linhaOrigem][colOrigem];
        casas[linhaOrigem][colOrigem] = "-";
    }
}
