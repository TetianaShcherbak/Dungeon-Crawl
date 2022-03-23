package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

import java.util.Random;

public class Ghost extends Actor{
    private Random random = new Random();
    public Ghost(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
            this.getCell().setCellContent(null);
            nextCell.setCellContent(this);
            this.setCell(nextCell);
    }

    public void randomMove(){
        while (true){
            int dx = random.nextInt( 2);
            int dy = Math.abs(1 - dx);
            Cell nextCell = this.getCell().getNeighbor(dx, dy);
            if ((nextCell.getType() == CellType.FLOOR) || (nextCell.getType() == CellType.WALL)
                    || (nextCell.getType() == CellType.PINES) || (nextCell.getType() == CellType.RIVERBODY)){
                move(dx, dy);
                break;
            }
        }
    }

    public String getTileName() {
        return "ghost";
    }
}
