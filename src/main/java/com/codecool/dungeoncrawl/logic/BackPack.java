package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.Locale;

public class BackPack {
    private Player owner;
    private Item tempPocket;
    private int size = 10;
    private ArrayList<Item> backpack = new ArrayList<>();

    public BackPack(Player owner) {
        this.owner = owner;
    }

    public void addItemToBackPack(){
        if (tempPocket != null){
            if (backpack.size() < size){
                backpack.add(tempPocket);
                updatePlayerParameters(tempPocket);
                owner.setTileName();
                setTempPocket(null);
            }
        }
    }

    public Item getItemFromBackpack(String type){
        if(containItemType(type)){
            for(Item item: backpack){
                if(item.getTileName().equals(type)){
                    return item;
                }
            }
        }
        return null;
    }

    public void removeItem(Item item){
        backpack.remove(item);
    }

//    public void dropLastGottenItem(){
//        Item lastItem = backpack.get(backpack.size() - 1);
//        if (isPlayerOnItemPosition(lastItem)){
//            backpack.remove(backpack.size() - 1);
//            setTempPocket(lastItem);
//        }
//    }

    private void updatePlayerParameters(Item item){
        int health = owner.getHealth();
        int attackPower = owner.getAttackPower();
        int shield = owner.getShield();

        owner.setHealth(health + item.getHealthUpper());
        owner.setAttackPower(attackPower + item.getAttackUpper());
        owner.setShield(shield + item.getShieldUpper());
    }

    private boolean isPlayerOnItemPosition(Item item){
        int playerX = owner.getCell().getX();
        int playerY = owner.getCell().getY();

        int itemX = item.getCell().getX();
        int itemY = item.getCell().getY();

        return (playerX == itemX) && (playerY == itemY);
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
        if (backpack == null){
            return false;
        }
        for (Item backpackItem: backpack){
            if(backpackItem.getTileName().equals(type)){
                return true;
            }
        }
        return false;
    }

    public Item getTempPocket() {  return tempPocket; }

    public void setTempPocket(Item tempPocket) { this.tempPocket = tempPocket; }


    public String showItemInfo(){ //todo: ??
        Item item = tempPocket;
        String info = "";

        if (item != null){
            String itemName = item.getTileName();
            String price = String.valueOf(item.getPrice());
            String description = item.getDescription();

            info += "You reached " + itemName.toUpperCase() + ": \n";
            info += "Price:\t" + price + " coins(s).\n";
            info += "\\u001B31;1m" + description + "\n";
        }

        return  info;
    }

    public String showBackPackContent(){ //todo: ??
        String info;
        if (backpack == null){
            info = "Your backpack is empty now!";
            return info;
        }

        info = "Your backpack content:\n";
        for(int i=0; i<size; i++){
            info += "\t" + (i + 1) + "/" + (size + 1) + "  ";
            info += backpack.get(i).getTileName() + ": ";
            info +=backpack.get(i).getPrice() + " coin(s)\n";
        }
        return info;
    }


}
