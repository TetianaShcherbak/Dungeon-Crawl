package com.codecool.dungeoncrawl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PlayerInput extends Application {

    public static void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button("AAAA");
        button.setOnAction(ev -> startGame(stage));

        GridPane ui = new GridPane();
        ui.add(button, 0, 0);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(ui);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);

        stage.setTitle("Dungeon Crawl");
        stage.show();
    }

    private void startGame(Stage stage) {
        Main main = new Main();
        main.start(stage);
    }
}
