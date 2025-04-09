import java.util.Scanner;

// Classe TabuleiroDeXadrez
class TabuleiroDeXadrez {
    String cor;
    int tamanho;
    boolean estaMontado;

    void montarTabuleiro() {
        estaMontado = true;
        System.out.println("Tabuleiro montado.");
    }

    void exibirStatus() {
        System.out.println("Tabuleiro de cor: " + cor + ", tamanho: " + tamanho);
    }

    void limparTabuleiro() {
        estaMontado = false;
        System.out.println("Tabuleiro limpo.");
    }
}

// Classe ReiPreto
class ReiPreto {
    String posicao;
    boolean estaEmCheque;
    boolean foiMovido;

    void mover(String novaPosicao) {
        posicao = novaPosicao;
        foiMovido = true;
        System.out.println("Rei Preto movido para " + posicao);
    }

    void verificarCheque() {
        System.out.println("Rei Preto está em cheque? " + estaEmCheque);
    }

    void capturar() {
        System.out.println("Rei Preto não pode ser capturado, fim de jogo!");
    }
}

// Classe ReiBranco
class ReiBranco {
    String posicao;
    boolean estaEmCheque;
    boolean foiMovido;

    void mover(String novaPosicao) {
        posicao = novaPosicao;
        foiMovido = true;
        System.out.println("Rei Branco movido para " + posicao);
    }

    void verificarCheque() {
        System.out.println("Rei Branco está em cheque? " + estaEmCheque);
    }

    void capturar() {
        System.out.println("Rei Branco não pode ser capturado, fim de jogo!");
    }
}

// Classe PecasPretas
class PecasPretas {
    int quantidade;
    boolean estaoEmJogo;
    String tipo;

    void listarPecas() {
        System.out.println("Peças pretas do tipo " + tipo + ": " + quantidade);
    }

    void eliminarPeca() {
        if (quantidade > 0) quantidade--;
        System.out.println("Uma peça preta foi eliminada. Restam: " + quantidade);
    }

    void verificarStatus() {
        System.out.println("Peças pretas em jogo: " + estaoEmJogo);
    }
}

// Classe PecasBrancas
class PecasBrancas {
    int quantidade;
    boolean estaoEmJogo;
    String tipo;

    void listarPecas() {
        System.out.println("Peças brancas do tipo " + tipo + ": " + quantidade);
    }

    void eliminarPeca() {
        if (quantidade > 0) quantidade--;
        System.out.println("Uma peça branca foi eliminada. Restam: " + quantidade);
    }

    void verificarStatus() {
        System.out.println("Peças brancas em jogo: " + estaoEmJogo);
    }
}

// Classe PeaoPreto
class PeaoPreto {
    String posicao;
    boolean foiPromovido;
    boolean capturado;

    void mover(String novaPosicao) {
        posicao = novaPosicao;
        System.out.println("Peão preto movido para " + posicao);
    }

    void promover() {
        foiPromovido = true;
        System.out.println("Peão preto promovido!");
    }

    void capturar() {
        capturado = true;
        System.out.println("Peão preto capturado.");
    }
}

// Classe PeaoBranco
class PeaoBranco {
    String posicao;
    boolean foiPromovido;
    boolean capturado;

    void mover(String novaPosicao) {
        posicao = novaPosicao;
        System.out.println("Peão branco movido para " + posicao);
    }

    void promover() {
        foiPromovido = true;
        System.out.println("Peão branco promovido!");
    }

    void capturar() {
        capturado = true;
        System.out.println("Peão branco capturado.");
    }
}

// Classe MesaDeXadrez
class MesaDeXadrez {
    String local;
    boolean estaDisponivel;
    int numeroMesa;

    void reservar() {
        estaDisponivel = false;
        System.out.println("Mesa " + numeroMesa + " reservada no local: " + local);
    }

    void liberar() {
        estaDisponivel = true;
        System.out.println("Mesa " + numeroMesa + " liberada.");
    }

    void verificarDisponibilidade() {
        System.out.println("Mesa disponível? " + estaDisponivel);
    }
}

// Classe Jogadora
class Jogadora {
    String nome;
    int idade;
    int pontuacao;

    void jogar() {
        pontuacao += 10;
        System.out.println(nome + " jogou e agora tem " + pontuacao + " pontos.");
    }

    void apresentar() {
        System.out.println("Jogadora: " + nome + ", idade: " + idade);
    }

    void desistir() {
        System.out.println(nome + " desistiu da partida.");
    }
}

// Classe AberturasDeXadrez
class AberturasDeXadrez {
    String nome;
    String movimentos;
    String estrategia;

    void exibirAbertura() {
        System.out.println("Abertura: " + nome + " - " + movimentos);
    }

    void aplicarEstrategia() {
        System.out.println("Aplicando estratégia: " + estrategia);
    }

    void estudarAbertura() {
        System.out.println("Estudando a abertura " + nome);
    }
}

// Classe principal
public class TestaClasse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando os objetos
        TabuleiroDeXadrez tabuleiro = new TabuleiroDeXadrez();
        ReiPreto reiPreto = new ReiPreto();
        ReiBranco reiBranco = new ReiBranco();
        PecasPretas pecasPretas = new PecasPretas();
        PecasBrancas pecasBrancas = new PecasBrancas();
        PeaoPreto peaoPreto = new PeaoPreto();
        PeaoBranco peaoBranco = new PeaoBranco();
        MesaDeXadrez mesa = new MesaDeXadrez();
        Jogadora jogadora = new Jogadora();
        AberturasDeXadrez abertura = new AberturasDeXadrez();

        int opcao;
        do {
            System.out.println("\nMENU");
            System.out.println("1. Montar tabuleiro");
            System.out.println("2. Mover Rei Preto");
            System.out.println("3. Mover Rei Branco");
            System.out.println("4. Listar peças pretas");
            System.out.println("5. Listar peças brancas");
            System.out.println("6. Mover peão preto");
            System.out.println("7. Mover peão branco");
            System.out.println("8. Reservar mesa");
            System.out.println("9. Jogadora joga");
            System.out.println("10. Exibir abertura");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    tabuleiro.cor = "preto e branco";
                    tabuleiro.tamanho = 64;
                    tabuleiro.montarTabuleiro();
                    tabuleiro.exibirStatus();
                    break;
                case 2:
                    reiPreto.mover("e5");
                    reiPreto.verificarCheque();
                    break;
                case 3:
                    reiBranco.mover("d4");
                    reiBranco.verificarCheque();
                    break;
                case 4:
                    pecasPretas.tipo = "torre";
                    pecasPretas.quantidade = 2;
                    pecasPretas.listarPecas();
                    pecasPretas.eliminarPeca();
                    break;
                case 5:
                    pecasBrancas.tipo = "bispo";
                    pecasBrancas.quantidade = 2;
                    pecasBrancas.listarPecas();
                    pecasBrancas.eliminarPeca();
                    break;
                case 6:
                    peaoPreto.mover("e4");
                    peaoPreto.promover();
                    break;
                case 7:
                    peaoBranco.mover("d3");
                    peaoBranco.promover();
                    break;
                case 8:
                    mesa.local = "Clube de Xadrez";
                    mesa.numeroMesa = 5;
                    mesa.reservar();
                    mesa.verificarDisponibilidade();
                    break;
                case 9:
                    jogadora.nome = "Vitória";
                    jogadora.idade = 23;
                    jogadora.apresentar();
                    jogadora.jogar();
                    break;
                case 10:
                    abertura.nome = "Abertura Italiana";
                    abertura.movimentos = "e4 e5 Nf3 Nc6 Bc4";
                    abertura.estrategia = "Controle do centro e desenvolvimento rápido";
                    abertura.exibirAbertura();
                    abertura.aplicarEstrategia();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}