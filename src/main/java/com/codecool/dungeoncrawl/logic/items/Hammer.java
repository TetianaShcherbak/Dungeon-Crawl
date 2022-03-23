package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Hammer extends Item{

    public Hammer(Cell cell, int price) {
        super(cell, price);
        this.setDescription("The hammer. An excellent argument in any dispute!");
    }

    public String getTileName(){ return "hammer"; }
}
