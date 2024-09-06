package org.example;

import java.util.List;

public class Maze {
    private final List<int[]> walls = List.of(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4}, new int[]{0, 5}, new int[]{0, 6}, new int[]{0, 7},
            new int[]{1, 0}, new int[]{1, 7},
            new int[]{2, 0}, new int[]{2, 2}, new int[]{2, 3}, new int[]{2, 5}, new int[]{2, 7},
            new int[]{3, 0}, new int[]{3, 3}, new int[]{3, 4}, new int[]{3, 5}, new int[]{3, 6}, new int[]{3, 7},
            new int[]{4, 0}, new int[]{4, 1}, new int[]{4, 6}, new int[]{4, 7},
            new int[]{5, 0}, new int[]{5, 1}, new int[]{5, 2}, new int[]{5, 3}, new int[]{5, 5}, new int[]{5, 6}, new int[]{5, 7}
    );

    private int[] gem1 = {4, 5};
    private int[] gem2 = {2, 4};
    private int[] sword = {4, 2};
    private int[] monster = {3, 1};
    private int[] emory = {1, 1};
    private final int[] end = {2, 6};

    public boolean isWall(int x, int y) {
        for (int[] wall : walls) {
            if (wall[0] == x && wall[1] == y) {
                return true;
            }
        }
        return false;
    }

    // Getter for gem1
    public int[] getGem1() {
        return gem1;
    }

    // Getter for gem2
    public int[] getGem2() {
        return gem2;
    }

    // Getter for sword
    public int[] getSword() {
        return sword;
    }

    // Getter for monster
    public int[] getMonster() {
        return monster;
    }

    // Getter for emory
    public int[] getEmory() {
        return emory;
    }

    // Getter for the end position
    public int[] getEnd() {
        return end;
    }

    // Method to handle maze events like collecting items or encountering a monster
    public boolean handleEvents(Player player) {
        // Check for the first gem
        if (gem1 != null && player.getX() == gem1[0] && player.getY() == gem1[1]) {
            System.out.println("You found a gem!");
            gem1 = null;
            System.out.println("Checking for sword removal...");

            // Check if the sword is still in the game
            System.out.println(" \uD83D\uDE06 \uD83D\uDE06 \uD83D\uDE06The sword disappears as you pick up the gem! \uD83D\uDE06 \uD83D\uDE06 \uD83D\uDE06 \uD83D\uDE06");
            System.out.println(" \uD83E\uDD23  \uD83E\uDD23 This means Monster will kill you and end the game! \uD83E\uDD23  \uD83E\uDD23 ");
            System.out.println(" Don't worry, Write 'NEW' and the game will reset");
            sword = null; // Completely remove the sword from the maze
            player.setHasSword(false); // Player also loses the sword if they already have it
        }
        // Check for the second gem
        else if (gem2 != null && player.getX() == gem2[0] && player.getY() == gem2[1]) {
            System.out.println("You found another gem!");
            gem2 = null;
        }
        // Check for the sword
        else if (sword != null && player.getX() == sword[0] && player.getY() == sword[1]) {
            System.out.println("You found a sword!");
            player.setHasSword(true);
            sword = null;
        }
        // Check for the monster
        else if (monster != null && player.getX() == monster[0] && player.getY() == monster[1]) {
            System.out.println("A monster attacks you!");
            if (player.hasSword()) {
                System.out.println("You defeat the monster with your sword!");
                monster = null;
            } else {
                player.reduceHealth(50);
                System.out.println("The monster deals damage. Your health is now " + player.getHealth());
            }
        }
        // Check for Emory
        else if (emory != null && player.getX() == emory[0] && player.getY() == emory[1]) {
            System.out.println("You found Emory! Emory will accompany you.");
            player.rescueEmory();
            emory = null;
        }

        // Check if the player has reached the end of the maze
        return player.getX() == end[0] && player.getY() == end[1];
    }}
