//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        String nakedPlayer = "naked player";
        String player1 = "player with helm without sword";
        String player2 = "player with sword without helm";
        String player3 = "player with sword and helm";
        return nakedPlayer;
    }
}
