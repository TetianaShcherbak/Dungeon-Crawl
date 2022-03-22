//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

public enum CellType {
    PLAYER("naked player"),
    PLAYER1("player with helm without sword"),
    PLAYER2("player with sword without helm"),
    PLAYER3("player with sword and helm"),
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    SWORD("sword"),
    CHEESE("cheese"),
    KEY("key"),
    HAMMER("hammer"),
    HELMET("helmet"),
    BOW("bow"),
    RIVERBODY("riverbody"),
    PINES("pines"),
    BRIDGE("bridge"),
    BRIDGESTART("bridgestart"),
    DOORCLOSE("doorclose"),
    DOOROPEN("dooropen"),
    STAIRS("stairs"),
    ARROW("<>"),
    SKULL("skull"),
    FIRE("fire"),
    OAKS("oaks"),
    SKELETON("skeleton");

    private final String tileName;

    private CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return this.tileName;
    }
}
