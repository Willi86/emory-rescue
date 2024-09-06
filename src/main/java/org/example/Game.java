package org.example;
import java.util.Scanner;
//Game class
public class Game {

    private Scanner scanner = new Scanner(System.in); // reading the user input
    private Player player; //instance to represent the player
    private Maze maze;//instance to represent the maze
    private MazeEmoji mazeEmoji;//instance to represent the visualization of maze

    public Game() {// Creates a class constructor for the Game class
        player = new Player(5, 4); // starting position for the player
        maze = new Maze();
        mazeEmoji = new MazeEmoji();//Initializes the mazeEmoji object
    }

    public void start() {// this is where the game starts
        System.out.println("You enter the maze. The air is thick with fog and the ground feels damp beneath your feet.");
        boolean playing = true;//True -boolean is used to start the while loop, false will end the game.

        while (playing) { //while loop
            mazeEmoji.displayMaze(player, maze);  // Display the maze with player position
            System.out.println("Choose your path: (W)UP ^, (D)Right->, (S)Down v, (A)Left <- or (Q)uit: ");
            String choice = scanner.nextLine().toUpperCase();// Here it changes the input to uppercase , as i see it in this situation if-statement and  .equalsIgnoreCase() would make the same result
            switch (choice) {//  A switch statement with 4 cases to move the player and 1 exit case, based on user input
                case "W":
                    movePlayer(-1, 0);
                    break;
                case "D":
                    movePlayer(0, 1);
                    break;
                case "S":
                    movePlayer(1, 0);
                    break;
                case "A":
                    movePlayer(0, -1);
                    break;
                case "NEW":
                    System.out.println("OK I WILL RESET THE GAME FOR YOU ");
                    Game game = new Game();
                    game.start();
                    break;
                case "Q":
                    System.out.println("You have chosen to exit the maze. Goodbye!");
                    playing = false; //terminates the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }


            if (maze.handleEvents(player)) {// Check events based on player's new position  and if the player reaches the end will end the game
                System.out.println("Congratulations! You've completed the maze and rescued Emory!");
                playing = false;
            }

            if (player.getHealth() <= 0) { // this is if the players health goes to 0 , it will end the game
                System.out.println("You've been defeated. Game Over.");
                playing = false;
            }
        }
    }

    // Method to handle player movement and boundary checking
    private void movePlayer(int movementX, int movementY) { // here the method takes 2 arguments  y and X
        int newX = player.getX() + movementX;
        int newY = player.getY() + movementY;

        // Check if the new position is a wall or out of bounds
        if (newX >= 0 && newX < 6 && newY >= 0 && newY < 7 && !maze.isWall(newX, newY)) {
            player.move(movementX, movementY);
        } else {
            System.out.println("You can't move there. It's either a wall or out of bounds.");
        }
    }


}
