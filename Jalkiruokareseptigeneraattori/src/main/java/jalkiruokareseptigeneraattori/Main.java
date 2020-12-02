package jalkiruokareseptigeneraattori;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here

        Recipebook jalkkarit = new Recipebook();

        //Recipe pulla = new Recipe("Pulla", "leivonnaiset");
        //jalkkarit.addRecipeToBook(pulla);
        jalkkarit.addRecipeToBook(new Recipe("Pirtelö", "viilea"));
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
