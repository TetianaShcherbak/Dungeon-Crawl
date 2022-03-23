package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sword extends Item{

    public Sword(Cell cell, int price) {
        super(cell, price);
        this.setDescription("Never give a sword to a man who can't dance! So... Your bad.");
    }

    public String getTileName(){ return "sword"; }
}
