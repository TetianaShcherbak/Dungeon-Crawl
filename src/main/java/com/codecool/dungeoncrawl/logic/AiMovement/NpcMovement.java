package com.codecool.dungeoncrawl.logic.AiMovement;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Ghost;
import com.codecool.dungeoncrawl.logic.actors.Goblin;
import com.codecool.dungeoncrawl.logic.actors.Monster;

public class NpcMovement {
    GameMap map;

    public NpcMovement(GameMap map) {
        this.map = map;
    }

    public void moveNpc(){
        moveGhosts();
        moveGoblins();
        moveMonsters();
    }

    private void moveGoblins(){
        for (Goblin goblin : map.getGoblins()) {
            goblin.move(1, 0);
        }
    }

    private void moveGhosts(){
        for (Ghost ghost : map.getGhosts()) {
            ghost.randomMove();

        }
    }

    private void moveMonsters(){
        for (Monster monster: map.getMonsters()) {
            monster.chaseMove();

        }
    }
}
