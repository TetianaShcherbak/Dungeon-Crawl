//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health;
    private int attackPower;
    private int shield;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setCellContent(this);
    }

    public void move(int dx, int dy) {}

    public void attack(Actor enemy){
        int health = this.getHealth();
        int attackPower = this.getAttackPower();
        int shield = this.getShield();
        System.out.println(this.getTileName() + ": health = "+ health + "; attack = " + attackPower + "; shield = " + shield);

        int enemyHealth = enemy.getHealth();
        int enemyAttackPower = enemy.getAttackPower();
        int enemyShield = enemy.getShield();
        System.out.println(enemy.getTileName() + ": health = "+ enemyHealth + "; attack = " + enemyAttackPower + "; shield = " + enemyShield);

        int shieldDifference = Math.min(shield - enemyAttackPower, 0);
        int healthDifference = (shieldDifference == 0) ? health : (health - shieldDifference);
        this.setHealth(healthDifference);
        this.setShield(shieldDifference);
        System.out.println(this.getTileName() + ": newHealth = "+ this.getHealth() + "; newAttack = " + this.getAttackPower() + "; newShield = " + this.getShield());

        int enemyShieldDifference = Math.min(enemyShield - attackPower, 0);
        int enemyHealthDifference = (enemyShieldDifference == 0) ? enemyHealth : (enemyHealth - enemyShieldDifference);
        enemy.setHealth(enemyHealthDifference);
        enemy.setShield(enemyShieldDifference);
        System.out.println(enemy.getTileName() + ": newHealth = "+ enemy.getHealth() + "; newAttack = " + enemy.getAttackPower() + "; newShield = " + enemy.getShield());

    }

    public boolean isDead(){ return this.health<=0; }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int healthUp) { this.health = getHealth() + healthUp; }

    public Cell getCell() { return this.cell; }

    public void setCell(Cell cell) { this.cell = cell; }

    public int getX() {
        return this.cell.getX();
    }

    public int getY() { return this.cell.getY(); }

    public void setHealth(int health) { this.health = health; }

    public int getAttackPower() {  return attackPower; }

    public void setAttackPower(int attackPower) { this.attackPower = attackPower; }

    public int getShield() { return shield; }

    public void setShield(int shield) { this.shield = shield; }
}
