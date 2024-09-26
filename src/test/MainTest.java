import main.java.Main;
import main.java.VideogamesLibrary;
import main.java.User;
import main.java.Videogame;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMainMethodDoesNotThrowException() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    void testMainMethodOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("** USERS WHO HAVE CONSULTED"));
        assertTrue(output.contains("Joan"));
        assertTrue(output.contains("Josep"));
    }

    @Test
    void testVideogamesLibraryState() {
        VideogamesLibrary library = new VideogamesLibrary();
        User user = new User("TestUser");
        
        // Find the game and check if it exists
        Videogame game = library.find(user, "Return to Monkey Island");
        assertNotNull(game);
        
        // Check if the game has the expected properties
        assertEquals("Return to Monkey Island", game.getName());
        assertEquals("Point and click", game.getGenre());
        assertEquals(15539, game.getPlayersNumber());
        assertEquals(22.99f, game.getPrice(), 0.001);
    }
}