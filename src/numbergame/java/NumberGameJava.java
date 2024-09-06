/*
STUDENT NAME:Masike Junior Rasenyalo
STUDENT ID:ST10452404
PROJECT NAME:Number Guessing Game 
*/
package numbergame.java;

import java.util.Scanner;

/**
 *
 * @author masik
 */
public class NumberGameJava {
    
    public static void main(String[] args) throws Exception {// exceptions still having toble loading in
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select a difficulty level:");
            System.out.println("1. Easy");
            System.out.println("2. Hard");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            Game game;

            switch (choice) {
                case 1:
                    game = new EasyGame();
                    break;
                case 2:
                    game = new HardGame();
                    break;
                case 3:
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            game.displayRules();
            game.play();
        }
    }
}

