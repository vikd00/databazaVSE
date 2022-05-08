package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Ucitel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class Skola implements PropertyChangeListener {
    private String nazev;
    private String adresa;
    private HashMap<String, Fakulta> fakulty;
    private int idGeneratorZaklad;
    private Ucitel zoznamUcitelov;

    public Skola(String nazev, String adresa) {
        this.nazev = nazev;
        this.adresa = adresa;
        this.fakulty = new HashMap<>();
        this.idGeneratorZaklad = 1;

    }

    public Skola(String nazev, String adresa, HashMap<String, Fakulta> fakulty) {
        this.nazev = nazev;
        this.adresa = adresa;
        this.fakulty = fakulty;
        this.idGeneratorZaklad = 1;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("2. Works ->" +  evt.getNewValue());
        System.out.println(((HashMap<Predmet, HashMap<Integer, Integer>>) evt.getNewValue()).get(new Predmet("4IZ110", new Ucitel(2, "Jozef", "Mrkvicka","jozm11@vse.cz"), 5)));
    }

    public void addFakulta(Fakulta fakulta){
        fakulty.put(fakulta.getNazov(), fakulta);
        fakulta.addPropertyChangeListener(this);
    }

    public void addFakulta(String nazov, int rozpocet){
        Fakulta fakulta = new Fakulta(nazov, rozpocet);
        fakulty.put(nazov,fakulta);
        System.out.println(this.fakulty);
    }

    public void deleteFakulta(String nazov){
        fakulty.remove(nazov);
    }

    public void pridajOsobuNaFakultu(Fakulta fakulta, Osoba osoba){
        if(fakulty.get(fakulta.getNazov()) != null){
            fakulta.pridajDoZoznamuOsob(osoba);
        }else{
            System.out.println(this.fakulty);
        }
    }

    public void zapisStudentoviZnamku(Predmet predmet, int ucitelID, int studentID, int znamka){
        Ucitel ucitel = (Ucitel) fakulty.get("FIS").getZoznamUcitelov().get(1);
        Ucitel ucitel2 = (Ucitel) fakulty.get("FIS").getZoznamUcitelov().get(2);
        ucitel.zapisZnamku(new Predmet("t", ucitel, 5), 1, 2);
        ucitel2.zapisZnamku(new Predmet("t", ucitel2, 5), 1, 2);
        ucitel.zapisZnamku(new Predmet("t", ucitel, 5), 1, 2);
    }

    public boolean zapisStudentoviDokoncenePredmety(){return false;}; //Funkcia ktora precita harky ucitelov a pozrbiera data konkretneho ziaka a nasledne ich mu zapise, zapisana znamka -> hotovy predmet

    public int generujId(){
        this.idGeneratorZaklad++;
        return this.idGeneratorZaklad;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public HashMap<String, Fakulta> getFakulty() {
        return fakulty;
    }

    public void setFakulty(HashMap<String, Fakulta> fakulty) {
        this.fakulty = fakulty;
    }

    @Override
    public String toString() {
        String rtrn = "Nazev skoly: " + "\n";
        for(String fakulta : this.fakulty.keySet()){
            rtrn += fakulta;
        }

        return rtrn;
    }
}


