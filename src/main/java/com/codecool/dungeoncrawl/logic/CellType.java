//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

public enum CellType {
    BRIDGE("bridge"),
    BRIDGESTART("bridgestart"),
    DOORCLOSE("doorclose"),
    DOOROPEN("dooropen"),
    EMPTY("empty"),
    FIRE("fire"),
    FLOOR("floor"),
    OAKS("oaks"),
    PINES("pines"),
    RIVERBODY("riverbody"),
    STAIRS("stairs"),
    BEAR("bear"),
    WALL("wall"),
    GHOST("ghost");

    private final String tileName;

    private CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return this.tileName;
    }
}
