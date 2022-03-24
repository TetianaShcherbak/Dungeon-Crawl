package com.codecool.dungeoncrawl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PlayerInput extends Application {

    public static void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button("START");
        GridPane ui = new GridPane(); // siatka na elementy
        Label label = new Label("Enter player name:"); // stworzenie nowej etykiety
        TextField playerName = new TextField();
        ui.add(label, 0, 0);
        ui.add(playerName, 0, 1);
        ui.add(button, 0, 2);

        button.setOnAction(ev -> startGame(stage, playerName.getText()));

        Scene scene = new Scene(ui); // tworzenie nowego okna
        stage.setScene(scene); // wyświetlanie okna

        stage.setTitle("Dungeon Crawl"); // ustawianie tytułu okna
        stage.show();  // wyświetlenie okna
    }

    private void startGame(Stage stage, String playerName) {
        Main main = new Main(playerName);
        main.start(stage);
    }
}
