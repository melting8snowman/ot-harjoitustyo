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

    Recipe jalkkari;
    //Recipebook reseptit;

    public void jalkiruokareseptigeneraattoriTest() {
    }

    @Before
    public void setUp() {
        //reseptit = new Recipebook();
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
    public void changeGroup() {
        String answer = String.valueOf(jalkkari.changeGroup("uusi"));
        assertEquals("Group of recipe changed to uusi", answer);
    }


    // @Test
    // public void hello() {}
}
