import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu Principal");

        Button btnIniciar = new Button("▶ Iniciar Jogo");
        Button btnInstrucoes = new Button("📜 Instruções");
        Button btnSair = new Button("❌ Sair");

        // Ação do botão "Iniciar Jogo"
        btnIniciar.setOnAction(e -> {
            TabuleiroController tabuleiro = new TabuleiroController();
            try {
                tabuleiro.start(new Stage());
                primaryStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Ação do botão "Instruções"
        btnInstrucoes.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Instruções");
            alert.setHeaderText("Como jogar");
            alert.setContentText("Clique em uma peça para selecioná-la, depois clique no destino.\n\nObjetivo: Derrotar o rei adversário.");
            alert.showAndWait();
        });

        // Ação do botão "Sair"
        btnSair.setOnAction(e -> {
            primaryStage.close();
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(btnIniciar, btnInstrucoes, btnSair);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
