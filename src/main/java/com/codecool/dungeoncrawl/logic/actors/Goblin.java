package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Goblin extends Actor {
    public Goblin(Cell cell) {
        super(cell);
        this.setHealth(1);
        this.setAttackPower(1);
        this.setShield(0);
        System.out.println("goblin: " + this.getX() + "; " + this.getY());
    }

    public String getTileName() {
        return "goblin";
    }
}