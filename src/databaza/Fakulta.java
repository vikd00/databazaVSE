package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Student;
import databaza.osoby.Ucitel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class Fakulta implements PropertyChangeListener, IFakulta {
    private String nazov;   //Nazov fakulty
    private int rozpocet;   //Rozpocet fakulty
    private HashMap<Integer, Osoba>zoznamOsob;  //id a objekt osoby
    private HashMap<String, Predmet> predmety; //Zoznam predmetov na fakulte
    private HashMap<Predmet, HashMap<Integer, Integer>> globalnyHarokZnamok;    //Globalny harok znamok -> zbiera zaznamy ucitelov
    private PropertyChangeSupport support;  //Funkcionalita observerov...

    /*
     *   <====       Pretazovane konstruktory:      ===>
     */
    public Fakulta(String nazov, int rozpocet) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.globalnyHarokZnamok = new HashMap<>();
        this.zoznamOsob = new HashMap<>();
        this.predmety = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    public Fakulta(String nazov, int rozpocet, HashMap<Integer, Osoba>zoznamOsob) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.zoznamOsob = zoznamOsob;
        this.globalnyHarokZnamok = new HashMap<>();
        this.predmety = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    public Fakulta(String nazov, int rozpocet, HashMap<Integer, Osoba>zoznamOsob, HashMap<String, Predmet> predmety) {
        this.nazov = nazov;
        this.rozpocet = rozpocet;
        this.zoznamOsob = zoznamOsob;
        this.predmety = predmety;
        this.globalnyHarokZnamok = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    /*
     *   <====       Vlastne funkcie:      ===>
     */

    //Funkcia na pridanie osoby na fakultu
    public boolean vlozOsobu(Osoba osoba){
        System.out.println("v>>" + osoba.getId());
        if(this.zoznamOsob.get(osoba.getId()) == null){
            System.out.println("v>>" + this.getNazov());
            this.zoznamOsob.put(osoba.getId(), osoba);
            return true;
        }

        return false;
    }

    //Funkcia na odobratie osoby z fakulty
    public boolean odoberOsobu(int osobaID) {
        System.out.println("o>>" + osobaID);
        if(this.zoznamOsob.get(osobaID) != null){
            System.out.println("v>>" + this.getNazov());
            this.zoznamOsob.remove(osobaID);
            return true;
        }

        return false;
    }

    //Funkcia na pridanie predmetu na fakultu
    public boolean vlozPredmet(Predmet predmet){
        if(this.predmety.get(predmet.getNazov()) == null){
            this.predmety.put(predmet.getNazov(), predmet);
            return true;
        }
        return false;
    }

    //Funkcia na odobratie predmetu z fakulty
    public boolean odoberPredmet(int nazovPredmetu) {
        if(this.predmety.get(nazovPredmetu) != null){
            this.predmety.remove(nazovPredmetu);
            return true;
        }
        return false;
    }

    //Funkcia na vygenerovanie globalneho harku znamok z fakulty
    public HashMap<Predmet, HashMap<Integer, Integer>> vygenerujGlobalnyHarokZnamok() {
        for (Ucitel ucitel : this.getZoznamUcitelov()) {
            globalnyHarokZnamok.putAll(ucitel.getHarokZnamok());
        }
        return this.globalnyHarokZnamok;
    }

    //Funkcia sa spusta ked observable Ucitel zapise znamku -> evt.getNewValue() obsahuje jeho harok s aktualnymi znamkami
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("1. Works ->" +  evt.getNewValue());
        HashMap<Predmet, HashMap<Integer, Integer>> harokZnamokTemp = (HashMap<Predmet, HashMap<Integer, Integer>>) this.globalnyHarokZnamok.clone();   //Treba naklonovat, inak sa nespusti event zmeny
        harokZnamokTemp.putAll((HashMap<Predmet, HashMap<Integer, Integer>>) evt.getNewValue());
        support.firePropertyChange("globalnyHarokZnamok",  this.globalnyHarokZnamok, harokZnamokTemp);      //Spusti event ktory upozorni observera ze sa zmenil harok
        this.globalnyHarokZnamok = harokZnamokTemp;
    }



    /*
     *   <====       Gettery a settery:      ===>
     */

    public ArrayList<Ucitel> getZoznamUcitelov(){
        ArrayList<Ucitel> zoznamUcitelov = new ArrayList<>();
        for(Osoba osoba : this.zoznamOsob.values()){
            if(osoba instanceof Ucitel){
                zoznamUcitelov.add((Ucitel) osoba);
                ((Ucitel) osoba).addPropertyChangeListener(this);
            }
        }
        return zoznamUcitelov;
    }

    //Funkcia ktora je implementuje funkcionalitu PropertyChangeListener
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }


    public String getNazov() {
        return this.nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getRozpocet() {
        return this.rozpocet;
    }

    public void setRozpocet(int rozpocet) {
        this.rozpocet = rozpocet;
    }

    public HashMap<Integer, Osoba> getZoznamOsob() {
        return this.zoznamOsob;
    }

    public void setZoznamOsob(HashMap<Integer, Osoba>zoznamOsob) {
        this.zoznamOsob = zoznamOsob;
    }

    public HashMap<String, Predmet> getPredmety() {
        return this.predmety;
    }

    public void setPredmety(HashMap<String, Predmet> predmety) {
        this.predmety = predmety;
    }

    /*
     *   <====       Override:      ===>
     */

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
