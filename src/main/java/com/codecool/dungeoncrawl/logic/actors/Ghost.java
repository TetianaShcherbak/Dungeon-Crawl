package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Ghost extends Actor{
    public Ghost(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        if ((nextCell.getType() == CellType.FLOOR)) {
            this.getCell().setCellContent(null);
            nextCell.setCellContent(this);
            this.setCell(nextCell);
        }
    }

    public String getTileName() {
        return "ghost";
    }
}
