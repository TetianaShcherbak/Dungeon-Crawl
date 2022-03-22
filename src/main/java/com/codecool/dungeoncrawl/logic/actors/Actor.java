//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setCellContent(this);
    }

    public void move(int dx, int dy) {}

    public int getHealth() {
        return this.health;
    }

    public Cell getCell() { return this.cell; }

    public void setCell(Cell cell) { this.cell = cell; }

    public int getX() {
        return this.cell.getX();
    }

    public int getY() { return this.cell.getY(); }
}
