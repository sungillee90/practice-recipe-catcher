package app;

import app.users.Registered;
import app.users.User;

public class App {
    public static void main(String[] args) {
        User sung = new Registered("Sung Il", "lee", "myEmail@mail.com", "sungil.lee90", "1234");
        System.out.println("sung = " + sung);
    }
}

// In this App class, I will have "main" method called App to run the methods
