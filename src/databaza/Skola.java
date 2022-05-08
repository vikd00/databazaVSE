package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Ucitel;

import java.util.HashMap;

public class Skola {
    private String nazev;
    private String adresa;
    private HashMap<String, Fakulta> fakulty;
    private int idGeneratorZaklad;
    private Ucitel zoznamUcitelov;

    public Skola(String nazev, String adresa) {
        this.nazev = nazev;
        this.adresa = adresa;
        this.fakulty = new HashMap<String, Fakulta>();
        this.idGeneratorZaklad = 1;

    }

    public Skola(String nazev, String adresa, HashMap<String, Fakulta> fakulty) {
        this.nazev = nazev;
        this.adresa = adresa;
        this.fakulty = fakulty;
        this.idGeneratorZaklad = 1;
    }

    public void addFakulta(Fakulta fakulta){
        fakulty.put(fakulta.getNazov(), fakulta);
    }

    public void addFakulta(String nazov, int rozpocet){
        Fakulta fakulta = new Fakulta(nazov, rozpocet);
        fakulty.put(nazov,fakulta);
    }

    public void deleteFakulta(String nazov){
        fakulty.remove(nazov);
    }

    public void pridajOsobuNaFakultu(Fakulta fakulta, Osoba osoba){
        if(fakulty.get(fakulta) != null){
            fakulta.pridajDoZoznamuOsob(osoba);
        }
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


