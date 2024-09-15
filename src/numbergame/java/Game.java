/*
STUDENT NAME:Masike Junior Rasenyalo
STUDENT ID:ST10452404
PROJECT NAME:Number Guessing Game 
*/
package numbergame.java;

/**
 *
 * @author masik
 */
import com.sun.tools.javac.Main;
import java.util.Random;
import java.util.Scanner;
import static numbergame.java.NumberGameJava.mainMenu;

public abstract class Game {
    protected int[] previousGuesses;
    public int targetNumber;
    public int minRange;
    public int maxRange;
    public int maxAttempts;
    public int score;
    public int chances;
    public Scanner scanner;

    public Game(int minRange, int maxRange, int maxAttempts) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.maxAttempts = maxAttempts;
        this.previousGuesses = new int[maxAttempts];
        this.targetNumber = generateTargetNumber();
        this.score = 0;
        this.chances = 0;
        this.scanner = new Scanner(System.in);
    }

    public int generateTargetNumber() {
        Random random = new Random();
        return random.nextInt(maxRange - minRange + 1) + minRange;
    }

    public void play(Scanner scanner1) throws Exception {
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (or M to return to the main menu): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("m")) {
                System.out.println("Returning to the main menu.");
                mainMenu(scanner);
                return;
            }

            try {
                int guess = Integer.parseInt(input);

                if (guess < minRange || guess > maxRange) {
                    System.out.println("Invalid input. Please enter a number within the range.");
                    continue;
                }

                previousGuesses[attempts] = guess;

                if (guess == targetNumber) {
                    System.out.println(" Congratulations! You won!");
                    score++;
                    chances = attempts + 1;
                    System.out.println("It took you " + chances + " chances to get the correct answer.");
                    playAgain(scanner);
                    return;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                attempts++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or M to return to the main menu.");
            }
        }

        System.out.println("Game over. The target number was " + targetNumber);
        playAgain(scanner);
    }

    public void playAgain(Scanner scanner1) throws Exception {
        System.out.println("Do you want to play again? (C)ontinue, (M)ain menu, or (Q)uit");
        String choice = scanner.next().toUpperCase();
        scanner.nextLine(); // Consume newline left-over

        if (choice.equals("C")) {
            targetNumber = generateTargetNumber();
            play(scanner);
        } else if (choice.equals("m")) {
            returnToMainMenu();
        } else if (choice.equals("Q")) {
            System.out.println("Thanks for playing! Your final score is " + score);
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Exiting game.");
            System.exit(0);
        }
    }

    private void returnToMainMenu() throws Exception {
        Main.main(new String[0]);
    }

    public boolean isPlaying() {
        return true; // assume the game is playing until it's explicitly stopped
    }

    public String getRules() {
        return "The rules of the game are: \n" +
               "1. Guess a number within the range.\n" +
               "2. You have " + maxAttempts + " attempts to guess the correct number.\n" +
               "3. After each guess, you'll get a hint whether your guess is too high or too low.\n" +
               "4. If you guess the correct number, you win! Otherwise, the game will end after " + maxAttempts + " attempts.";
    }

    public void displayRules() {
        System.out.println(getRules());
    }
}
