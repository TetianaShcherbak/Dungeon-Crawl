package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import java.util.ArrayList;

public class Goblin extends Actor {
    public Goblin(Cell cell) {
        super(cell);
    }
    private static ArrayList<Goblin> goblinsArray = new ArrayList<>();

    public static void appendGoblins(Goblin goblin){
        goblinsArray.add(goblin);
    }

    public static ArrayList<Goblin> getGoblinsArray(){
        return goblinsArray;
    }

    public String getTileName() {
        return "goblin";
    }
}