import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.User;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class UserTest {

    User user;
    static final String userName = "userName";

    @BeforeEach
    void setUp() {
        user = new User(userName);
    }

    @Test
    void getNickname() {
        assertEquals(user.getNickname(), userName);
    }

    @Test
    void testIdAssignment() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        assertNotEquals(user1.getId(), user2.getId());
        assertEquals(user1.getId() + 1, user2.getId());
    }

    @Test
    void testGetNickname() {
        User user = new User("testUser");
        assertEquals("testUser", user.getNickname());
    }

    @Test
    void testSetAndGetOtherFields() {
        User user = new User("testUser");
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        user.setBirthDate(birthDate);

        assertEquals("John", user.getName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals(birthDate, user.getBirthDate());
    }

    @Test
    void testSetName() {
        user.setName("John");
        assertEquals("John", user.getName());
    }

    @Test
    void testSetLastName() {
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    void testSetEmail() {
        user.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    void testSetBirthDate() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        user.setBirthDate(birthDate);
        assertEquals(birthDate, user.getBirthDate());
    }

    @Test
    void testSetNickname() {
        User user = new User("oldNickname");
        user.setNickname("newNickname");
        assertEquals("newNickname", user.getNickname());
    }

    @Test
    void testGetters() {
        User user = new User("testUser");
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        user.setBirthDate(birthDate);

        assertEquals("John", user.getName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals(birthDate, user.getBirthDate());
    }

    @Test
    void testSetAndGetName() {
        user.setName("John");
        assertEquals("John", user.getName());
    }

    @Test
    void testSetAndGetLastName() {
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    void testSetAndGetEmail() {
        user.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    void testSetAndGetBirthDate() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        user.setBirthDate(birthDate);
        assertEquals(birthDate, user.getBirthDate());
    }
}