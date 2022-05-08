package databaza.osoby;

import databaza.Fakulta;
import databaza.Predmet;
import databaza.Skola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Student extends Osoba {
    private String druhStudia;
    private HashMap<Predmet, Integer> odstudovanePredmety;
    private double vazenyPriemer;
    private HashMap<Fakulta, Integer> vazenyPriemerPodlaFakult;

    private enum DruhyStudia {
        BAKALARSKE, MAGISTERSKE, DOKTORANTSKE
    }

    /*
     *   <====       Pretazovane konstruktory:      ===>
     */
    public Student(int id, String meno, String priezvysko, String email) {
        super(id, meno, priezvysko, email);
        this.odstudovanePredmety = new HashMap<>();
        this.vazenyPriemerPodlaFakult = new HashMap<>();
    }

    public Student(int id, String meno, String priezvysko, String email, String druhStudia) {
        super(id, meno, priezvysko, email);
        this.druhStudia = druhStudia;
        this.odstudovanePredmety = new HashMap<>();
        this.vazenyPriemerPodlaFakult = new HashMap<>();
    }

    public Student(int id, String meno, String priezvysko, String email, String druhStudia, HashMap<Predmet, Integer> odstudovanePredmety) {
        super(id, meno, priezvysko, email);
        this.druhStudia = druhStudia;
        this.odstudovanePredmety = odstudovanePredmety;
        this.vazenyPriemerPodlaFakult = new HashMap<>();
    }

    /*
     *   <====       Vlastne funkcie:      ===>
     */

    public void vypocitajVazenyPriemer() {
        // Vytvorenie vzorového ArrayListu s názvom "kredit_znamka"
        // Prvé číslo predstavuje počet kreditov, druhé známku [[kredit, znamka], [kredit, znamka]...]
        ArrayList<ArrayList<Integer>> listkreditovZnamkok = new ArrayList<>();
        double vypVazenyPriemer;

        for (Predmet predmet : odstudovanePredmety.keySet()) {
            ArrayList<Integer> kreditZnamka = new ArrayList<>();
            kreditZnamka.add(0, predmet.getPocetKreditov()); // na 0 index pridame pocet kreditov
            kreditZnamka.add(1, odstudovanePredmety.get(predmet)); // na 1 index pridame znamku
        }

        // Premenná celkovyKredit predstavuje súčet všetkých kreditov.
        int celkovyKredit = 0;
        // Premenná sucetZnamok vynásobí každú známku daným kreditom a všetko sčíta
        // sucetZnamok = (kredit1 * znamka1) + (kredit2 * znamka2) + .....
        int sucetZnamok = 0;
        // Program následne vypíše premenné a navzájom ich vydelí, čím získame vážený priemer
        for (int i = 0; i < listkreditovZnamkok.size(); i++) {
            celkovyKredit += listkreditovZnamkok.get(i).get(0);
            sucetZnamok += listkreditovZnamkok.get(i).get(0) * listkreditovZnamkok.get(i).get(1);
        }

        vypVazenyPriemer = (double) sucetZnamok / celkovyKredit;

        this.vazenyPriemer = vypVazenyPriemer;
    }


    /*
     *   <====       Gettery a settery:      ===>
     */

    public HashMap<Predmet, Integer> getOdstudovanePredmety() {
        return odstudovanePredmety;
    }

    public void setOdstudovanePredmety(HashMap<Predmet, Integer> odstudovanePredmety) {
        this.odstudovanePredmety = odstudovanePredmety;
    }

    public boolean addOdstudovanyPredmet(Predmet predmet, int znamka) {
        if (this.odstudovanePredmety.get(predmet) != null) {
            this.odstudovanePredmety.put(predmet, znamka);
            return true;
        }
        return false;
    }

    public String getDruhStudia() {
        return druhStudia;
    }

    public void setDruhStudia(String druhStudia) {
        this.druhStudia = druhStudia;
    }

    @Override
    public String getMeno() {
        return super.getMeno();
    }

    @Override
    public void setMeno(String meno) {
        super.setMeno(meno);
    }

    @Override
    public String getPriezvysko() {
        return super.getPriezvysko();
    }

    @Override
    public void setPriezvysko(String priezvysko) {
        super.setPriezvysko(priezvysko);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String toString() {
        return super.toString(); /*+ "\n" +
                "Druh studia:" + druhStudia + '\n' +
                "Odstudovane predmety:" + odstudovanePredmety.keySet();*/
    }
}
