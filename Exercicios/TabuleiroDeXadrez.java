public class TabuleiroDeXadrez {
    private String[][] casas;

    public TabuleiroDeXadrez() {
        casas = new String[8][8];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = "-";
            }
        }
        casas[0][4] = "RK"; // Rei Preto (R King)
        casas[7][4] = "rk"; // Rei Branco
    }

    public void exibirTabuleiro() {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(casas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a  b  c  d  e  f  g  h");
    }

    public void moverPeca(int linhaOrigem, int colOrigem, int linhaDestino, int colDestino) {
        casas[linhaDestino][colDestino] = casas[linhaOrigem][colOrigem];
        casas[linhaOrigem][colOrigem] = "-";
    }

}