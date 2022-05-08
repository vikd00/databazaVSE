package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Student;
import databaza.osoby.Ucitel;

import java.util.ArrayList;

/**
 * ISkola
 * Interface pre implementaciu objektu skola.
 */
public interface ISkola {
    /**
     * Tato funkcia zabezpecuje pridavanie fakulty v ramci skoly.
     * @param fakulta Objekt typu fakulta ktory chceme pridat.
     * @return Uspesnost operacie.
     */
    public boolean pridajFakultu(Fakulta fakulta);
    /**
     * Tato funkcia zabezpecuje pridavanie fakulty v ramci skoly.
     * @param nazov Nazov pre fakultu ktoru chceme vytvorit.
     * @param rozpocet Razov pre fakultu ktoru chceme vytvorit.
     * @return Uspesnost operacie.
     */
    public boolean pridajFakultu(Fakulta fakulta, String nazov, int rozpocet);
    /**
     * Tato funkcia zabezpecuje odstranenie fakulty v ramci skoly.
     * @param fakulta Objekt typu fakulta ktory chceme odstranit.
     * @return Uspesnost operacie.
     */
    public boolean odoberFakulta(Fakulta fakulta);

    /**
     * Tato funkcia zabezpecuje pridavanie osob na fakultu v ramci skoly.
     * @param fakulta Nazov pre fakultu na ktoru chceme osobu priradit.
     * @param osoba Objekt osoby ktoru chceme vlozit na fakultu.
     * @return Uspesnost operacie.
     */
    public boolean pridajOsobu(Fakulta fakulta, Osoba osoba);

    /**
     * Tato funkcia zabezpecuje odstranovanie osob z fakulty v ramci skoly.
     * @param fakulta Nazov pre fakultu z ktorej chceme osobu odstranit.
     * @param osoba Objekt osoby ktoru chceme odstranit z fakulty.
     * @return Uspesnost operacie.
     */
    public boolean odstranOsobu(Fakulta fakulta, Osoba osoba);

    /**
     * Tato funkcia zabezpecuje generovanie unikatneho ID. Pre nase potreby sa jedna o jednoduche ID zalozene
     * na udrziavani si hodnoty posledneho vygenerovaneho ID a inkrementovanie ho o 1.
     * @return Unikatne ID pre osoby v nasej skole.
     */
    public int generujUnikatneID();

    /**
     * Tato funkcia zabezpecuje vyhladavanie osob v ramci celej skoly podla ID.
     * @param osobneID ID osoby ktoru hladame.
     * @return Osoba, ktoru hladame. Jedna sa o jednu osobu, kedze ID je unikatne.
     */
    public Osoba vyhladajPodlaID(int osobneID);

    /**
     * Tato funkcia zabezpecuje vyhladavanie osob v ramci celej skoly podla mena.
     * @param meno Meno osoby ktoru hladame.
     * @return Osoby ktorych meno zodpoveda kriteriu hladania.
     */
    public ArrayList<Osoba> vyhladajPodlaMena(String meno);

    /**
     * Tato funkcia zabezpecuje vyhladavanie osob podla fakulty.
     * @param nazovFakulty Meno fakulty, ktorej osoby hladame.
     * @return Osoby ktorych fakulta zodpoveda kriteriu hladania.
     */
    public ArrayList<Osoba> vyhladajPodlaFakulty(String nazovFakulty);

    /**
     * Tato funkcia zabezpecuje zapisovanie znamok ucitelom.
     * @param ucitel Meno ucitela, ktory na znamku zapisat.
     * @param predmet Predmet v ktoreho ma byt znamka zapisana.
     * @param student Meno studenta, ktory na znamku dostat.
     * @param znamka Znamka ktoru ma ucitel zapisat studentovi.
     * @return Uspesnost operacie.
     */
    public boolean zapisZnamku(Ucitel ucitel, Predmet predmet, Student student, int znamka);
}
