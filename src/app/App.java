package app;

import app.recipes.Ingredient;
import app.recipes.Recipe;
import app.users.Guest;
import app.users.Registered;
import app.users.User;
import app.util.Input;

import java.util.ArrayList;

public class App {

    static ArrayList<Ingredient> sampleIngredients;
    static ArrayList<Recipe> recipes = new ArrayList<>();

    public static void main(String[] args) {
        Registered sung = new Registered("Sung Il", "lee", "myEmail@mail.com", "sungil.lee90", "1234");

        buildDummyData();

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
                System.out.println("Logged in");

                do{
                    recipeMenu();
                    switch(input.getInt(1,2)) {
                        case 1:
                            // view recipes
                            for (Recipe recipe: recipes) {
                                recipe.display();
                            }
                            System.out.println("recipes = " + recipes.toString());
                            break;
                        case 2:
                            String recipeName = input.getString("What's the name of the recipe?");
                            System.out.println("What's the time of the recipe?");
                            double recipeTime = input.getDouble();
                            String recipeInstructions = input.getString("What's the instructions of the recipe?");
                            String timeUnit = input.getString("What's the unit of the recipe?");

                            Recipe newRecipe = new Recipe(recipeName, recipeTime, recipeInstructions,timeUnit, sampleIngredients, sung);
                            recipes.add(newRecipe);
                            break;
                    }
                    System.out.println("Continue?");
                } while ((input.yesNo()));
                break;

            case 3:
                System.out.println("Proceeding as Guest.");
                currentUser = new Guest(input.getString("First Name: "), input.getString("Last Name: "), input.getString("email: "));
                break;
        }

        System.out.println("currentUser = " + currentUser);

    }
    public static void recipeMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. View a recipe");
        System.out.println("2. Create a recipe");
    }
    public static void buildDummyData() {
        sampleIngredients = new ArrayList<>();
        sampleIngredients.add(new Ingredient("Eggs", 3, "egg"));
        sampleIngredients.add(new Ingredient("Cheese", 1, "kg"));

    }
}

// In this App class, I will have "main" method called App to run the methods
