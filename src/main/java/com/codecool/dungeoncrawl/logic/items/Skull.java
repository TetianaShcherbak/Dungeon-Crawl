package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skull extends Item{

    public Skull(Cell cell, int price) {
        super(cell, price);
    }

    public String getTileName(){ return "skull"; }
}
