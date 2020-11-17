package jalkiruokareseptigeneraattori;

import java.util.ArrayList;

public class Reseptikirja {

    ArrayList<Resepti> reseptit;

    public Reseptikirja() {
        reseptit = new ArrayList<>();
    }

    public void lisaaReseptiKirjaan(Resepti res) {
        this.reseptit.add(res);
    }

    public Resepti haeReseptiKirjasta(Integer idx) {
        if (idx <= this.reseptit.size()) {
            return this.reseptit.get(idx);
        } else {
            return null;
        }
    }

}
