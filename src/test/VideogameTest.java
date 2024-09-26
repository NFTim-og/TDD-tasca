import main.java.Videogame;
import main.java.User;
import main.java.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideogameTest {

    private Videogame videogame;

    @BeforeEach
    void setUp() {
        videogame = new Videogame("Test Game");
    }

    @Test
    void testConstructorAndGetName() {
        assertEquals("Test Game", videogame.getName());
    }

    @Test
    void testSetAndGetGenre() {
        videogame.setGenre("Action");
        assertEquals("Action", videogame.getGenre());
    }

    @Test
    void testSetAndGetPlayersNumber() {
        videogame.setPlayersNumber(100);
        assertEquals(100, videogame.getPlayersNumber());
    }

    @Test
    void testSetAndGetPrice() {
        videogame.setPrice(59.99f);
        assertEquals(59.99f, videogame.getPrice(), 0.001);
    }

    @Test
    void testSetAndGetPlatforms() {
        videogame.setPlatforms("PS5, Xbox Series X, PC");
        assertEquals("PS5, Xbox Series X, PC", videogame.getPlatforms());
    }

    @Test
    void testSetAndGetSetting() {
        videogame.setSetting("Fantasy");
        assertEquals("Fantasy", videogame.getSetting());
    }

    @Test
    void testSetAndGetRecommendedAgePEGI() {
        videogame.setRecommendedAgePEGI("16");
        assertEquals("16", videogame.getRecommendedAgePEGI());
    }

    @Test
    void testSetAndGetSpecificContentPEGI() {
        videogame.setSpecificContentPEGI("Violence");
        assertEquals("Violence", videogame.getSpecificContentPEGI());
    }

    @Test
    void testSetAndGetRequirements() {
        String requirements = "CPU: Intel i5, RAM: 8GB";
        videogame.setRequirements(requirements);
        assertEquals(requirements, videogame.getRequirements());
    }

    @Test
    void testAddUsersWhoHaveConsulted() {
        User user1 = new User("User1");
        User user2 = new User("User2");

        videogame.addUsersWhoHaveConsulted(user1);
        videogame.addUsersWhoHaveConsulted(user2);

        assertTrue(videogame.getUsersWhoHaveConsulted().contains(user1));
        assertTrue(videogame.getUsersWhoHaveConsulted().contains(user2));
        assertEquals(2, videogame.getUsersWhoHaveConsulted().size());
    }

    @Test
    void testAddReview() {
        Review review = new Review("User1", "Great game!", 5);
        videogame.addReview(review);
        assertEquals(1, videogame.getReviews().size());
        assertEquals("Great game!", videogame.getReviews().get(0).getComment());
    }

    @Test
    void testAverageRating() {
        videogame.addReview(new Review("User1", "Great game!", 5));
        videogame.addReview(new Review("User2", "Not bad", 3));
        assertEquals(4.0, videogame.getAverageRating(), 0.01);
    }

    @Test
    void testNoReviewsAverageRating() {
        assertEquals(0.0, videogame.getAverageRating(), 0.01);
    }
}