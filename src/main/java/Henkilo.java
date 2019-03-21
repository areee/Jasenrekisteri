
public class Henkilo {

    private String etunimi;
    private String sukunimi;

    public Henkilo(String etunimi, String sukunimi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
    }

    public String getNimi() {
        return this.etunimi;
    }

    public void setNimi(String nimi) {
        this.etunimi = nimi;
    }

    public String getSukunimi() {
        return this.sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    @Override
    public String toString() {
        return this.sukunimi + ", " + this.etunimi;
    }

    @Override
    public boolean equals(Object verrattava) {
        // jos muuttujat sijaitsevat samassa paikassa, ovat ne samat:
        if (this == verrattava) {
            return true;
        }
        // jos verrattava olio ei ole Henkilo-tyyppinen, oliot eivät ole samat:
        if (!(verrattava instanceof Henkilo)) {
            return false;
        }
        // muunnetaan olio Henkilo-olioksi
        Henkilo verrattavaHenkilo = (Henkilo) verrattava;

        // jos olioiden oliomuuttujien arvot ovat samat, ovat oliot samat:
        if (this.etunimi.equals(verrattavaHenkilo.etunimi) && this.sukunimi.equals(verrattavaHenkilo.sukunimi)) {
            return true;
        }

        // muulloin oliot eivät ole samat:
        return false;
    }

}
