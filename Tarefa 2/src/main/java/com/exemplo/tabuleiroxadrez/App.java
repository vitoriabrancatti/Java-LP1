package com.exemplo.tabuleiroxadrez;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    private TabuleiroController controller;

    private int origemLinha = -1;
    private int origemColuna = -1;

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Menu Principal");

        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        Button btnIniciar = new Button("▶ Iniciar Jogo");
        Button btnInstrucoes = new Button("📜 Instruções");
        Button btnSair = new Button("❌ Sair");

        btnIniciar.setPrefWidth(200);
        btnInstrucoes.setPrefWidth(200);
        btnSair.setPrefWidth(200);

        btnIniciar.setOnAction(e -> mostrarTabuleiro());
        btnInstrucoes.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Instruções");
            alert.setHeaderText("Como jogar");
            alert.setContentText("Clique em uma peça para selecioná-la, depois clique no destino.\n\nObjetivo: Derrotar o rei adversário.");
            alert.showAndWait();
        });
        btnSair.setOnAction(e -> primaryStage.close());

        VBox layoutMenu = new VBox(15);
        layoutMenu.getChildren().addAll(btnIniciar, btnInstrucoes, btnSair);
        layoutMenu.setAlignment(Pos.CENTER);

        Scene cenaMenu = new Scene(layoutMenu, 300, 200);
        primaryStage.setScene(cenaMenu);
        primaryStage.show();
    }

    private void mostrarTabuleiro() {
        primaryStage.setTitle("Tabuleiro de Xadrez");

        TabuleiroRepository repository = new TabuleiroRepository();
        TabuleiroService service = new TabuleiroService(repository);
        controller = new TabuleiroController(service);

        GridPane grid = criarGridTabuleiro();

        Scene cenaTabuleiro = new Scene(grid, 480, 480);
        primaryStage.setScene(cenaTabuleiro);
        primaryStage.show();
    }

    private GridPane criarGridTabuleiro() {
        GridPane grid = new GridPane();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button button = criarBotaoCasa(i, j);
                grid.add(button, j, i);
            }
        }

        return grid;
    }

    private Button criarBotaoCasa(int linha, int coluna) {
        Button button = new Button(controller.getCasa(linha, coluna));
        button.setPrefSize(60, 60);
        button.setFont(Font.font("Arial", 14));
        button.setAlignment(Pos.CENTER);

        boolean casaEscura = (linha + coluna) % 2 != 0;
        String corFundo = casaEscura ? "#769656" : "#eeeed2";

        if (linha == origemLinha && coluna == origemColuna) {
            corFundo = "#f7ec56"; // amarelo claro para seleção
        }

        button.setStyle("-fx-background-color: " + corFundo + "; -fx-border-color: black;");

        final int linhaFinal = linha;
        final int colunaFinal = coluna;

        button.setOnAction(e -> {
            String conteudoCasa = controller.getCasa(linhaFinal, colunaFinal);

            if (linhaFinal == origemLinha && colunaFinal == origemColuna) {
                origemLinha = -1;
                origemColuna = -1;
                atualizarTabuleiro((GridPane) button.getParent());
                return;
            }

            if (origemLinha == -1 && origemColuna == -1) {
                if (!conteudoCasa.equals("-")) {
                    origemLinha = linhaFinal;
                    origemColuna = colunaFinal;
                    atualizarTabuleiro((GridPane) button.getParent());
                }
            } else {
                try {
                    controller.moverPeca(origemLinha, origemColuna, linhaFinal, colunaFinal);
                } catch (MovimentoInvalidoException ex) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Movimento Inválido");
                    alert.setHeaderText(null);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                }
                origemLinha = -1;
                origemColuna = -1;
                atualizarTabuleiro((GridPane) button.getParent());
            }
        });

        return button;
    }

    private void atualizarTabuleiro(GridPane grid) {
        grid.getChildren().clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button button = criarBotaoCasa(i, j);
                grid.add(button, j, i);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
