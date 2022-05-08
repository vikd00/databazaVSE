package databaza.osoby;

import databaza.Predmet;
import databaza.Skola;

import java.util.HashMap;
import java.util.function.Function;

public class Student extends Osoba{
    private String druhStudia;
    private HashMap<Predmet, Integer> odstudovanePredmety;
    private Function<Skola, HashMap<Predmet, Integer>> func;

    public Student(int id, String meno, String priezvysko, String email) {
        super(id, meno, priezvysko, email);
    }

    public Student(int id, String meno, String priezvysko, String email, String druhStudia) {
        super(id, meno, priezvysko, email);
        this.druhStudia = druhStudia;
    }

    public Student(int id, String meno, String priezvysko, String email, String druhStudia, HashMap<Predmet, Integer> odstudovanePredmety) {
        super(id, meno, priezvysko, email);
        this.druhStudia = druhStudia;
        this.odstudovanePredmety = odstudovanePredmety;
    }

    public HashMap<Predmet, Integer> getOdstudovanePredmety() {
        return odstudovanePredmety;
    }

    public void setOdstudovanePredmety(HashMap<Predmet, Integer> odstudovanePredmety) {
        this.odstudovanePredmety = odstudovanePredmety;
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
        return super.toString() + "\n" +
                "Druh studia:" + druhStudia + '\n' +
                "Odstudovane predmety:" + odstudovanePredmety.keySet();
    }
}
