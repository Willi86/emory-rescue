package org.example;

import java.util.Scanner;

public class Main {

    // ANSI escape codes for colored text
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m"; // Resets the color
/*

Ghost: \uD83D\uDC7B (👻)
Skull: \uD83D\uDC80 (💀) Skull and Crossbones: \u2620 (☠️) Jack-o'-Lantern: \uD83C\uDF83 (🎃) Ogre: \uD83D\uDC79 (👹) Goblin: \uD83D\uDC7A (👺)
Spider: \uD83D\uDD77 (🕷️) Spider Web: \uD83D\uDD78 (🕸️) Bat: \uD83E\uDD87 (🦇) Screaming Face: \uD83D\uDE31 (😱) Coffin: \u26B0 (⚰️) Zombie: \uD83E\uDDDF (🧟)
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Displaying a simple ASCII banner
        System.out.println(PURPLE + "=======\uD83D\uDC80=========\uD83D\uDC80========\uD83D\uDC80=======");

        System.out.println(" \n" + "\uD83E\uDD87  WELCOME TO THE SEARCH FOR " +"\uD83E\uDD87 ");
        System.out.println("         " + CYAN + "EMORY" + PURPLE +"\uD83C\uDF83  ");
        System.out.println("======\uD83D\uDC80==========\uD83D\uDC80========\uD83D\uDC80=======" + RESET);

        System.out.println("\uD83D\uDC80"+ GREEN + "You stand at the entrance of a dark and winding maze," + RESET + "\uD83D\uDC80" +  GREEN +"\n" +
                "the echoes of the wind sending a chill down your spine." + "\n" +
                "A child named Emory " + RESET + "\uD83D\uDE31 " + GREEN + "is lost inside, and you must find him." + "\n" +
                "The path ahead is full of dangers,"+ RESET + "\uD83D\uDC7A" + GREEN + "\n" +
                "but riches and glory await those who dare to explore." + RESET+ "\uD83C\uDFC6"+"\uD83D\uDCB0");

        System.out.println(YELLOW + "\nPress Enter to start the game OR type " +RED +" 'Exit' /E / e "+ YELLOW+ "to quit." + GREEN );
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Exit") || input.equalsIgnoreCase("e")) {
            System.out.println(RED + "Exiting the game. Goodbye!" + RESET);
            System.exit(0); // Exit the game
        } else {
            Game game = new Game();
            game.start();
        }
    }
}
