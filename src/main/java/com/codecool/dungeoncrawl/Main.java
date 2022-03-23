package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.AiMovement.NpcMovement;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    NpcMovement ai = new NpcMovement(map);
    Canvas canvas = new Canvas(
            map.getWidth()/2 * Tiles.TILE_WIDTH,
            map.getHeight()/2 * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label infoLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(map.getWidth());
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:
                map.getPlayer().move(1, 0);
                refresh();
                break;
            case E:
                map.getPlayer().getBackpack().addItemToBackPack();
                infoLabel.setText(map.getPlayer().getBackpack().showItemInfo());
                refresh();
//            case R:
//                map.getPlayer().getBackpack().dropLastGottenItem();
//                infoLabel.setText("Drop");
//                refresh();
            case I:
                infoLabel.setText(map.getPlayer().getBackpack().showBackPackContent());
        }
    }


    private void refresh() {
        ai.moveNpc();
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < 43; x++) {
            for (int y = 0; y < 20; y++) {
                Player player = map.getPlayer();
                int playerPositionX = player.getX();
                int playerPositionY = player.getY();
                int windowX;
                int windowY;
                if (playerPositionX<11 && playerPositionY<6){
                    windowX = x;
                    windowY = y;
                }else if (playerPositionX>34 && playerPositionY<6){
                    windowX = x+23;
                    windowY = y;;
                }else if (playerPositionX<11 && playerPositionY>20){
                    windowX = x;
                    windowY = y+14;;
                }else if (playerPositionX>34 && playerPositionY>20){
                    windowX = x+23;
                    windowY = y+14;;
                } else if (playerPositionX<11){
                    windowX = x;
                    windowY = playerPositionY + y - 6;
                }else if (playerPositionX>34){
                    windowX = x+23;
                    windowY = playerPositionY + y - 6;
                } else if (playerPositionY<6){
                    windowX = playerPositionX + x - 11;
                    windowY = y;
                } else if (playerPositionY>20){
                    windowX = playerPositionX + x - 11;
                    windowY = y+14;
                } else {
                    windowX = playerPositionX + x - 11;
                    windowY = playerPositionY + y - 6;
                }
                if (windowY < 0 || windowY >= map.getHeight()) {
                    Tiles.drawTile(context, () -> "empty", x, y);
                } else if (windowX < 0 || windowX >= map.getWidth()){
                    Tiles.drawTile(context, () -> "empty", x, y);
                }else {
                    Cell cell = map.getCell(windowX, windowY);
                    Tiles.drawTile(context, cell, x, y);
                    if (cell.getCellContent() != null) {
                        Tiles.drawTile(this.context, cell.getCellContent(), x, y);
                    } else {
                        Tiles.drawTile(this.context, cell, x, y);
                    }
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());
    }

}
