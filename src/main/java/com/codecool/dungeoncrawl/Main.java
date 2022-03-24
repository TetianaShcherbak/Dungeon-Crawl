package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.AiMovement.NpcMovement;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.items.Cheese;
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


public class Main {
    GameMap map;
    NpcMovement ai;
    Canvas canvas;
    GraphicsContext context;
    Label infoLabel;
    GridPane inventoryBar;
    GridPane ui;
    String playerName;

    public Main(String playerName) {
        this.playerName = playerName;
        map = MapLoader.loadMap(playerName);
        ai = new NpcMovement(map);
        canvas = new Canvas(
                map.getWidth()/2 * Tiles.TILE_WIDTH,
                map.getHeight()/2 * Tiles.TILE_WIDTH);
        context = canvas.getGraphicsContext2D();
        infoLabel = new Label();
        inventoryBar = new GridPane();
        ui = new GridPane();
    }

    public void start(Stage primaryStage) {
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
        primaryStage.setMinHeight(530);
        primaryStage.setMinWidth(800);
        primaryStage.centerOnScreen(); // wyśrodkowanie sceny na ekranie
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
            case K:
                map.getPlayer().openDoor();
                refresh();
                break;
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
                int windowX = cameraStopMove(playerPositionX, playerPositionY, x, y)[0];
                int windowY = cameraStopMove(playerPositionX, playerPositionY, x, y)[1];
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
        showInventaryBar();
        if (GameMap.nextMap()){
            map = MapLoader.loadMap(playerName);
            ai = new NpcMovement(map);
            refresh();
        }
        Player player = map.getPlayer();
        if (player.backpack.containItemType("crown")){
            System.out.println("WIN");
        }
        ui.add(new Label(new String(String.valueOf(map.getPlayer().getHealth()).getBytes(StandardCharsets.UTF_8))), 1, 0);
    }

    private void showInventaryBar(){
        Player player = map.getPlayer();
        for (int i=0; i<12; i++){
            inventoryBar.add(new ImageView(new Image("puste-miejsce.png", 59, 59, false, false)), i, 0);
        }
        if (player.backpack.containItemType("key")){
            inventoryBar.add(new ImageView(new Image("klucz.png", 59, 59, false, false)), 0, 0);
        }
        if (player.backpack.containItemType("cheese")){
            int countOfCheese=0;
            for (int i=0; i<player.backpack.getBackpackContent().toArray().length; i++){
                if (player.backpack.getBackpackContent().get(i) instanceof Cheese){
                    countOfCheese++;
                }
            }
            inventoryBar.add(new ImageView(new Image("ser"+countOfCheese+".png", 59, 59, false, false)), 1, 0);
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
    }

    private int[] cameraStopMove(int playerPositionX, int playerPositionY, int x, int y){
        int windowX;
        int windowY;
        if (playerPositionX<11 && playerPositionY<6){
            windowX = x;
            windowY = y;
        }else if (playerPositionX>34 && playerPositionY<6){
            windowX = x+23;
            windowY = y;
        }else if (playerPositionX<11 && playerPositionY>20){
            windowX = x;
            windowY = y+14;
        }else if (playerPositionX>34 && playerPositionY>20){
            windowX = x+23;
            windowY = y+14;
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
        return new int[]{windowX, windowY};
    }
}
