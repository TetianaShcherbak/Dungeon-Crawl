//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.BackPack;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.items.Cheese;
import com.codecool.dungeoncrawl.logic.items.Item;


public class Player extends Actor {
    public BackPack backpack;
    private String playerView = "naked player";
    private String name;

    public Player(Cell cell, String name) {
        super(cell);
        this.setHealth(5);
        this.setAttackPower(1);
        this.setShield(1);
        this.backpack = new BackPack(this);
        this.name = name;
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        if ((nextCell.getType() == CellType.FLOOR) ||
                (nextCell.getType() == CellType.DOOROPEN) ||
                (nextCell.getType() == CellType.STAIRS) ||
                (nextCell.getType() == CellType.CASTLE1) ||
                (nextCell.getType() == CellType.CASTLE2) ||
                (nextCell.getType() == CellType.CASTLE3) ||
                (nextCell.getType() == CellType.CASTLE4) ||
                (nextCell.getType() == CellType.CASTLE5) ||
                (nextCell.getType() == CellType.CASTLE6) ||
                (nextCell.getType() == CellType.CASTLE7) ||
                (nextCell.getType() == CellType.CASTLE8)) {
            updateBackPackTempPocketAccordingToMove(nextCell);
            System.out.println("nextCell: " + nextCell.getX() + "; " + nextCell.getY());
            System.out.println("player: " + this.getX() + "; " + this.getY());

            System.out.println(nextCell.getActor());
            if (nextCell.getActor() instanceof Actor){
                attack(nextCell.getActor());
                if(isDead()){
                    this.getCell().setCellContent(null);
                    System.out.println("Game over!");
                    return;
                }
            }

            this.getCell().setCellContent(null);
            nextCell.setCellContent(this);
            this.setCell(nextCell);
        }
    }

    public void openDoor(){
        if (backpack.getItemFromBackpack("key") == null) {
            return;
        }
        if (getDoorCellIfCloseTo() == null){ return; }

        Item key = backpack.getItemFromBackpack("key");
        backpack.removeItem(key);
        getDoorCellIfCloseTo().setType(CellType.DOOROPEN);
    }

    private Cell getDoorCellIfCloseTo(){
        Cell currentPlayerCell = this.getCell();

        if(currentPlayerCell.getNeighbor(0,-1).getType() == CellType.DOORCLOSE) { // upDirectionCell
            return currentPlayerCell.getNeighbor(0,-1);
        }
        if(currentPlayerCell.getNeighbor(0,1).getType() == CellType.DOORCLOSE) {  // downDirectionCell
            return currentPlayerCell.getNeighbor(0,1);
        }
        if (currentPlayerCell.getNeighbor(-1,0).getType() == CellType.DOORCLOSE) { // leftDirectionCell
            return currentPlayerCell.getNeighbor(-1,0);
        }
        if(currentPlayerCell.getNeighbor(1,0).getType() == CellType.DOORCLOSE) { // rightDirectionCell
            return currentPlayerCell.getNeighbor(1,0);
        }
        return null;
    }

    public void healthUp(){
        if(this.backpack.containItemType("cheese")){
            Item cheese = this.backpack.getItemFromBackpack("cheese");
            this.setHealth(this.getHealth() + cheese.getHealthUpper());
            this.backpack.removeItem(cheese);
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
        if (backpack.containItemType("crown")){
            this.playerView = "player with crown";
            return;
        }
        if (backpack.containItemType("helmet") && backpack.containItemType("sword") && backpack.containItemType("sword1")){
            this.playerView = "player with two sword and helm";
            return;
        }
        if (backpack.containItemType("sword") && backpack.containItemType("sword1")){
            this.playerView = "player with two sword";
            return;
        }
        if (backpack.containItemType("helmet") && backpack.containItemType("sword") || backpack.containItemType("helmet") && backpack.containItemType("sword1")){
            this.playerView = "player with sword and helm";
            return;
        }
        if (backpack.containItemType("helmet")){
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

    public String getName() {
        return name;
    }
}
