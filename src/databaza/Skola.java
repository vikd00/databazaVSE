package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Student;
import databaza.osoby.Ucitel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Skola implements PropertyChangeListener, ISkola {
    private String nazev;
    private String adresa;
    private HashMap<String, Fakulta> fakulty;
    private int idGeneratorZaklad;
    private HashMap<Predmet, HashMap<Integer, Integer>> globalnyHarokZnamok;
    //private Ucitel zoznamUcitelov;

    /*
     *   <====       Pretazovane konstruktory:      ===>
     */

    public Skola(String nazev, String adresa) {
        this.nazev = nazev;
        this.adresa = adresa;
        this.fakulty = new HashMap<>();
        this.idGeneratorZaklad = 1;
        this.globalnyHarokZnamok = new HashMap<>();

    }

    public Skola(String nazev, String adresa, HashMap<String, Fakulta> fakulty) {
        this.nazev = nazev;
        this.adresa = adresa;
        this.fakulty = fakulty;
        this.idGeneratorZaklad = 1;
        this.globalnyHarokZnamok = new HashMap<>();
    }

    /*
     *   <====       Vlastne funkcie:      ===>
     */

    //Funkcia spustena ked sa na nejakej fakulte zmeni globalny harok so znamkami
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("2. Works ->" + evt.getNewValue());
        System.out.println(((HashMap<Predmet, HashMap<Integer, Integer>>) evt.getNewValue()).get(new Predmet("4IZ110", new Ucitel(2, "Jozef", "Mrkvicka", "jozm11@vse.cz"), 5)));
        globalnyHarokZnamok.putAll(((HashMap<Predmet, HashMap<Integer, Integer>>) evt.getNewValue()));
    }

    public boolean pridajFakultu(Fakulta fakulta) {
        if (fakulty.get(fakulta.getNazov()) == null) {
            fakulty.put(fakulta.getNazov(), fakulta);
            fakulta.addPropertyChangeListener(this);
            return true;
        }
        return false;
    }

    public boolean pridajFakultu(String nazov, int rozpocet) {
        if (fakulty.get(nazov) == null) {
            Fakulta fakulta = new Fakulta(nazov, rozpocet);
            fakulty.put(nazov, fakulta);
            fakulta.addPropertyChangeListener(this);
            return true;
        }
        return false;
    }

    public boolean odoberFakultu(Fakulta fakulta) {
        if (fakulty.remove(fakulta.getNazov()) != null) {
            return true;
        }
        return false;
    }

    public boolean odoberFakultu(String nazovFakulty) {
        if (fakulty.remove(nazovFakulty) != null) {
            return true;
        }
        return false;
    }

    public boolean pridajOsobu(Fakulta fakulta, Osoba osoba) {
        if (fakulty.get(fakulta.getNazov()) != null) {
            fakulty.get(fakulta.getNazov()).vlozOsobu(osoba);
            return true;
        }
        return false;
    }

    public boolean pridajOsobu(String nazovFakulty, Osoba osoba) {
        if (this.fakulty.get(nazovFakulty) != null) {
            this.fakulty.get(nazovFakulty).vlozOsobu(osoba);
            return true;
        }
        return false;
    }

    public boolean odstranOsobu(int osobneID) {
        for (Fakulta fakulta : this.fakulty.values()) {
            if (fakulta.getZoznamOsob().get(osobneID) != null) {
                fakulta.odoberOsobu(osobneID);
                return true;
            }
        }
        return false;
    }

    public boolean presunOsobuMedziFakultami(int osobneID, String nazovFakultyA, String nazovFakultyB) {
        Osoba tempOsoba = vyhladajPodlaID(osobneID);
        if (this.fakulty.get(nazovFakultyA).getZoznamOsob().get(osobneID) != null) {
            //System.out.println("A" + fakulty.get(nazovFakultyA).getZoznamOsob());
            this.fakulty.get(nazovFakultyA).odoberOsobu(osobneID);
            this.odstranOsobu(osobneID);
            //System.out.println("B" + fakulty.get(nazovFakultyA).getZoznamOsob());
        } else {
            return false;
        }

        if (this.fakulty.get(nazovFakultyB).getZoznamOsob().get(osobneID) == null) {
            this.fakulty.get(nazovFakultyB).vlozOsobu(tempOsoba);
            return true;
        }

        return false;
    }

    public Osoba vyhladajPodlaID(int osobneID) {
        for (Fakulta fakulta : fakulty.values()) {
            if (fakulta.getZoznamOsob().get(osobneID) != null) {
                return fakulta.getZoznamOsob().get(osobneID);
            }
        }
        return null;
    }

    public ArrayList<Osoba> vyhladajPodlaMena(String meno) {
        ArrayList<Osoba> tempList = new ArrayList<>();
        for (Fakulta fakulta : fakulty.values()) {
            for (Osoba osoba : fakulta.getZoznamOsob().values()) {
                if (osoba.getMeno() == meno) {
                    tempList.add(osoba);
                }
            }
        }
        return tempList;
    }

    public ArrayList<Osoba> vyhladajPodlaFakulty(String nazovFakulty) {
        for (Fakulta fakulta : fakulty.values()) {
            if (fakulta.getNazov() == nazovFakulty) {
                return (ArrayList<Osoba>) fakulta.getZoznamOsob().values();
            }
        }
        return null;
    }

    //Funkcia na vygenerovanie globalneho harku znamok z fakulty
    public HashMap<Predmet, HashMap<Integer, Integer>> vygenerujGlobalnyHarokZnamok() {
        for (Fakulta fakulta : fakulty.values()) {
            globalnyHarokZnamok.putAll(fakulta.vygenerujGlobalnyHarokZnamok());
        }
        return this.globalnyHarokZnamok;
    }

//    public void zapisStudentoviZnamku(Predmet predmet, int ucitelID, int studentID, int znamka) {
//        Ucitel ucitel = (Ucitel) fakulty.get("FIS").getZoznamUcitelov().get(1);
//        Ucitel ucitel2 = (Ucitel) fakulty.get("FIS").getZoznamUcitelov().get(2);
//        ucitel.zapisZnamku(new Predmet("t", ucitel, 5), 1, 2);
//        ucitel2.zapisZnamku(new Predmet("t", ucitel2, 5), 1, 2);
//        ucitel.zapisZnamku(new Predmet("t", ucitel, 5), 1, 2);
//    }

    public boolean zapisStudentomDokoncenePredmety() {
        //Preloopujeme predmety
        for (Predmet predmet : globalnyHarokZnamok.keySet()) {
            //Preloopujeme id ziakov, ktore maju predmet ukonceny
            for (int id : globalnyHarokZnamok.get(predmet).keySet()) {
                //Najdeme ziaka na fakulte a zapiseme znamku
                for (Fakulta fakulta : fakulty.values()) {
                    if (fakulta.zapisZnamku(id, predmet, globalnyHarokZnamok.get(predmet).get(id))) {
                        break;
                    }
                }
            }
        }
        return true;
    }

    ; //Funkcia ktora precita harky ucitelov a pozrbiera data konkretneho ziaka a nasledne ich mu zapise, zapisana znamka -> hotovy predmet

    public int generujUnikatneID() {
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
        for (String fakulta : this.fakulty.keySet()) {
            rtrn += fakulta;
        }

        return rtrn;
    }
}


