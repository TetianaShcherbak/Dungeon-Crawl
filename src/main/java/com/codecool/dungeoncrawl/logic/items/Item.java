package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Item implements Drawable {
    private Cell cell;
    private int price = 10;
    private String description = "Item";

    public Item(Cell cell, int price) {
        this.cell = cell;
        this.price = price;
        this.cell.setCellContent(this);
    }

    public Cell getCell() {
        return this.cell;
    }

    public void setCell(Cell cell) { this.cell = cell; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
