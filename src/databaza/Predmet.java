package databaza;

import databaza.osoby.Osoba;

public class Predmet {
    private String nazov;
    private Osoba vyucujuci;
    private int pocetKreditov;

    public Predmet(String nazov, Osoba vyucujuci, int pocetKreditov) {
        this.nazov = nazov;
        this.vyucujuci = vyucujuci;
        this.pocetKreditov = pocetKreditov;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Osoba getVyucujuci() {
        return vyucujuci;
    }

    public void setVyucujuci(Osoba vyucujuci) {
        this.vyucujuci = vyucujuci;
    }

    public int getPocetKreditov() {
        return pocetKreditov;
    }

    public void setPocetKreditov(int pocetKreditov) {
        this.pocetKreditov = pocetKreditov;
    }

    @Override
    public String toString() {
        return this.nazov;
//        return  "Nazov predmetu: " + this.nazov + "\n" +
//                "Vyucujuci: " + this.vyucujuci + "\n" +
//                "PocetKreditov: " + pocetKreditov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Predmet predmet = (Predmet) o;

        if (pocetKreditov != predmet.pocetKreditov) return false;
        if (nazov != null ? !nazov.equals(predmet.nazov) : predmet.nazov != null) return false;
        return vyucujuci != null ? vyucujuci.equals(predmet.vyucujuci) : predmet.vyucujuci == null;
    }

    @Override
    public int hashCode() {
        int result = nazov != null ? nazov.hashCode() : 0;
        result = 31 * result + (vyucujuci != null ? vyucujuci.hashCode() : 0);
        result = 31 * result + pocetKreditov;
        return result;
    }
}
