/*
 * Package containing business logic of the application
 */
package jalkiruokareseptigeneraattori.blogic;


import java.util.concurrent.atomic.AtomicInteger;
    /**
     * This class depicts a singular recipe,
     * preparation time is stored in full minutes
     */
public class Recipe {
    /**
     * Name
     */
    public String name;

    /**
     * ID that uses generate ID
     */
    public Integer iD;

    /**
     * Name of group
     */
    public String groupName;

    /**
     * GroupId that will be generated when recipe is added
     * to Recipebook
     */
    public Integer groupId;

    /**
     * List of ingredients
     */
    public String ingredients;

    /**
     * Preparation time in minutes
     */
    public Integer preparation;

    /**
     * URL of image
     */
    public String imageUrl;

    // generate ID
    private static AtomicInteger uniqueId = new AtomicInteger();
    private int id;

    /**
     * Main generator
     * @param nimi input value
     * @param groupName input value
     * @param ingredients input value
     * @param preparation input value
     * @param imageUrl input value
     */
    public Recipe(String nimi, String groupName, String ingredients,
            Integer preparation, String imageUrl) {
        this.name = nimi;
        this.groupName = groupName;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.imageUrl = imageUrl;
        this.iD = uniqueId.getAndIncrement();
    }

    /**
     * Generator without URL
     * @param name input value
     * @param groupName input value
     * @param ingredients input value
     * @param preparation input value
     */
    public Recipe(String name, String groupName, String ingredients,
            Integer preparation) {
        this.name = name;
        this.groupName = groupName;
        this.preparation = preparation;
        this.ingredients = ingredients;
        this.iD = uniqueId.getAndIncrement();
    }

    /**
     * Minimum generator
     * @param name input value
     * @param groupName input value
     */
    public Recipe(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
        this.preparation = 0;
        this.iD = uniqueId.getAndIncrement();
    }

    /**
     *
     * @return group integer input value
     */
    public Integer getGroupID() {
        return groupId;
    }

    /**
     *
     * @param groupId input value
     */
    public void setGroupID(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     *
     * @param ing input value
     */
    public void setIngredients(String ing) {
        this.ingredients = ing;
    }

    /**
     *
     * @return String ingredients input value
     */
    public String getIngredients() {
        return ingredients;
    }

    /**
     *
     * @return String name of group input value
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *
     * @param groupName input value
     * @return String of return
     */
    public String changeGroup(String groupName) {
        this.groupName = groupName;
        return "Group of recipe changed to " + this.groupName;
    }

    /**
     *
     * @return Preparation time or -1 
     */
    public Integer getPreparation() {
        if (this.preparation == null) {
            return -1;
        } else {
            return preparation;
        }
    }

    /**
     *
     * @param preptime preparation time input value
     */
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
