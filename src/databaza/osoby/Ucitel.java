package databaza.osoby;

import databaza.Predmet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class Ucitel extends Osoba {
    private int mesacnaMzda;
    private HashMap<Predmet, HashMap<Integer, Integer>> harokZnamok;
    private PropertyChangeSupport support;

    public Ucitel(int id, String meno, String priezvysko, String email) {
        super(id, meno, priezvysko, email);
        this.harokZnamok = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    public Ucitel(int id, String meno, String priezvysko, String email, int mesacnaMzda) {
        super(id, meno, priezvysko, email);
        this.mesacnaMzda = mesacnaMzda;
        this.harokZnamok = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }



    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void zapisZnamku(Predmet predmet, int studentId, int znamka) {
        HashMap<Predmet, HashMap<Integer, Integer>> harokZnamokTemp = (HashMap<Predmet, HashMap<Integer, Integer>>) this.harokZnamok.clone();
        if (harokZnamokTemp.get(predmet) != null) {
            HashMap<Integer, Integer> docasnaHashmap = harokZnamokTemp.get(predmet);
            if (docasnaHashmap.get(studentId) != null) {
                docasnaHashmap.remove(studentId);
                docasnaHashmap.put(studentId, znamka);
            } else {
                docasnaHashmap.put(studentId, znamka);
            }
            harokZnamokTemp.remove(predmet);
            harokZnamokTemp.put(predmet, docasnaHashmap);
        } else {
            harokZnamokTemp.put(predmet, new HashMap<Integer, Integer>() {{
                put(studentId, znamka);
            }});
        }
        System.out.println(this.harokZnamok + " + " + harokZnamokTemp);
        support.firePropertyChange("harokZnamok",  this.harokZnamok, harokZnamokTemp);
        //this.setHarokZnamok(harokZnamokTemp);

    }


    public HashMap<Predmet, HashMap<Integer, Integer>> getHarokZnamok() {
        return harokZnamok;
    }

    public void setHarokZnamok(HashMap<Predmet, HashMap<Integer, Integer>> harokZnamok) {
        this.harokZnamok = harokZnamok;
    }

    public int getMesacnaMzda() {
        return mesacnaMzda;
    }

    public void setMesacnaMzda(int mesacnaMzda) {
        this.mesacnaMzda = mesacnaMzda;
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


}
