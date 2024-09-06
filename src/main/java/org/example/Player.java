package org.example;

public class Player { // this is the player class
    private int x;//Players x position
    private int y;//Players Y position
    private boolean hasSword = false;// boolean to check if player picked the sword,set to false
    private boolean emoryRescued = false;//same principal as sword
    private int health = 100;//player's health

    public Player(int startX, int startY) {//this constructor is for the Player class and it takes the player starts coordinate X,Y
        this.x = startX;
        this.y = startY;
    }

    public int getX() {// this is a getter method for the player's X-coordinate.
        return x;
    }

    public int getY() {// this is a getter method for the player's Y-position.
        return y;
    }

    public void move(int movementX, int movementY) {//Method to move the player
        this.x += movementX;// x movement
        this.y += movementY;
    }

    public boolean hasSword() {
        return hasSword;
    }

    public void setHasSword(boolean hasSword) {//setter method for the sword
        this.hasSword = hasSword;
    }

    public boolean isEmoryRescued() {
        return emoryRescued;
    }

    public void rescueEmory() {
        this.emoryRescued = true;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount) {
        this.health -= amount;
    }

}
