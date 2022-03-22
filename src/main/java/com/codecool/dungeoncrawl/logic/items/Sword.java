package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sword extends Item{

    public Sword(Cell cell, int price) {
        super(cell, price);
    }

    public String getTileName(){ return "sword"; }
}
