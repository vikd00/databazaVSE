package databaza.osoby;

public class Externista extends Osoba{
    private int pracovnyFondHodin;

    public Externista(int id, String meno, String priezvysko, String email) {
        super(id, meno, priezvysko, email);
    }

    public Externista(int id, String meno, String priezvysko, String email, int pracovnyFondHodin) {
        super(id, meno, priezvysko, email);
        this.pracovnyFondHodin = pracovnyFondHodin;
    }

    public int getPracovnyFond() {
        return pracovnyFondHodin;
    }

    public void setPracovnyFond(int pracovnyFondHodin) {
        this.pracovnyFondHodin = pracovnyFondHodin;
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
