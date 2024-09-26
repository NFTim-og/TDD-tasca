package main.java;
import java.util.Set;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        VideogamesLibrary library = new VideogamesLibrary();
        Scanner scanner = new Scanner(System.in);
        
        // User Registration
        try {
            System.out.println("Register a new user:");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            userManager.register(username, password);
            
            // User Login
            System.out.print("Login - Username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Password: ");
            String loginPassword = scanner.nextLine();
            if (userManager.login(loginUsername, loginPassword)) {
                System.out.println("Login successful!");
                // Proceed with game searching and displaying
            } else {
                System.out.println("Login failed!");
            }
            
            User joan = new User("Joan");
            Videogame videogame1 = library.find(joan, "Return to Monkey Island");
            videogame1.showData();

            User josep = new User("Josep");
            Videogame videogame2 = library.find(josep, "Return to Monkey Island");
            videogame2.showData();

            System.out.println("\n** USERS WHO HAVE CONSULTED");
            Set<User> usersWhoHaveConsulted = videogame1.getUsersWhoHaveConsulted();
            for (User user : usersWhoHaveConsulted) {
                System.out.println(user.getNickname());
            }
            
            // Search Functionality
            System.out.println("Search for games:");
            System.out.print("Enter genre (or leave blank): ");
            String genre = scanner.nextLine();
            System.out.print("Enter min price (or leave blank): ");
            String minPriceInput = scanner.nextLine();
            System.out.print("Enter max price (or leave blank): ");
            String maxPriceInput = scanner.nextLine();

            List<Videogame> results = library.searchByGenre(genre);
            if (!minPriceInput.isEmpty() && !maxPriceInput.isEmpty()) {
                float minPrice = Float.parseFloat(minPriceInput);
                float maxPrice = Float.parseFloat(maxPriceInput);
                results = library.searchByPriceRange(minPrice, maxPrice);
            }

            // Display search results
            for (Videogame game : results) {
                System.out.println(game.getName());
            }
        } finally {
            scanner.close(); // Ensure scanner is closed to avoid resource leak
        }
    }
}