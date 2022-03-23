package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Goblin extends Actor {
    public Goblin(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "goblin";
    }
}