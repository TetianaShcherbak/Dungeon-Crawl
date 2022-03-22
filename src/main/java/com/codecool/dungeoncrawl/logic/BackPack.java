package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;

public class BackPack {
    private Player owner;
    private Item tempPocket;
    private int size = 10;
    private ArrayList<Item> backpack = new ArrayList<>();

    public BackPack(Player owner) {
        this.owner = owner;
    }

    public void addItemToBackPack(){
        if(backpack != null){
           // System.out.println(backpack.toString());
        }

        if (tempPocket != null){
            if (backpack.size() < size){
                backpack.add(tempPocket);
                owner.setTileName();
                setTempPocket(null);
            }
        }
        //System.out.println(backpack.toString());
    }

    public ArrayList<Item> getBackpackContent() { return backpack; }

    public Player getOwner() { return owner; }

    public boolean hasConcreteItem(Item item){
        for (Item backpackItem: backpack){
            if(backpackItem.equals(item)){
                return true;
            }
        }
        return false;
    }

    public boolean containItemType (String type){
        for (Item backpackItem: backpack){
            if(backpackItem.getTileName().equals(backpackItem.getTileName())){
                return true;
            }
        }
        return false;
    }

    public Item getTempPocket() {  return tempPocket; }

    public void setTempPocket(Item tempPocket) { this.tempPocket = tempPocket; }


    //todo: wypierdolić
    @Override
    public String toString() {
        String result =  "BackPack{" +
                ", size=" + size +
                ", tempPocket=" + tempPocket +
                ", backpack: ";
        if (backpack != null){
            for (Item item: backpack) {
                result += item + "\n";
            }
        }
        result +="}";
        return result;
    }
}
