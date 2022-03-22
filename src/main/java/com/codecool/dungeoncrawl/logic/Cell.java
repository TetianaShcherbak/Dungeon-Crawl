//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

public class Cell implements Drawable {
    private CellType type;
    private Drawable cellContent;
    private GameMap gameMap;
    private int x;
    private int y;

    Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return this.type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setCellContent(Drawable cellContent) {
        this.cellContent = cellContent;
    }

    public Drawable getCellContent() {
        return this.cellContent;
    }

    public Cell getNeighbor(int dx, int dy) {
        return this.gameMap.getCell(this.x + dx, this.y + dy);
    }

    public String getTileName() {
        return this.type.getTileName();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
