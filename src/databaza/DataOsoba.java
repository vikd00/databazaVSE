package databaza;

import databaza.osoby.Osoba;

public class DataOsoba {
    public int id;
    public String meno;
    public String priezvysko;
    public String email;

    public DataOsoba() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvysko() {
        return priezvysko;
    }

    public void setPriezvysko(String priezvysko) {
        this.priezvysko = priezvysko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "ID: " + this.id + " " + this.meno + " " + this.priezvysko;
    }
}
