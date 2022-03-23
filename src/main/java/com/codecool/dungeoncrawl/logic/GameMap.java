//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Goblin;
import com.codecool.dungeoncrawl.logic.actors.Player;

import java.util.ArrayList;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private Goblin goblin;
    private Player player;
    private ArrayList<Goblin> goblins = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];

        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                this.cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }

    }

    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setGoblin(Goblin goblin){
        this.goblin = goblin;
    }

    public void setGoblinInitial(Goblin goblin){
        this.goblin = goblin;
        Goblin.appendGoblins(goblin);
    }

    public Goblin getGoblin(){
        return this.goblin;
    }


    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}
