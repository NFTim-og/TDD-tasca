import main.java.VideogamesLibrary;
import main.java.Videogame;
import main.java.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideogamesLibraryTest {

    private VideogamesLibrary library;

    @BeforeEach
    void setUp() {
        library = new VideogamesLibrary();
    }

    @Test
    void testFindExistingGame() {
        User user = new User("TestUser");
        Videogame game = library.find(user, "Return to Monkey Island");
        assertNotNull(game);
        assertEquals("Return to Monkey Island", game.getName());
    }

    @Test
    void testFindNonExistingGame() {
        User user = new User("TestUser");
        Videogame game = library.find(user, "Non-existing Game");
        assertNull(game);
    }

    @Test
    void testUserAddedToConsultedList() {
        User user = new User("TestUser");
        Videogame game = library.find(user, "Return to Monkey Island");
        assertTrue(game.getUsersWhoHaveConsulted().contains(user));
    }
}