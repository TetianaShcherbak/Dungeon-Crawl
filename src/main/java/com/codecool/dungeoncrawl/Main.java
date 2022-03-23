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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.nio.charset.StandardCharsets;


public class Main extends Application {
//    NpcMovement ai = new NpcMovement();
    GameMap map = MapLoader.loadMap();
    NpcMovement ai = new NpcMovement(map);
    Canvas canvas = new Canvas(
            map.getWidth()/2 * Tiles.TILE_WIDTH,
            map.getHeight()/2 * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label("ddd");
    Label infoLabel = new Label();
    GridPane inventoryBar = new GridPane();
    GridPane ui = new GridPane();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(map.getWidth());

        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));



        ui.add(new Label(new String("Health: ".getBytes(StandardCharsets.UTF_8))), 0, 0);


        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);
        borderPane.setBottom(inventoryBar);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);


        inventoryBar.setPadding(new Insets(0));

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
                break;
//            case R:
//                map.getPlayer().getBackpack().dropLastGottenItem();
//                infoLabel.setText("Drop");
//                refresh();
            case I:
                infoLabel.setText(map.getPlayer().getBackpack().showBackPackContent());
            case K:
                map.getPlayer().openDoor();
        }
    }


    private void refresh() {
        ai.moveNpc();
//        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < 43; x++) {
            for (int y = 0; y < 20; y++) {
                Player player = map.getPlayer();
                int playerPositionX = player.getX();
                int playerPositionY = player.getY();
                int windowX =playerPositionX + x - 11;;
                int windowY =playerPositionY + y - 6;;
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
        Player player = map.getPlayer();
        for (int i=0; i<12; i++){
            inventoryBar.add(new ImageView(new Image("puste-miejsce.png", 59, 59, false, false)), i, 0);
        }
        if (player.backpack.containItemType("key")){
            inventoryBar.add(new ImageView(new Image("klucz.png", 59, 59, false, false)), 0, 0);
        }
        if (player.backpack.containItemType("cheese")){
            inventoryBar.add(new ImageView(new Image("ser.png", 59, 59, false, false)), 1, 0);
        }
        if (player.backpack.containItemType("sword")){
            inventoryBar.add(new ImageView(new Image("miecz.png", 59, 59, false, false)), 2, 0);
        }
        if (player.backpack.containItemType("sword1")){
            inventoryBar.add(new ImageView(new Image("miecz.png", 59, 59, false, false)), 3, 0);
        }
        if (player.backpack.containItemType("helmet")){
            inventoryBar.add(new ImageView(new Image("helmet.png", 59, 59, false, false)), 4, 0);
        }
        ui.add(new Label(new String(String.valueOf(map.getPlayer().getHealth()).getBytes(StandardCharsets.UTF_8))), 1, 0);
    }
}
