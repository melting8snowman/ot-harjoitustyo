package jalkiruokareseptigeneraattori;

import jalkiruokareseptigeneraattori.blogic.Recipe;
import jalkiruokareseptigeneraattori.blogic.Recipebook;
import jalkiruokareseptigeneraattori.uis.TextUi;
import java.util.Scanner;

/**
 * Main Program for running Recipe Generator with Text-based UI
 * @author niemi
 */
public class Main {

    /**
     * Create main objects and scanner for Text Ui
     * @param args no parameters 
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Recipebook jalkkarit = new Recipebook();

        //Recipe pulla = new Recipe("Pulla", "leivonnaiset");
        //jalkkarit.addRecipeToBook(pulla);
        //jalkkarit.addRecipeToBook(new Recipe("Pirtelö", "viilea"));
        //System.out.println(jalkkarit.getRecipeFromBook(1));
        //jalkkarit.getNumberOfRecipes();
        //jalkkarit.printGroups();
        //System.out.println(jalkkarit.getRandomRecipeFromGroup(1));
        //System.out.println(jalkkarit.getRandomRecipe());

        Scanner ipReader = new Scanner(System.in);
        TextUi uI = new TextUi(jalkkarit, ipReader);
        uI.start();
    }

}
