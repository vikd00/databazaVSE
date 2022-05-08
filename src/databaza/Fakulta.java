package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Ucitel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class Fakulta implements PropertyChangeListener {
    private String nazov;
    private int rozpocet;
    private ArrayList<Osoba>zoznamOsob;
    private ArrayList<Predmet>predmety;
    private HashMap<Predmet, HashMap<Integer, Integer>> globalnyHarokZnamok;
    private PropertyChangeSupport support;


    public Fakulta(String nazov, int rozpocet) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.globalnyHarokZnamok = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    public Fakulta(String nazov, int rozpocet, ArrayList<Osoba> zoznamOsob) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.zoznamOsob = zoznamOsob;
        this.globalnyHarokZnamok = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    public Fakulta(String nazov, int rozpocet, ArrayList<Osoba> zoznamOsob, ArrayList<Predmet> predmety) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.zoznamOsob = zoznamOsob;
        this.predmety = predmety;
        this.globalnyHarokZnamok = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("1. Works ->" +  evt.getNewValue());
        HashMap<Predmet, HashMap<Integer, Integer>> harokZnamokTemp = (HashMap<Predmet, HashMap<Integer, Integer>>) this.globalnyHarokZnamok.clone();
        harokZnamokTemp.putAll((HashMap<Predmet, HashMap<Integer, Integer>>) evt.getNewValue());
        support.firePropertyChange("globalnyHarokZnamok",  this.globalnyHarokZnamok, harokZnamokTemp);
        this.globalnyHarokZnamok = harokZnamokTemp;
        //System.out.println(((HashMap<Predmet, HashMap<Integer, Integer>>) evt.getNewValue()).get(new Predmet("4IZ110", new Ucitel(2, "Jozef", "Mrkvicka","jozm11@vse.cz"), 5)));
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public ArrayList<Ucitel> getZoznamUcitelov(){
        ArrayList<Ucitel> zoznamUcitelov = new ArrayList<>();
        for(Osoba osoba : zoznamOsob){
            if(osoba instanceof Ucitel){
                zoznamUcitelov.add((Ucitel) osoba);
                ((Ucitel) osoba).addPropertyChangeListener(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fakulta fakulta = (Fakulta) o;

        return nazov != null ? nazov.equals(fakulta.nazov) : fakulta.nazov == null;
    }

    @Override
    public int hashCode() {
        return nazov != null ? nazov.hashCode() : 0;
    }
}
