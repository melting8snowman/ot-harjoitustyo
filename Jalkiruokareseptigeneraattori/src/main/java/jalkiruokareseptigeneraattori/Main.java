package jalkiruokareseptigeneraattori;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here

        Recipebook jalkkarit = new Recipebook();

        Recipe pulla = new Recipe("Pulla", "leivonnaiset");
        jalkkarit.addRecipeToBook(pulla);
        jalkkarit.addRecipeToBook(new Recipe("Pirtelö", "viilea"));
        //System.out.println(jalkkarit.getRecipeFromBook(1));
    }

}
