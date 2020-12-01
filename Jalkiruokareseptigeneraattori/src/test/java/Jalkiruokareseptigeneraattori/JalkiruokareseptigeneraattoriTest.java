package Jalkiruokareseptigeneraattori;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
import jalkiruokareseptigeneraattori.Recipe;
import jalkiruokareseptigeneraattori.Recipebook;

public class JalkiruokareseptigeneraattoriTest {

    Recipe jalkkari;
    Recipebook reseptit;

    public void jalkiruokareseptigeneraattoriTest() {
    }

    @Before
    public void setUp() {
        reseptit = new Recipebook();
        jalkkari = new Recipe("rahka", "marjaisat");
    }

    //@Test
    //public void hello() {
    //}
    @Test
    public void konstruktoriLuoReseptin() {
        Recipe testiresepti = new Recipe("pulla", "leivonnaiset");
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
    public void lisaaReseptiKirjaan() {
        //Reseptikirja reseptit = new Reseptikirja();
        Recipe res = new Recipe("menujää", "viilea");
        reseptit.addRecipeToBook(res);
        Integer aika = res.getPreparation();
        assertEquals(new Integer(0), aika);
        //assertEquals("-1", String.valueOf(ressi.getValmistusaika()));
        //assertThat(ressi.getValmistusaika(), aika);
    }

    @Test
    public void lisaaReseptiKirjaan2() {
        //Reseptikirja reseptit = new Reseptikirja();
        Recipe res = new Recipe("menujää2", "viilea");
        res.setPreparation(200);
        reseptit.addRecipeToBook(res);
        Integer aika = res.getPreparation();
        assertEquals(new Integer(200), aika);
    }

    @Test
    public void changeGroup() {
        String answer = String.valueOf(jalkkari.changeGroup("uusi"));
        assertEquals("Group of recipe changed to uusi", answer);
    }

    @Test
    public void GroupExists() {
        assertTrue(reseptit.doesGroupExist(1));
    }

    @Test
    public void GroupExists2() {
        assertFalse(reseptit.doesGroupExist(100));
    }

    @Test
    public void RecipeCounts() {
        String answer = String.valueOf(reseptit.getNumberOfRecipes());
        assertEquals("5", answer);
    }

    // @Test
    // public void hello() {}
}
