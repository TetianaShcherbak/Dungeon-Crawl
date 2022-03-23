package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Arrow extends Item{
    public Arrow(Cell cell, int price) {
        super(cell, price);
        this.setDescription("There must be a means of getting coconuts with an arrow! Or someone's heads ...");
    }

    public String getTileName(){ return "<>"; }
}
