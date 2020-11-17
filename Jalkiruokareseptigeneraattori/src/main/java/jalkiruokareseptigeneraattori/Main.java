
package jalkiruokareseptigeneraattori;


public class Main {


    public static void main(String[] args) {
        // TODO code application logic here
        
    Reseptikirja jalkkarit = new Reseptikirja();
    
    Resepti rahka = new Resepti("Marjarahka", 1);
    jalkkarit.lisaaReseptiKirjaan(rahka);
    jalkkarit.lisaaReseptiKirjaan(new Resepti("Pirtelö", 4));
        System.out.println(jalkkarit.haeReseptiKirjasta(1));
    }
    
}
