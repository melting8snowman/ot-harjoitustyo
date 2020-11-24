package jalkiruokareseptigeneraattori;

import java.util.concurrent.atomic.AtomicInteger;

public class Recipe {

    /**
     * This class depicts a singular recipe preparation time is stored in full
     * minutes
     */
    public String name;
    public Integer ID;
    public String group;
    public String ingredients;
    public Integer preparation;

    // generate ID
    private static AtomicInteger uniqueId = new AtomicInteger();
    private int id;

    public Recipe(String nimi, String group) {
        this.name = nimi;
        this.group = group;
        this.ID = uniqueId.getAndIncrement();
    }

    public void setIngredients(String ing) {
        this.ingredients = ing;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getGroup() {
        return group;
    }

    public String changeGroup(String group) {
        this.group = group;
        return "Group of recipe changed to " + this.group;
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

        if (this.preparation == 0) {
            return "Recipe: " + this.name + System.lineSeparator()
                 + "Group: " + this.group + System.lineSeparator();

        } else {
            return "Recipe: " + this.name + System.lineSeparator()
                    + "Group: " + this.group + System.lineSeparator()
                    + "Time required for preparation: " + this.preparation;
        }
        
    }
}
