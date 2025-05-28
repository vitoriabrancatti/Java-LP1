package com.exemplo.tabuleiroxadrez;

import java.sql.Connection;
import java.sql.SQLException;

import com.exemplo.tabuleiroxadrez.Conexao;

public class TabuleiroRepository {
    private String[][] casas;

    public TabuleiroRepository() {
        casas = new String[8][8];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = "-";
            }
        }

        casas[0][0] = "TR-B"; casas[0][1] = "KN-B"; casas[0][2] = "BP-B"; casas[0][3] = "QN-B";
        casas[0][4] = "RK-B"; casas[0][5] = "BP-B"; casas[0][6] = "KN-B"; casas[0][7] = "TR-B";
        for (int j = 0; j < 8; j++) casas[1][j] = "PN-B";

        casas[7][0] = "TR-W"; casas[7][1] = "KN-W"; casas[7][2] = "BP-W"; casas[7][3] = "QN-W";
        casas[7][4] = "RK-W"; casas[7][5] = "BP-W"; casas[7][6] = "KN-W"; casas[7][7] = "TR-W";
        for (int j = 0; j < 8; j++) casas[6][j] = "PN-W";
    }

    public void salvarMovimento(String peca, int origemLinha, int origemColuna, int destinoLinha, int destinoColuna) {
        Connection conexao = Conexao.getConexao();
        if (conexao != null) {
            try {
                System.out.println("Movimento salvo no banco (simulado): " + peca + 
                    " de " + origemLinha + "," + origemColuna + " para " + destinoLinha + "," + destinoColuna);
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao simular salvamento: " + e.getMessage());
            }
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
