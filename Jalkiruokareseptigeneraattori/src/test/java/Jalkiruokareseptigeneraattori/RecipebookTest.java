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

public class RecipebookTest {

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
    public void constructorGeneratesRecipebook() {
        Recipebook testbook = new Recipebook();
        assertTrue(testbook.doesGroupExist(2));
    }

    @Test
    public void constructorGeneratesRecipebook2() {
        Recipebook testbook = new Recipebook();
        String answer = String.valueOf(testbook.getNumberOfRecipes());
        assertEquals("9", answer);
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
    public void addRecipetoBook() {
        //Reseptikirja recipes = new Reseptikirja();
        Recipe res = new Recipe("menujää", "viileat");
        recipes.addRecipeToBook(res);
        Integer aika = res.getPreparation();
        assertEquals(new Integer(0), aika);
        //assertEquals("-1", String.valueOf(ressi.getValmistusaika()));
        //assertThat(ressi.getValmistusaika(), aika);
    }

    @Test
    public void addRecipetoBook2() {
        //Reseptikirja recipes = new Reseptikirja();
        Recipe res = new Recipe("menujää2", "viileat");
        res.setPreparation(200);
        recipes.addRecipeToBook(res);
        Integer aika = res.getPreparation();
        assertEquals(new Integer(200), aika);
    }

    @Test
    public void getRecipeFromBook1() {
        String answer = String.valueOf(recipes.getRecipeFromBook(1).name);
        assertEquals("Suklaakeksi", answer);
    }

    @Test
    public void getRecipeFromBook2() {
        String answer = String.valueOf(recipes.getRecipeFromBook(100000));
        assertEquals("null", answer);
    }

    @Test
    public void getGroupId() {
        String answer = String.valueOf(recipes.getGroupId("doesnotexist"));
        assertEquals("-1", answer);
    }

    @Test
    public void changeGroup() {
        String answer = String.valueOf(dessert.changeGroup("uusi"));
        assertEquals("Group of recipe changed to uusi", answer);
    }

    @Test
    public void GroupExists() {
        assertTrue(recipes.doesGroupExist(1));
    }

    @Test
    public void GroupExists2() {
        assertFalse(recipes.doesGroupExist(100));
    }

    @Test
    public void getRandomRecipe() {
        assertFalse(recipes.getRandomRecipe().name.contains("@"));
    }

    @Test
    public void printGroups() {
        assertTrue(recipes.printGroups().contains("1 - marjaisat"));
    }
    
        @Test
    public void printRecipes() {
        String answer = String.valueOf(recipes.printRecipes(4));
        assertTrue(answer.contains("mehu"));
    }
    
            @Test
    public void listRecipes() {
        String answer = String.valueOf(recipes.listRecipesOfGroup(4));
        assertTrue(answer.contains("Mehu"));
    }
    
                @Test
    public void recipebookDetails() {
        String answer = String.valueOf(recipes.recipebookDetails());
        assertTrue(answer.contains("This recipebook contains"));
    }

    @Test
    public void getRandomRecipeFromGroup() {
        assertFalse(recipes.getRandomRecipeFromGroup(1).name.contains("@"));
    }

    @Test
    public void getRandomRecipeFromGroup2() {
        String answer = String.valueOf(recipes.getRandomRecipeFromGroup(100000));
        assertEquals("null", answer);
    }

    @Test
    public void RecipeCounts() {
        String answer = String.valueOf(recipes.getNumberOfRecipes());
        assertEquals("10", answer);
    }
    
        @Test
    public void RecipeCountsPerGroup() {
        String answer = String.valueOf(recipes.coutsOfRecipesPerGroup());
        assertTrue(answer.contains("marjaisat - 4"));
    }

    // @Test
    // public void hello() {}
}
