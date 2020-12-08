package jalkiruokareseptigeneraattori.blogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.List;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

import jalkiruokareseptigeneraattori.uis.RpInt;

/**
 * Recipebook class that stores recipes and provides methods
 * @author niemi
 */
public class Recipebook implements RpInt {
// This class stores recipes and provides necessary methods

    ArrayList<Recipe> recipes;
    HashMap<Integer, String> groups;

    /**
     * Class stores arraylist and hashmap
     */
    public Recipebook() {
        recipes = new ArrayList<>();
        groups = new HashMap<>();
        this.initializeRecipes(this);
    }

    /**
     * Get ID of group based on name 
     * @param igroup input value
     * @return Integer group id 
     */
    public Integer addGroup(String igroup) {
        //check if group value exists
        Integer idNum = 0;
        if (!groups.containsValue(igroup.toLowerCase())) {
            //key does not exist, needs to be created
            idNum = groups.size() + 1;
            groups.put(idNum, igroup.toLowerCase());
            return idNum;
        }
        return this.getGroupId(igroup);
    }

    /**
     * Check if group exists
     * @param searched input value
     * @return Boolean
     */
    public Boolean doesGroupExist(Integer searched) {
        return this.groups.containsKey(searched);
    }

    /**
     * Get group ID of Name
     * @param igroup input value
     * @return ID or -1
     */
    public Integer getGroupId(String igroup) {
        List<Integer> keys = new ArrayList<Integer>();

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

    /**
     * Add Recipe to Recipebook and check group exists, if not add
     * @param res Recipe input value
     */
    public void addRecipeToBook(Recipe res) {
        res.setGroupID(this.addGroup(res.getGroupName()));
        this.recipes.add(res);

    }

    /**
     * Get a single recipe based on ID
     * @param idx ID of recipe input value
     * @return Recipe or null
     */
    public Recipe getRecipeFromBook(Integer idx) {
        if (idx <= this.recipes.size()) {
            return this.recipes.get(idx);
        } else {
            return null;
        }
    }

    /**
     * Calculate total number of recipes in book
     * @return size
     */
    public int getNumberOfRecipes() {
        System.out.println("Recipebook contains " + recipes.size() + " recipes");
        return recipes.size();
    }

    /**
     * Random pick a recipe of a group from book
     * @param igroupId input value
     * @return Recipe or null
     */
    public Recipe getRandomRecipeFromGroup(Integer igroupId) {
        // Create shortlist of recipes of chosen group
        ArrayList<Recipe> shortList = new ArrayList<>();
        for (Recipe res : this.recipes) {
            if (res.groupId == igroupId) {
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
    
    /**
     * Random pick any recipe in book
     * @return Recipe or null
     */
    @Override
    public Recipe getRandomRecipe() {
        Random rand = new Random();
        Integer randomRecipe = rand.nextInt(this.recipes.size());
        if (this.recipes.size() == 0) {
            System.out.println("No recipes found. ");
            return null;
        } else {
            return this.recipes.get(randomRecipe);
        }
    }
    
    /**
     * Print existing groups
     * @return String or groups
     */
    @Override
    public String printGroups() {
        String res = "";
        for (Integer key : groups.keySet()) {
            res = res.concat(key + " - " + groups.get(key));
            System.out.println(key + " - " + groups.get(key));
        }
        System.out.println("");
        return res;
    }

    /**
     * Print recipes
     * @param igroup input value
     * @return String of recipes
     */
    public String printRecipes(Integer igroup) {
        String result = "";
        for (Recipe res : this.recipes) {
            if (res.groupId == igroup) {
                result = result.concat(res+ System.lineSeparator());
                System.out.printf("%s ", res);
            }
        } return result;
    }

    /**
     * Calculate recipe group counts
     */
    public void coutsOfRecipesPerGroup() {
        Integer ctn = 0;
        for (Integer key : groups.keySet()) {
            for (Recipe res : this.recipes) {
                if (key == res.groupId) {
                    ctn += 1;
                }
            }
            System.out.println(key + " - " + groups.get(key) + " - " + ctn);
            ctn = 0;
        }
    }

    /**
     * initialize recipes from file recipes.txt
     * @param resbook input value
     */
    public void initializeRecipes(Recipebook resbook) {
        boolean firstLine = true;
        try (Scanner reader = new Scanner(Paths.get("recipes.txt"))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine(); // skip first or empty line
                if ((firstLine) || (row.isEmpty())) {
                    firstLine = false; 
                    continue;
                }
                String[] col = row.split(Pattern.quote("|"));
                String nimi = col[0];
                String group = col[1];
                String ing = col[2];
                int prep = Integer.valueOf(col[3].replaceAll("\\s+", ""));
                String image = col[4];
                resbook.addRecipeToBook(new Recipe(nimi, group, ing, prep, image));
            }
        } catch (Exception e) {
            //System.out.println("Virhe: " + e.getMessage());
        }
    }

   

}
