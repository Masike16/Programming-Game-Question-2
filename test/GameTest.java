import java.util.logging.Level;
import java.util.logging.Logger;
import numbergame.java.EasyGame;
import numbergame.java.Game;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testPlayAgainContinue() {
        try {
            Game game = new EasyGame();
            game.playAgain();
            assertEquals("C", game.getChoice());
            assertTrue(game.isPlaying());
        } catch (Exception ex) {
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testPlayAgainMainMenu() {
        Game game = new EasyGame();
        game.playAgain();
        assertEquals("M", game.getChoice());
        assertFalse(game.isPlaying());
    }

    @Test
    public void testPlayAgainQuit() {
        Game game = new EasyGame();
        game.playAgain();
        assertEquals("Q", game.getChoice());
        assertFalse(game.isPlaying());
    }

    @Test
    public void testPlayAgainInvalidChoice() {
        Game game = new EasyGame();
        game.playAgain();
        assertEquals("Invalid choice. Exiting game.", game.getMessage());
        assertFalse(game.isPlaying());
    }

    @Test
    public void testDisplayRules() {
        Game game = new EasyGame();
        game.displayRules();
        assertNotNull(game.getRules());
    }

    @Test
    public void testPlay() throws Exception {
        Game game = new EasyGame();
        game.play();
        assertTrue(game.isPlaying());
    }
}