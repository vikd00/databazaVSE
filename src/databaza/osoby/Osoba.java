package databaza.osoby;

public abstract  class Osoba {
    private int id;
    private String meno;
    private String priezvysko;
    private String email;

    public Osoba(int id, String meno, String priezvysko, String email) {
        this.meno = meno;
        this.priezvysko = priezvysko;
        this.email = email;
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "ID: " + this.id + " " + this.meno + " " + this.priezvysko;
        //return "ID: " + this.id + "\n" + "Meno: " + this.meno + "\nPrievisko: " + this.priezvysko + "\nEmail: " + this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Osoba osoba = (Osoba) o;

        return id == osoba.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
