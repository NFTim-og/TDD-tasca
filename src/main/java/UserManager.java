package main.java;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> userDatabase; // username -> password

    public UserManager() {
        userDatabase = new HashMap<>();
    }

    public boolean register(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return false; // Username already exists
        }
        userDatabase.put(username, password);
        return true; // Registration successful
    }

    public boolean login(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}