package com.codecool.dungeoncrawl.logic.AiMovement;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Ghost;
import com.codecool.dungeoncrawl.logic.actors.Goblin;

public class NpcMovement {
    GameMap map;

    public NpcMovement(GameMap map) {
        this.map = map;
    }

    public void moveNpc(){
        moveGhosts();
        moveGoblins();

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
}
