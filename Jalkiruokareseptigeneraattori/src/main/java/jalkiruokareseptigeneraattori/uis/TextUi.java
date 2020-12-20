package jalkiruokareseptigeneraattori.uis;

import jalkiruokareseptigeneraattori.blogic.Recipe;
import jalkiruokareseptigeneraattori.blogic.Recipebook;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used for the older Text-based User interface
 * @author niemi
 */
public class TextUi {

    private Scanner ipReader;
    private Recipebook recipes;
    private List<Integer> commands;

    /**
     * TextUi constructor
     * @param recipes input value for Recipebook
     * @param ipReader scanner input value
     */
    public TextUi(Recipebook recipes, Scanner ipReader) {
        this.ipReader = ipReader;
        this.recipes = recipes;
        this.commands = new ArrayList<Integer>();
    }

    /**
     * Commence text-UI
     */
    public void start() {
        // UI options
        Integer chosenGrp = 0;
        System.out.println("Welcome to Dessert Picker");
        while (true) {
            this.initOptions();
            Integer option;
            do {
                System.out.print("Choose option: ");
                //String chosen = ipReader.nextLine();
                while (!ipReader.hasNextInt()) {
                    System.out.println("Please choose a number!");
                    ipReader.next(); // continue
                }
                option = ipReader.nextInt();
                //If the number is outside range print an error message.
                if (!this.commands.contains(option)) {
                    System.out.println("Please choose a valid option. Try again.");
                }
            } while (!this.commands.contains(option));
            // ok, let´s continue
            //System.out.println("Initiating command..");

            if (option == 1) {  // random recipe of all
                //System.out.println("Initiating randomizator...");
                System.out.println(recipes.getRandomRecipe());
                continue;
            }
            if (option == 2) {  // random recipe of group
                chosenGrp = this.enterValidGroup(ipReader);
                System.out.println(recipes.getRandomRecipeFromGroup(chosenGrp));
                //continue;
            }
            if (option == 3) {  // print recipe groups
                System.out.println("Printing recipe groups...");
                System.out.println(recipes.printGroups());
                System.out.println("");
                continue;
            }
            if (option == 4) {  //list group recipes
                chosenGrp = this.enterValidGroup(ipReader);
                System.out.println(recipes.printRecipes(chosenGrp));
                continue;
            }
            if (option == 5) {  //list recipebooks details
                recipes.getNumberOfRecipes();
                System.out.println("Recipebook contains " 
                        + recipes.getNumberOfRecipes() + " recipes");
                System.out.println(recipes.coutsOfRecipesPerGroup());
                
            }
            if (option == 6) {  //add recipe
                System.out.println("Creating a new recipe, please add the following details");
                System.out.print("Name: ");
                ipReader.nextLine();
                String newName = ipReader.nextLine();
                System.out.print("Name of group: ");
                //ipReader.nextLine();
                String newGrp = ipReader.nextLine();
                System.out.print("List of ingredients: ");
                //ipReader.nextLine();
                String newIngredients = ipReader.nextLine();

                //Integer newPreparation = ipReader.nextInt();
                Integer newPreparation;
                do {
                    System.out.print("Preparation time in minutes: ");
                    while (!ipReader.hasNextInt()) {
                        System.out.println("Please choose a number!");
                        ipReader.next(); // continue
                    }
                    newPreparation = ipReader.nextInt();
                } while (!this.commands.contains(option));

                try {
                    Recipe recipeToAdd = new Recipe(newName, newGrp, newIngredients, newPreparation);
                    recipes.addRecipeToBook(recipeToAdd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("New Recipe " + newName + " created and added to recipebook");
                recipes.getNumberOfRecipes();
                recipes.coutsOfRecipesPerGroup();
            }

            if (option == 9) {
                System.out.println("Thanks for using Random Dessert!!");
                break;
            }
        }
    }

    /**
     * Check for group input validity
     * @param ipReader scanner input value
     * @return valid group chosen
     */
    public Integer enterValidGroup(Scanner ipReader) {
        System.out.println("You have the following groups available:");
        System.out.println(this.recipes.printGroups());
        while (true) {
            Integer chosen;
            do {
                System.out.print("Choose group: ");
                //String chosen = ipReader.nextLine();
                while (!ipReader.hasNextInt()) {
                    System.out.println("Please choose a number!");
                    ipReader.next(); // continue
                }
                chosen = ipReader.nextInt();
                //If the number is outside range print an error message.
                if (!this.recipes.doesGroupExist(chosen)) {
                    System.out.println("Please choose a valid group. Try again.");
                }
            } while (!this.recipes.doesGroupExist(chosen));  // do until correct
            return chosen;
        }
    }

    /**
     * Initialize options 
     */
    public void initOptions() {
        // init text options
        this.commands.clear();
        this.commands.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 9));
        System.out.println("");
        System.out.println("The following options are available:");
        System.out.println("1 - Pick random dessert from any group");
        System.out.println("2 - Pick random dessert from a specific group");
        System.out.println("3 - List existing dessert groups");
        System.out.println("4 - List recipes of a group");
        System.out.println("5 - List details of recipebook");
        System.out.println("6 - Add a recipe");
        //System.out.println("7 - Change recipe to another group");
        //System.out.println("8 - Delete recipe");
        System.out.println("9 - Exit");
    }

}
