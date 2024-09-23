package main.java;
import java.time.LocalDate;

public class User {
    private final int id;
    private static int lastId = 0;

    private String nickname;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    public User(String nickname) {
        this.nickname = nickname;
        lastId++;
        this.id = lastId;
    }

    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }  

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}