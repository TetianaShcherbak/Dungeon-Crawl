//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.BackPack;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.items.Item;


public class Player extends Actor {
    private BackPack backpack;
    private String playerView = "naked player";

    public Player(Cell cell) {
        super(cell);
        this.backpack = new BackPack(this);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        if ((nextCell.getType() == CellType.FLOOR)) {
            updateBackPackTempPocketAccordingToMove(nextCell);

            this.getCell().setCellContent(null);
            nextCell.setCellContent(this);
            this.setCell(nextCell);
        }
    }

    private void updateBackPackTempPocketAccordingToMove(Cell nextCell){
        if (backpack.getTempPocket() != null) {
            Item tempPocketItem = backpack.getTempPocket();
            if (isItemCloseToPlayer(tempPocketItem)){
                if (distanceBetweenPlayerAndItem(tempPocketItem) != 0){
                    Cell itemCell = tempPocketItem.getCell();
                    itemCell.setCellContent(tempPocketItem);
                    backpack.setTempPocket(null);
                }
            }
        }

        if (nextCell.getCellContent() instanceof Item){
            backpack.setTempPocket((Item) nextCell.getCellContent());
        }
    }

    private boolean isItemCloseToPlayer(Item item){
        // the closest items are items which placed in cells around playerPosition:
        // * * *
        // * X *
        // * * *
        // it means, items placed in neighbor cells;
        // the biggest distance in this case is distance between X and * placed in corner;
        // and the max distance is Math.sqrt(Math.pow(X1-X2,2) + Math.pow(Y1-Y2,2))
        double maxRadius = Math.sqrt(Math.pow(1,2) + Math.pow(1,2));
        return distanceBetweenPlayerAndItem(item) <= maxRadius;
    }
    private double distanceBetweenPlayerAndItem(Item item){
        int itemX = item.getCell().getX();
        int itemY = item.getCell().getY();

        int playerX = this.getX();
        int playerY = this.getY();

        return Math.sqrt(Math.pow(itemX-playerX,2) + Math.pow(itemY-playerY,2));
    }

    public void setTileName() {
        if (backpack.containItemType("helm") && backpack.containItemType("sword")){
            this.playerView = "player with sword and helm";
            return;
        }
        if (backpack.containItemType("helm")){
            this.playerView = "player with helm without sword";
            return;
        }
        if (backpack.containItemType("sword")){
            this.playerView = "player with sword without helm";
            return;
        }
        this.playerView = "naked player";
    }

    public String getTileName() {
        return this.playerView;
    }

    public BackPack getBackpack(){ return backpack; }

}
