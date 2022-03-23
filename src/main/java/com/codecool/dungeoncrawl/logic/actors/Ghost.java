package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Ghost extends Actor{
    public Ghost(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "ghost";
    }
}
