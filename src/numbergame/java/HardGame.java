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
public class HardGame extends Game {
    public HardGame() {
        super(1, 100, 10);
    }

    @Override
    public void displayRules() {
        System.out.println("Hard Game Rules:");
        System.out.println("1. Guess a number between 1 and 100.");
        System.out.println("2. You have 10 attempts to guess the number.");
    }
}
