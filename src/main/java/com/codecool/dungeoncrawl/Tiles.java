//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Drawable;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tiles {
    public static int TILE_WIDTH = 32;
    private static Image tileset = new Image("/tiles.png", 1086.0D, 1086.0D, true, false);
    private static Map<String, Tiles.Tile> tileMap = new HashMap();

    public Tiles() {
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tiles.Tile tile = (Tiles.Tile)tileMap.get(d.getTileName());
        context.drawImage(tileset, (double)tile.x, (double)tile.y, (double)tile.w, (double)tile.h, (double)(x * TILE_WIDTH), (double)(y * TILE_WIDTH), (double)TILE_WIDTH, (double)TILE_WIDTH);
    }

    static {
        tileMap.put("<>", new Tiles.Tile(0, 7));
        tileMap.put("bow", new Tiles.Tile(8, 28));
        tileMap.put("bridge", new Tiles.Tile(16, 5));
        tileMap.put("bridgestart", new Tiles.Tile(15, 5));
        tileMap.put("cheese", new Tiles.Tile(18, 28));
        tileMap.put("doorclose", new Tiles.Tile(3, 9));
        tileMap.put("dooropen", new Tiles.Tile(6, 9));
        tileMap.put("empty", new Tiles.Tile(0, 0));
        tileMap.put("fire", new Tiles.Tile(4, 15));
        tileMap.put("floor", new Tiles.Tile(2, 0));
        tileMap.put("hammer", new Tiles.Tile(5, 29));
        tileMap.put("helmet", new Tiles.Tile(4, 22));
        tileMap.put("key", new Tiles.Tile(16, 23));
        tileMap.put("naked player", new Tiles.Tile(25, 0));
        tileMap.put("oaks", new Tiles.Tile(3, 1));
        tileMap.put("pines", new Tiles.Tile(3, 2));
        tileMap.put("player with helm without sword", new Tiles.Tile(30, 0));
        tileMap.put("player with sword and helm", new Tiles.Tile(28, 0));
        tileMap.put("player with sword without helm", new Tiles.Tile(27, 0));
        tileMap.put("riverbody", new Tiles.Tile(8, 5));
        tileMap.put("stairs", new Tiles.Tile(2, 6));
        tileMap.put("skeleton", new Tiles.Tile(29, 6));
        tileMap.put("skull", new Tiles.Tile(1, 15));
        tileMap.put("goblin", new Tile(26, 2));
        tileMap.put("sword", new Tiles.Tile(0, 31));
        tileMap.put("bear", new Tiles.Tile(30, 8));
        tileMap.put("wall", new Tiles.Tile(10, 17));
        tileMap.put("ghost", new Tiles.Tile(24, 8));
    }

    public static class Tile {
        public final int x;
        public final int y;
        public final int w;
        public final int h;

        Tile(int i, int j) {
            this.x = i * (Tiles.TILE_WIDTH + 2);
            this.y = j * (Tiles.TILE_WIDTH + 2);
            this.w = Tiles.TILE_WIDTH;
            this.h = Tiles.TILE_WIDTH;
        }
    }
}
