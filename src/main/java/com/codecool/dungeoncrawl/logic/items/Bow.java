package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Bow extends Item{

    public Bow(Cell cell, int price) {
        super(cell, price);
        this.setDescription("Now I can take from the rich and give to the poor, but I wouldn't!");
    }

    public String getTileName(){ return "bow"; }
}
