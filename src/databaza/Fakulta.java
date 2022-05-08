package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Ucitel;

import java.util.ArrayList;

public class Fakulta {
    private String nazov;
    private int rozpocet;
    private ArrayList<Osoba>zoznamOsob;
    private ArrayList<Predmet>predmety;

    public Fakulta(String nazov, int rozpocet) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
    }

    public Fakulta(String nazov, int rozpocet, ArrayList<Osoba> zoznamOsob) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.zoznamOsob = zoznamOsob;
    }

    public Fakulta(String nazov, int rozpocet, ArrayList<Osoba> zoznamOsob, ArrayList<Predmet> predmety) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.zoznamOsob = zoznamOsob;
        this.predmety = predmety;
    }

    public ArrayList<Ucitel> getZoznamUcitelov(){
        ArrayList<Ucitel> zoznamUcitelov = new ArrayList<>();
        for(Osoba osoba : zoznamOsob){
            if(osoba instanceof Ucitel){
                zoznamUcitelov.add((Ucitel) osoba);
            }
        }
        return zoznamUcitelov;
    }


    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getRozpocet() {
        return rozpocet;
    }

    public void setRozpocet(int rozpocet) {
        this.rozpocet = rozpocet;
    }

    public ArrayList<Osoba> getZoznamOsob() {
        return zoznamOsob;
    }

    public void setZoznamOsob(ArrayList<Osoba> zoznamOsob) {
        this.zoznamOsob = zoznamOsob;
    }

    public void pridajDoZoznamuOsob(Osoba osoba){
        this.zoznamOsob.add(osoba);
    }

    public void odoberZoZoznamuOsob(Osoba osoba){
        this.zoznamOsob.remove(osoba);
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    public void setPredmety(ArrayList<Predmet> predmety) {
        this.predmety = predmety;
    }
}
