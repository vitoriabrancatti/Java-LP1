import java.util.Scanner;

abstract class Peca {
    String cor;
    String posicao;

    Peca(String cor, String posicao) {
        this.cor = cor;
        this.posicao = posicao;
    }

    abstract void mover(String novaPosicao);
    abstract void capturar();
}

class Rei extends Peca {
    boolean emXeque;

    Rei(String cor, String posicao) {
        super(cor, posicao);
    }

    void mover(String novaPosicao) {
        this.posicao = novaPosicao;
        System.out.println("Rei " + cor + " moveu para " + novaPosicao);
    }

    void capturar() {
        System.out.println("Rei " + cor + " capturou uma peça.");
    }

    void verificarXeque() {
        System.out.println("Verificando se o Rei " + cor + " está em xeque.");
    }
}

class Peao extends Peca {
    boolean promovido;

    Peao(String cor, String posicao) {
        super(cor, posicao);
    }

    void mover(String novaPosicao) {
        this.posicao = novaPosicao;
        System.out.println("Peão " + cor + " moveu para " + novaPosicao);
    }

    void capturar() {
        System.out.println("Peão " + cor + " capturou uma peça.");
    }

    void promover() {
        promovido = true;
        System.out.println("Peão " + cor + " promovido.");
    }
}

class TabuleiroDeXadrez {
    String[][] tabuleiro = new String[8][8];

    void mostrarTabuleiro() {
        System.out.println("Tabuleiro de Xadrez:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(tabuleiro[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    void posicionarPeca(Peca peca) {
        int[] pos = converterPosicao(peca.posicao);
        if (pos != null)
            tabuleiro[pos[0]][pos[1]] = nomeCurto(peca);
    }

    void moverPeca(Peca peca, String novaPosicao) {
        int[] posAnterior = converterPosicao(peca.posicao);
        int[] posNova = converterPosicao(novaPosicao);
        if (posNova == null) {
            System.out.println("Posição inválida!");
            return;
        }
        tabuleiro[posAnterior[0]][posAnterior[1]] = null;
        peca.mover(novaPosicao);
        tabuleiro[posNova[0]][posNova[1]] = nomeCurto(peca);
    }

    private int[] converterPosicao(String pos) {
        if (pos.length() != 2) return null;
        char colunaChar = pos.charAt(0);
        char linhaChar = pos.charAt(1);
        if (colunaChar < 'a' || colunaChar > 'h' || linhaChar < '1' || linhaChar > '8') return null;
        int linha = 8 - Character.getNumericValue(linhaChar);
        int coluna = colunaChar - 'a';
        return new int[]{linha, coluna};
    }

    private String nomeCurto(Peca peca) {
        if (peca instanceof Rei) {
            return "Rei" + (peca.cor.equals("Branco") ? "B" : "P");
        } else if (peca instanceof Peao) {
            return "Peo" + (peca.cor.equals("Branco") ? "B" : "P");
        }
        return "--";
    }
}

class MesaDeXadrez {
    boolean ocupada;

    void ocuparMesa() {
        ocupada = true;
        System.out.println("Mesa ocupada.");
    }

    void liberarMesa() {
        ocupada = false;
        System.out.println("Mesa liberada.");
    }

    void verificarDisponibilidade() {
        System.out.println("Disponibilidade: " + (ocupada ? "Ocupada" : "Livre"));
    }
}

class Jogadora {
    String nome;
    int pontuacao;

    Jogadora(String nome) {
        this.nome = nome;
    }

    void jogar() {
        System.out.println(nome + " está jogando.");
    }

    void ganharPonto() {
        pontuacao++;
        System.out.println(nome + " ganhou um ponto. Total: " + pontuacao);
    }
}

class AberturasDeXadrez {
    String nome;

    AberturasDeXadrez(String nome) {
        this.nome = nome;
    }

    void exibirAbertura() {
        System.out.println("Exibindo abertura: " + nome);
    }

    void usarAbertura() {
        System.out.println("Usando abertura: " + nome);
    }
}

public class TestaClasse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rei reiBranco = new Rei("Branco", "e1");
        Rei reiPreto = new Rei("Preto", "e8");
        Peao peaoBranco = new Peao("Branco", "d2");
        Peao peaoPreto = new Peao("Preto", "d7");

        TabuleiroDeXadrez tabuleiro = new TabuleiroDeXadrez();
        tabuleiro.posicionarPeca(reiBranco);
        tabuleiro.posicionarPeca(reiPreto);
        tabuleiro.posicionarPeca(peaoBranco);
        tabuleiro.posicionarPeca(peaoPreto);

        MesaDeXadrez mesa = new MesaDeXadrez();
        Jogadora jogadora = new Jogadora("Vitória");
        AberturasDeXadrez abertura = new AberturasDeXadrez("Abertura Italiana");

        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Mostrar tabuleiro");
            System.out.println("2 - Mover Rei Branco");
            System.out.println("3 - Mover Rei Preto");
            System.out.println("4 - Mover Peão Branco");
            System.out.println("5 - Mover Peão Preto");
            System.out.println("6 - Ocupar mesa");
            System.out.println("7 - Jogar e ganhar ponto");
            System.out.println("8 - Exibir abertura");
            System.out.println("9 - Verificar Xeque (Reis)");
            System.out.println("10 - Promover Peão Branco");
            System.out.println("11 - Promover Peão Preto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    tabuleiro.mostrarTabuleiro();
                    break;
                case 2:
                    System.out.print("Nova posição para Rei Branco (ex: e2): ");
                    tabuleiro.moverPeca(reiBranco, scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Nova posição para Rei Preto (ex: e7): ");
                    tabuleiro.moverPeca(reiPreto, scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Nova posição para Peão Branco (ex: d4): ");
                    tabuleiro.moverPeca(peaoBranco, scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Nova posição para Peão Preto (ex: d5): ");
                    tabuleiro.moverPeca(peaoPreto, scanner.nextLine());
                    break;
                case 6:
                    mesa.ocuparMesa();
                    mesa.verificarDisponibilidade();
                    break;
                case 7:
                    jogadora.jogar();
                    jogadora.ganharPonto();
                    break;
                case 8:
                    abertura.exibirAbertura();
                    abertura.usarAbertura();
                    break;
                case 9:
                    reiBranco.verificarXeque();
                    reiPreto.verificarXeque();
                    break;
                case 10:
                    peaoBranco.promover();
                    break;
                case 11:
                    peaoPreto.promover();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            if (opcao != 0) {
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }
}