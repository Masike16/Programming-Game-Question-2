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

public abstract class Game {
    protected int[] previousGuesses;
    protected int targetNumber;
    protected int minRange;
    protected int maxRange;
    protected int maxAttempts;
    protected int score;
    protected int chances;
    protected Scanner scanner;

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

    protected int generateTargetNumber() {
        Random random = new Random();
        return random.nextInt(maxRange - minRange + 1) + minRange;
    }

    public void play() throws Exception {
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (or M to return to the main menu): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("M")) {
                System.out.println("Returning to the main menu.");
                returnToMainMenu();
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
                    playAgain();
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
        playAgain();
    }

    public void playAgain() throws Exception {
        System.out.println("Do you want to play again? (C)ontinue, (M)ain menu, or (Q)uit");
        String choice = scanner.next().toUpperCase();
        scanner.nextLine(); // Consume newline left-over

        if (choice.equals("C")) {
            targetNumber = generateTargetNumber();
            play();
        } else if (choice.equals("M")) {
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

    public abstract void displayRules();
}
