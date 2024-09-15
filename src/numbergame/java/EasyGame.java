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
public class EasyGame extends Game {//easy game mode 
    public EasyGame() {
        super(1, 10, 5);//most guessable numbers
    }

    @Override
    public void displayRules() {
        System.out.println("Easy Game Rules:");
        System.out.println("1. Guess a number between 1 and 10.");
        System.out.println("2. You have 5 attempts to guess the number.");
    }
}
