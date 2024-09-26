import main.java.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    @Test
    void testRegisterNewUser() {
        assertTrue(userManager.register("testUser", "password123"));
        assertFalse(userManager.register("testUser", "password456")); // Duplicate username
    }

    @Test
    void testLoginSuccessful() {
        userManager.register("testUser", "password123");
        assertTrue(userManager.login("testUser", "password123"));
    }

    @Test
    void testLoginFailed() {
        userManager.register("testUser", "password123");
        assertFalse(userManager.login("testUser", "wrongPassword"));
        assertFalse(userManager.login("nonExistentUser", "password123"));
    }
}
