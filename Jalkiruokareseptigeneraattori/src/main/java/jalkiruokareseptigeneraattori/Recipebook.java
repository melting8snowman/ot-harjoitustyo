package jalkiruokareseptigeneraattori;

import java.util.Locale;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Recipebook {
// This class stores recipes and provides necessary methods

    ArrayList<Recipe> recipes;
    HashMap<Integer, String> groups;

    public Recipebook() {
        recipes = new ArrayList<>();
        groups = new HashMap<>();
        this.initializeRecipes(this);
    }

    public Integer addGroup(String igroup) {
        //check if group value exists
        Integer IDnumber = 0;
        if (!groups.containsValue(igroup.toLowerCase())) {
            //key does not exist, needs to be created
            IDnumber = groups.size() + 1;
            groups.put(IDnumber, igroup.toLowerCase());
            return IDnumber;
        }
        return this.getGroupID(igroup);
    }

    public Boolean doesGroupExist(Integer searched) {
        return this.groups.containsKey(searched);
    }

    public Integer getGroupID(String igroup) {
        List< Integer> keys = new ArrayList< Integer>();

        for (Integer key : groups.keySet()) {
            if (groups.get(key).equals(igroup)) {
                keys.add(key);
            }
        }
        if (!keys.isEmpty()) {
            return keys.get(0);
        }
        return -1;
    }

    public void addRecipeToBook(Recipe res) {
        res.setGroupID(this.addGroup(res.getGroupName()));
        this.recipes.add(res);

    }

    public Recipe getRecipeFromBook(Integer idx) {
        if (idx <= this.recipes.size()) {
            return this.recipes.get(idx);
        } else {
            return null;
        }
    }

    public void getNumberOfRecipes() {
        System.out.println("Recipebook contains " + recipes.size() + " recipes");
    }

    public Recipe getRandomRecipeFromGroup(Integer igroupId) {
        // Create shortlist of recipes of chosen group
        ArrayList<Recipe> shortList = new ArrayList<>();
        for (Recipe res : this.recipes) {
            if (res.groupID == igroupId) {
                shortList.add(res);
            }
        }
        // pick random recipe of chosen group
        if (shortList.size() == 0) {
            System.out.println("No recipes found in the chosen group. ");
            return null;
        } else {
            Random rand = new Random();
            Integer randomRecipe = rand.nextInt(shortList.size());
            return shortList.get(randomRecipe);
        }
    }

    public Recipe getRandomRecipe() {
        Random rand = new Random();
        Integer randomRecipe = rand.nextInt(this.recipes.size());
        return this.recipes.get(0);
    }

    public void printGroups() {
        for (Integer key : groups.keySet()) {
            System.out.println(key + " - " + groups.get(key));
        }
        System.out.println("");
    }

    public void printRecipes(Integer igroup) {
        for (Recipe res : this.recipes) {
            if (res.groupID == igroup) {
                System.out.printf("%s ", res);
            }
        }
    }

    public void coutsOfRecipesPerGroup() {
        Integer ctn = 0;
        for (Integer key : groups.keySet()) {
            for (Recipe res : this.recipes) {
                if (key == res.groupID) {
                    ctn += 1;
                }
            }
            System.out.println(key + " - " + groups.get(key) + " - " + ctn);
            ctn = 0;
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

                Recipe newrecipe = new Recipe(nimi, group, ingredients, preparation, image);
                resbook.addRecipeToBook(newrecipe);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        //System.out.println("Generated recipebook with " + recipes.size() + " recipes");
    }

}
