package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Monster extends Ghost{
    public Monster(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "monster";
    }

    private boolean searchPlayerUp(){
        return false;
    }

    private boolean searchPlayerDown(){
        return false;
    }

    private boolean searchPlayerRight(){
        return false;
    }

    private boolean searchPlayerLeft(){
        return false;
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        if ((nextCell.getType() == CellType.FLOOR) && nextCell.getCellContent() == null){
            this.getCell().setCellContent(null);
            nextCell.setCellContent(this);
            this.setCell(nextCell);
        }
    }

    public void chaseMove(){
        if (searchPlayerDown()){
            move(0, 1);
        }
        else if (searchPlayerUp()){
            move(0, -1);
        }
        else if (searchPlayerRight()){
            move(1, 0);
        }
        else if (searchPlayerLeft()){
            move(-1, 0);
        }
    }
}
