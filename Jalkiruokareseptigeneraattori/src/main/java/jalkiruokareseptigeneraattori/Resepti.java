package jalkiruokareseptigeneraattori;

public class Resepti {

    public String nimi;
    public Integer ryhma;
    public String ohjeet;
    public Double valmistusaika;

    public Resepti(String nimi, Integer ryhma) {
        this.nimi = nimi;
        this.ryhma = ryhma;
    }

    public void lisaaOhjeet(String ohjeet) {
        this.ohjeet = ohjeet;
    }

    public Double getValmistusaika() {
        return valmistusaika;
    }

    public void setValmistusaika(Double valmistusaika) {
        this.valmistusaika = valmistusaika;
    }



    @Override
    public String toString() {
        //Double aika;
        //if (this.valmistusaika.) {
        //    aika = 0.0;
        //} else {
        //    aika = this.valmistusaika;
        //}

        return "Resepti: " + nimi + System.lineSeparator()
                + "Ryhmä: " + ryhma + System.lineSeparator()
                + "Valmistusaika: " + valmistusaika;
    }

}
