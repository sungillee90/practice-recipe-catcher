package app;

import app.users.Guest;
import app.users.Registered;
import app.users.User;
import app.util.Input;

public class App {
    public static void main(String[] args) {
        User sung = new Registered("Sung Il", "lee", "myEmail@mail.com", "sungil.lee90", "1234");
        System.out.println("sung = " + sung);
        Input input = new Input(); // Instance of input due to there are no static inside of Input class.


        System.out.println("Welcome to Recipe Catcher");
        // Register or Login or Proceed as Guest
        System.out.println("How do you want to proceed?\n" +
                "1 - Register as a new user\n" +
                "2 - Login\n" +
                "3 - Proceed as Guest");

        int userStatus = input.getInt(1, 3);

        User currentUser = null; // must initialized to begin.

        switch (userStatus) {
            case 1:
                System.out.println("Register as a new user.");

                String firstName = input.getString("First Name: ");
                String lastName = input.getString("Last Name: ");
                String email = input.getString("email: ");
                String username = input.getString("username: ");
                String password = input.getString("password: ");

                currentUser = new Registered(firstName, lastName, email, username, password);

                break;
            case 2:
                System.out.println("Login System is not implemented yet");
                currentUser = sung;
                break;
            case 3:
                System.out.println("Proceeding as Guest.");
                currentUser = new Guest(input.getString("First Name: "), input.getString("Last Name: "), input.getString("email: "));
                break;
        }

        System.out.println("currentUser = " + currentUser);

    }
}

// In this App class, I will have "main" method called App to run the methods
