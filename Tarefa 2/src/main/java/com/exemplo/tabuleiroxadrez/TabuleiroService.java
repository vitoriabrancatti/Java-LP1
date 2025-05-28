package com.exemplo.tabuleiroxadrez;

public class TabuleiroService {

    private TabuleiroRepository repository;

    public TabuleiroService(TabuleiroRepository repository) {
        this.repository = repository;
    }

    public String[][] obterTabuleiro() {
        return repository.getCasas();
    }

    public void moverPeca(int linhaOrigem, int colOrigem, int linhaDestino, int colDestino) throws MovimentoInvalidoException {
        String[][] casas = obterTabuleiro();
        String peca = casas[linhaOrigem][colOrigem];

        if (peca.equals("-")) {
            throw new MovimentoInvalidoException("Não há peça na posição de origem.");
        }

        if (linhaOrigem == linhaDestino && colOrigem == colDestino) {
            throw new MovimentoInvalidoException("Movimento inválido: origem e destino são a mesma posição.");
        }

        if (!movimentoValido(peca, linhaOrigem, colOrigem, linhaDestino, colDestino)) {
            throw new MovimentoInvalidoException("Movimento inválido para a peça: " + peca);
        }

        // Checar se destino tem peça da mesma cor (não permite captura da própria peça)
        String pecaDestino = casas[linhaDestino][colDestino];
        if (!pecaDestino.equals("-") && pecaDestino.endsWith(peca.substring(3))) {
            throw new MovimentoInvalidoException("Não pode capturar peça própria.");
        }

        repository.atualizarPosicao(linhaOrigem, colOrigem, linhaDestino, colDestino);
    }

    private boolean movimentoValido(String peca, int linhaOrigem, int colOrigem, int linhaDestino, int colDestino) {
        switch (peca) {
            case "PN-W":
                return movimentoValidoPeao(linhaOrigem, colOrigem, linhaDestino, colDestino, true);
            case "PN-B":
                return movimentoValidoPeao(linhaOrigem, colOrigem, linhaDestino, colDestino, false);
            case "TR-W":
            case "TR-B":
                return movimentoValidoTorre(linhaOrigem, colOrigem, linhaDestino, colDestino);
            default:
                return true;
        }
    }

    private boolean movimentoValidoPeao(int linhaOrigem, int colOrigem, int linhaDestino, int colDestino, boolean branco) {
        int direcao = branco ? -1 : 1;
        String[][] casas = obterTabuleiro();

        // Movimento simples: uma casa para frente e deve estar vazio
        if (colOrigem == colDestino && linhaDestino == linhaOrigem + direcao) {
            if (casas[linhaDestino][colDestino].equals("-")) {
                return true;
            }
            return false;
        }

        // Movimento inicial: duas casas para frente, ambas vazias
        if (colOrigem == colDestino && ((branco && linhaOrigem == 6) || (!branco && linhaOrigem == 1))
            && linhaDestino == linhaOrigem + 2 * direcao) {
            if (casas[linhaOrigem + direcao][colOrigem].equals("-") && casas[linhaDestino][colDestino].equals("-")) {
                return true;
            }
            return false;
        }

        // Captura diagonal (precisa ter peça inimiga)
        if (Math.abs(colDestino - colOrigem) == 1 && linhaDestino == linhaOrigem + direcao) {
            String pecaDestino = casas[linhaDestino][colDestino];
            if (!pecaDestino.equals("-") && !pecaDestino.endsWith(branco ? "-W" : "-B")) {
                return true;
            }
            return false;
        }

        return false;
    }

    private boolean movimentoValidoTorre(int linhaOrigem, int colOrigem, int linhaDestino, int colDestino) {
        String[][] casas = obterTabuleiro();

        // Movimento vertical ou horizontal
        if (linhaOrigem != linhaDestino && colOrigem != colDestino) {
            return false; // Torre só pode andar em linha reta
        }

        // Checa caminho livre (sem pular peças)
        if (linhaOrigem == linhaDestino) {
            int passo = (colDestino > colOrigem) ? 1 : -1;
            for (int c = colOrigem + passo; c != colDestino; c += passo) {
                if (!casas[linhaOrigem][c].equals("-")) {
                    return false;
                }
            }
        } else {
            int passo = (linhaDestino > linhaOrigem) ? 1 : -1;
            for (int l = linhaOrigem + passo; l != linhaDestino; l += passo) {
                if (!casas[l][colOrigem].equals("-")) {
                    return false;
                }
            }
        }

        return true;
    }
}
