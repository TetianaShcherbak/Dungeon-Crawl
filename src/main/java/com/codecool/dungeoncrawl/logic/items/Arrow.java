package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Arrow extends Item{

    public Arrow(Cell cell, int price) {
        super(cell, price);
    }

    public String getTileName(){ return "<>"; }
}
