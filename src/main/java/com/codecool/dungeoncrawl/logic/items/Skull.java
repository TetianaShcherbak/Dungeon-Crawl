package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skull extends Item{

    public Skull(Cell cell, int price) {
        super(cell, price);
        this.setDescription("When you see me smash someone's skull, you should know, it's my new hobby ...");
    }

    public String getTileName(){ return "skull"; }
}
