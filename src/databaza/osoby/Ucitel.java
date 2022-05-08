package databaza.osoby;

import databaza.Predmet;

import java.util.ArrayList;
import java.util.HashMap;

public class Ucitel extends Osoba {
    private int mesacnaMzda;
    private HashMap<Predmet, HashMap<Integer, Integer>> harokZnamok;

    public Ucitel(int id, String meno, String priezvysko, String email) {
        super(id, meno, priezvysko, email);
    }

    public Ucitel(int id, String meno, String priezvysko, String email, int mesacnaMzda) {
        super(id, meno, priezvysko, email);
        this.mesacnaMzda = mesacnaMzda;
    }

    public void zapisZnamku(Predmet predmet, int studentId, int znamka) {
        if (harokZnamok.get(predmet) != null) {
            HashMap<Integer, Integer> docasnaHashmap = harokZnamok.get(predmet);
            if (docasnaHashmap.get(studentId) != null) {
                docasnaHashmap.remove(studentId);
                docasnaHashmap.put(studentId, znamka);
            } else {
                docasnaHashmap.put(studentId, znamka);
            }
            harokZnamok.remove(predmet);
            harokZnamok.put(predmet, docasnaHashmap);
        } else {
            harokZnamok.put(predmet, new HashMap<Integer, Integer>() {{
                put(studentId, znamka);
            }});
        }
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
