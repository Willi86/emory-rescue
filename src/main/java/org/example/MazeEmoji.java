package org.example;

public class MazeEmoji {

    // Method to display the maze with player, gems , monster, sword, Emory and the end door as emojis, walls are W
    public void displayMaze(Player player, Maze maze) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (player.getX() == i && player.getY() == j) {
                    System.out.print("\uD83D\uDE31 ");  // Player's position
                } else if (maze.isWall(i, j)) {
                    System.out.print("W ");  // Wall
                } else if (maze.getGem1() != null && maze.getGem1()[0] == i && maze.getGem1()[1] == j) {
                    System.out.print("\uD83D\uDC8E ");  // Gem 1
                } else if (maze.getGem2() != null && maze.getGem2()[0] == i && maze.getGem2()[1] == j) {
                    System.out.print("\uD83D\uDC8E ");  // Gem 2
                } else if (maze.getSword() != null && maze.getSword()[0] == i && maze.getSword()[1] == j) {
                    System.out.print("\uD83D\uDDE1 ");  // Sword
                } else if (maze.getMonster() != null && maze.getMonster()[0] == i && maze.getMonster()[1] == j) {
                    System.out.print("\uD83D\uDC7A ");  // Monster
                } else if (maze.getEmory() != null && maze.getEmory()[0] == i && maze.getEmory()[1] == j) {
                    System.out.print("\uD83E\uDDD2 ");  // Emory
                } else if (maze.getEnd()[0] == i && maze.getEnd()[1] == j) {
                    System.out.print("\uD83D\uDEAA ");  // End
                } else {
                    System.out.print("  ");  // Empty space
                }
            }
            System.out.println();
        }
    }
}
