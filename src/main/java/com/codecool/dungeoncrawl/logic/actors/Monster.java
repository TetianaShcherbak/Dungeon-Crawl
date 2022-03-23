package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Monster extends Ghost {
    public Monster(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "monster";
    }

    private boolean searchPlayerUp(Cell cell) {
        int start = cell.getY() - 1;
        int stop = 3;
        while (stop > 0) {
            if (cell.getGameMap().getCell(cell.getX(), start).getType() != CellType.FLOOR) {
                return false;
            }

            if (cell.getGameMap().getCell(cell.getX(), start).getCellContent() instanceof Player) {
                return true;
            }
            start -= 1;
            stop -= 1;

        }
        return false;
    }

    private boolean searchPlayerDown(Cell cell) {
        int start = cell.getY() + 1;
        int stop = 3;
        while (stop > 0) {
            if (cell.getGameMap().getCell(cell.getX(), start).getType() != CellType.FLOOR) {
                return false;
            }

            if (cell.getGameMap().getCell(cell.getX(), start).getCellContent() instanceof Player) {
                return true;
            }
            start += 1;
            stop -= 1;

        }
        return false;
    }

    private boolean searchPlayerRight(Cell cell) {
        int start = cell.getX() + 1;
        int stop = 1;
        while (stop < 4) {
            if (cell.getGameMap().getCell(start, cell.getY()).getCellContent() instanceof Player) {
                return true;
            }
            Cell neighbor = cell.getNeighbor(stop, 0);
            if (wallChase(neighbor)) {
                return false;
            }
            if (searchPlayerUp(neighbor) || searchPlayerDown(neighbor)) {
                return true;
            }
            start += 1;
            stop += 1;

        }
        return false;
    }

    private boolean searchPlayerLeft(Cell cell) {
        int start = cell.getX() - 1;
        int stop = 1;
        while (stop < 4) {
            if (cell.getGameMap().getCell(start, cell.getY()).getCellContent() instanceof Player) {
                return true;
            }
            Cell neighbor = cell.getNeighbor(-stop, 0);
            if (wallChase(neighbor)) {
                return false;
            }
            if (searchPlayerUp(neighbor) || searchPlayerDown(neighbor)) {
                return true;
            }
            start -= 1;
            stop += 1;

        }
        return false;
    }

    private boolean wallChase(Cell neighbor) {
        if (searchPlayerUp(neighbor) && (neighbor.getType() != CellType.FLOOR
                || (neighbor.getType() == CellType.FLOOR && neighbor.getCellContent() != null))) {
            move(0, -1);
            return true;
        }
        if (searchPlayerDown(neighbor) && (neighbor.getType() != CellType.FLOOR
                || (neighbor.getType() == CellType.FLOOR && neighbor.getCellContent() != null))) {
            move(0, 1);
            return true;
        }
        return false;
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = this.getCell().getNeighbor(dx, dy);
        if ((nextCell.getType() == CellType.FLOOR) && nextCell.getCellContent() == null) {
            this.getCell().setCellContent(null);
            nextCell.setCellContent(this);
            this.setCell(nextCell);
        }
    }

    public void chaseMove() {
        if (searchPlayerDown(getCell())) {
            move(0, 1);
        } else if (searchPlayerUp(getCell())) {
            move(0, -1);
        } else if (searchPlayerRight(getCell())) {
            move(1, 0);
        } else if (searchPlayerLeft(getCell())) {
            move(-1, 0);
        }
    }
}
