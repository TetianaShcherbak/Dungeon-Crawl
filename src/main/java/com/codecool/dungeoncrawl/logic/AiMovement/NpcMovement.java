package com.codecool.dungeoncrawl.logic.AiMovement;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Goblin;

public class NpcMovement {
    public void moveNpc(){
        for (Goblin goblin : Goblin.getGoblinsArray()) {
            goblin.move(1, 0);
        }
    }
}
