package Jalkiruokareseptigeneraattori;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
import jalkiruokareseptigeneraattori.blogic.Recipe;
import jalkiruokareseptigeneraattori.blogic.Recipebook;

public class RecipeTest {

    Recipe dessert;
    Recipe toTest;
    Recipebook recipes;

    public void jalkiruokareseptigeneraattoriTest() {
    }

    @Before
    public void setUp() {
        recipes = new Recipebook();
        dessert = new Recipe("rahka", "marjaisat", "marja", 20, "https://u.jpg");
        toTest = new Recipe("pulla", "leivonnaiset");
        recipes.addRecipeToBook(dessert);
    }

    @Test
    public void ConstructorCreatesRecipe() {
        Recipe testiresepti = new Recipe("pulla", "leivonnaiset");
        String answer = String.valueOf(testiresepti.getGroupName());
        assertEquals("leivonnaiset", answer);
    }

    @Test
    public void ConstructorCreatesRecipe2() {
        Recipe testiresepti = new Recipe("pulla", "leivonnaiset", "jauho", 20);
        String answer = String.valueOf(testiresepti.getGroupName());
        assertEquals("leivonnaiset", answer);
    }

    @Test
    public void RecipePreparation() {
        Recipe testiresepti = new Recipe("pulla", "leivonnaiset");
        Integer aika = testiresepti.getPreparation();
        assertEquals(new Integer(0), aika);
    }

    @Test
    public void RecipePreparation2() {
        Recipe testrecipe = new Recipe("pulla", "leivonnaiset");
        testrecipe.setPreparation(120);
        Integer aika = testrecipe.getPreparation();
        assertEquals(new Integer(120), aika);
    }

    @Test
    public void RecipeIngredients() {
        Recipe testiresepti = new Recipe("pulla", "leivonnaiset");
        String answer = String.valueOf(testiresepti.getIngredients());
        assertEquals("null", answer);
    }

    @Test
    public void RecipeIngredients2() {
        Recipe testiresepti = new Recipe("pulla", "leivonnaiset");
        testiresepti.setIngredients("jauhot,voi,kaneli");
        String answer = String.valueOf(testiresepti.getIngredients());
        assertEquals("jauhot,voi,kaneli", answer);
    }

    @Test
    public void getGroupID() {
        String answer = String.valueOf(dessert.getGroupID());
        assertEquals("1", answer);
    }

    @Test
    public void changeGroup() {
        String answer = String.valueOf(dessert.changeGroup("uusi"));
        assertEquals("Group of recipe changed to uusi", answer);
    }

    @Test
    public void getUrl() {
        String answer = String.valueOf(dessert.getImageUrl());
        assertEquals("https://u.jpg", answer);
    }

    @Test
    public void getUrl2() {
        String answer = String.valueOf(toTest.getImageUrl());
        assertEquals("null", answer);
    }

    @Test
    public void testToString() {
        Recipe testiresepti = new Recipe("p", "viileat");
        assertFalse(dessert.toString().contains("@"));
    }
}

// @Test
// public void hello() {}
//}
