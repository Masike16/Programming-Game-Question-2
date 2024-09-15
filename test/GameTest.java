/*
STUDENT NAME:Masike Junior Rasenyalo
STUDENT ID:ST10452404
PROJECT NAME:Number Guessing Game 
*/
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import numbergame.java.EasyGame;
import numbergame.java.Game;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGenerateTargetNumber() {//100%
        Game game = new EasyGame();
        int targetNumber = game.generateTargetNumber();
        assertTrue("Target number should be between 1 and 10", targetNumber >= 1 && targetNumber <= 10);
    }

    @Test
    public void testPlay() throws Exception {//0%
        Game game = new EasyGame();
        String input = "5\nM\n1\n"; // simulate user input: guess 5, then return to main menu, then select easy game
        game.scanner = new Scanner(input);
        game.play(game.scanner);
        assertEquals("Score should be 1", 1, game.score);
    }

    @Test
    public void testPlayAgain() throws Exception {//0%
        Game game = new EasyGame();
        String input = "C\n5\nM\n1\n"; // simulate user input: play again, guess 5, then return to main menu, then select easy game
        game.scanner = new Scanner(input);
        game.playAgain(game.scanner);
        assertNotNull("Target number should be regenerated", game.targetNumber);
    }

    @Test
    public void testGetRules() {//100%
        Game game = new EasyGame();
        String rules = game.getRules();
        assertNotNull("Rules should not be null", rules);
        assertTrue("Rules should contain the correct text", rules.contains("Guess a number within the range."));
    }

    @Test
    public void testDisplayRules() {//100%
        Game game = new EasyGame();
        game.displayRules();
        // no assertions, just verify that it doesn't throw an exception
    }
}