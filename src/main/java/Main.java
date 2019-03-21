
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("**PARTIOLIPPUKUNTA MÖRRIMÖYKKYJEN JÄSENREKISTERI**");
        ArrayList<Henkilo> jasentiedot = suoritaJasentietojenLuku();

        while (true) {
            tulostaKomennot();

            System.out.print("> "); // "koristemerkki": kertoo, että tähän voi syötteen kirjoittaa
            String syote = lukija.nextLine();
            System.out.println(""); // ylimääräinen rivinvaihto

            if (syote.equals("lopeta")) {
                suoritaLopetaKomento();
                break;
            } else if (syote.equals("lisää")) {
//                suoritaLisaaKomento(jasentiedot, lukija); // TODO
            } else if (syote.equals("etsi")) {
                suoritaEtsiKomento(jasentiedot, lukija);
            } else if (syote.equals("poista")) {
//                suoritaPoistaKomento(jasentiedot, lukija); // TODO
            } else {
                suoritaTuntematonKomento();
            }
        }
    }

    public static void tulostaKomennot() {
        System.out.println("\n");
        System.out.println("Komennot:");
        System.out.println("lopeta – lopettaa ohjelman");
        System.out.println("lisää – lisää henkilön jäsenrekisteriin");
        System.out.println("etsi – etsii tietyn henkilön henkilötiedot");
        System.out.println("poista – poistaa henkilön jäsenrekisteristä");
    }

    public static void suoritaLopetaKomento() {
        System.out.println("**LOPETA**\nNäkemiin!");
    }

    public static void suoritaLisaaKomento(ArrayList<Henkilo> jasentiedot, Scanner lukija) {
        System.out.println("**LISÄÄ**");
        System.out.print("Syötä lisättävä henkilö: ");
        String henkilo = lukija.nextLine();
    }

    public static void suoritaEtsiKomento(ArrayList<Henkilo> jasentiedot, Scanner lukija) {
        System.out.println("**ETSI**");
        boolean loytyi = false;
        System.out.print("Syötä etsittävän henkilön sukunimi: ");
        String henkilonSukunimi = lukija.nextLine();

        for (Henkilo henkilo : jasentiedot) {
            String sukunimi = henkilo.getSukunimi();
            if (henkilonSukunimi.equals(sukunimi)) {
                System.out.println("Etsittävä henkilö löytyi: " + henkilo);
                loytyi = true;
                break;
            }
        }
        if (!loytyi) { // etsittävää ei löytynyt, eli loytyi = false
            System.out.println("Etsittävää henkilöä ei löytynyt.");
        }
    }

    public static void suoritaPoistaKomento(ArrayList<Henkilo> jasentiedot, Scanner lukija) {
        System.out.println("**POISTA**");
        System.out.print("Syötä poistettava henkilö: ");
        String henkilo = lukija.nextLine();
    }

    public static void suoritaTuntematonKomento() {
        System.out.println("Komento oli tuntematon. Yritä uudelleen!");
    }

    public static ArrayList<Henkilo> suoritaJasentietojenLuku() {
        ArrayList<Henkilo> jasenet = new ArrayList<>();
        try {
            Scanner tiedostonLukija = new Scanner(new File("jasentiedot.txt"));
            while (tiedostonLukija.hasNextLine()) {
                String nimirivi = tiedostonLukija.nextLine();
                String[] nimitiedot = nimirivi.split(",");
                if (nimitiedot.length == 2) {
                    String sukunimi = nimitiedot[0];
                    String etunimi = nimitiedot[1];
                    jasenet.add(new Henkilo(etunimi, sukunimi));

                } else {
                    throw new IllegalArgumentException("Nimirivillä ei ollut etu- ja sukunimeä");
                }

            }
        } catch (FileNotFoundException e) { // jos tiedostonlukeminen epäonnistui, pompataan tänne
            System.out.println("Virhe: " + e.getMessage());
        }
        return jasenet;
    }

}
