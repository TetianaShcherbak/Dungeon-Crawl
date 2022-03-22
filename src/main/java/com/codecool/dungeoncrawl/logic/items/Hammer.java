package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Hammer extends Item{

    public Hammer(Cell cell, int price) {
        super(cell, price);
    }

    public String getTileName(){ return "<>"; }
}
