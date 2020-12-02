package jalkiruokareseptigeneraattori;

import java.util.concurrent.atomic.AtomicInteger;

public class Recipe {

    /**
     * This class depicts a singular recipe preparation time is stored in full
     * minutes
     */
    public String name;
    public Integer iD;
    public String groupName;
    public Integer groupId;
    public String ingredients;
    public Integer preparation;
    public String imageUrl;

    // generate ID
    private static AtomicInteger uniqueId = new AtomicInteger();
    private int id;

    public Recipe(String nimi, String groupName, String ingredients,
            Integer preparation, String imageUrl) {
        this.name = nimi;
        this.groupName = groupName;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.imageUrl = imageUrl;
        this.iD = uniqueId.getAndIncrement();
    }

    public Recipe(String nimi, String groupName, String ingredients,
            Integer preparation) {
        this.name = nimi;
        this.groupName = groupName;
        this.preparation = 0;
        this.iD = uniqueId.getAndIncrement();
    }

    public Recipe(String nimi, String groupName) {
        this.name = nimi;
        this.groupName = groupName;
        this.preparation = 0;
        this.iD = uniqueId.getAndIncrement();
    }

    public Integer getGroupID() {
        return groupId;
    }

    public void setGroupID(Integer groupId) {
        this.groupId = groupId;
    }

    public void setIngredients(String ing) {
        this.ingredients = ing;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getGroupName() {
        return groupName;
    }

    public String changeGroup(String groupName) {
        this.groupName = groupName;
        return "Group of recipe changed to " + this.groupName;
    }

    public Integer getPreparation() {
        if (this.preparation == null) {
            return -1;
        } else {
            return preparation;
        }
    }

    public void setPreparation(Integer preptime) {
        this.preparation = preptime;
    }

    @Override
    public String toString() {
        String returnMsg = System.lineSeparator()
                + "Recipe: " + this.name + System.lineSeparator()
                + "Group: " + this.groupName + System.lineSeparator();

        if (this.preparation > 0) {
            returnMsg = returnMsg
                    + "Time required for preparation: " + this.preparation
                    + System.lineSeparator();

        }
        if (!this.ingredients.isEmpty()) {
            returnMsg = returnMsg
                    + "Cooking ingredients: " + this.ingredients
                    + System.lineSeparator();
        }
        returnMsg = returnMsg + System.lineSeparator();

        return returnMsg;

    }
}
