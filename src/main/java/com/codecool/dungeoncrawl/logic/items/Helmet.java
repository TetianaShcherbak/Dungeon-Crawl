package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Helmet extends Item{

    public Helmet(Cell cell, int price) {
        super(cell, price);
    }

    public String getTileName(){ return "cheese"; }
}
