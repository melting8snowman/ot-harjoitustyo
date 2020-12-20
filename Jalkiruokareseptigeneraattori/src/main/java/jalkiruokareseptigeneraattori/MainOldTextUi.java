package jalkiruokareseptigeneraattori;

import jalkiruokareseptigeneraattori.blogic.Recipe;
import jalkiruokareseptigeneraattori.blogic.Recipebook;
import jalkiruokareseptigeneraattori.uis.TextUi;
import java.util.Scanner;

/**
 * Main Program for running Recipe Generator with Text-based UI
 * @author niemi
 */
public class MainOldTextUi {

    /**
     * Create main objects and scanner for Text Ui
     * @param args no parameters 
     */
    public static void main(String[] args) {

        Recipebook dessert = new Recipebook();

        Scanner ipReader = new Scanner(System.in);
        TextUi uI = new TextUi(dessert, ipReader);
        uI.start();
    }

}
