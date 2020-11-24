package jalkiruokareseptigeneraattori;

import java.util.Locale;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Recipebook {
// This class stores recipes and provides necessary methods

    ArrayList<Recipe> recipes;
    HashMap<String, Integer> groups;

    public Recipebook() {
        recipes = new ArrayList<>();
        groups = new HashMap<>();
        this.initializeRecipes(this);
    }

    public void addGroup(String igroup) {
        //check if group value exists
        if (!groups.containsKey(igroup.toLowerCase())) {
            //key does not exist, needs to be created
            groups.put(igroup.toLowerCase(), groups.size() + 1);
        }
    }

    public void addRecipeToBook(Recipe res) {
        this.recipes.add(res);
        this.addGroup(res.getGroup());

    }

    public Recipe getRecipeFromBook(Integer idx) {
        if (idx <= this.recipes.size()) {
            return this.recipes.get(idx);
        } else {
            return null;
            
        }
    }

    public Recipe getRandomRecipe(String igroup) {
        // Create shortlist of recipes of chosen group
        ArrayList<Recipe> shortList = new ArrayList<>();
        for (Recipe res : this.recipes) {
            if (res.group == igroup) {
                shortList.add(res);
            }
        }
        // pick random recipe of chosen group
        if (shortList.size() == 0) {
            return null;
        } else {
            Random rand = new Random();
            Integer randomRecipe = rand.nextInt(shortList.size());
            return shortList.get(0);
        }
    }

    public void printGroups() {
        //check if key exists
        for (String key : groups.keySet()) {
            System.out.println(key + " - " + groups.get(key));
        }
    }

    public void printRecipes(String igroup) {
        for (Recipe res : this.recipes) {
            if (res.group == igroup) {
                System.out.printf("%s ", res);
            }
        }
    }

    public void initializeRecipes(Recipebook resbook) {
        boolean firstLine = true;

        try (Scanner reader = new Scanner(Paths.get("recipes.txt"))) {

            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                // skip first line
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                

                // skip if empty
                if (row.isEmpty()) {
                    continue;
                }

                String[] col = row.split(Pattern.quote("|"));
                String nimi = col[0];
                String group = col[1];

                String ingredients = col[2];
                int preparation = Integer.valueOf(col[3].replaceAll("\\s+", ""));
                String image = col[4];

                Recipe newrecipe = new Recipe(nimi, group);
                resbook.addRecipeToBook(newrecipe);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        System.out.println("Generated recipebook with " + recipes.size() + " recipes");
    }

}
