package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Student;
import databaza.osoby.Ucitel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ISkola
 * Interface pre implementaciu objektu skola.
 */
public interface ISkola {
    /**
     * Tato funkcia zabezpecuje pridavanie fakulty v ramci skoly.
     *
     * @param fakulta Objekt typu fakulta ktory chceme pridat.
     * @return Uspesnost operacie.
     */
    public boolean pridajFakultu(Fakulta fakulta);


    /**
     * Tato funkcia zabezpecuje pridavanie fakulty v ramci skoly.
     *
     * @param nazov    Nazov pre fakultu ktoru chceme vytvorit.
     * @param rozpocet Razov pre fakultu ktoru chceme vytvorit.
     * @return Uspesnost operacie.
     */
    public boolean pridajFakultu(String nazov, int rozpocet);


    /**
     * Tato funkcia zabezpecuje odstranenie fakulty v ramci skoly.
     *
     * @param fakulta Objekt typu fakulta ktory chceme odstranit.
     * @return Uspesnost operacie.
     */
    public boolean odoberFakultu(Fakulta fakulta);


    /**
     * Tato funkcia zabezpecuje odstranenie fakulty v ramci skoly.
     *
     * @param nazovFakulty nazov fakulty ktoru chceme odstranit.
     * @return Uspesnost operacie.
     */
    public boolean odoberFakultu(String nazovFakulty);


    /**
     * Tato funkcia zabezpecuje pridavanie osob na fakultu v ramci skoly.
     *
     * @param fakulta Nazov fakulty na ktoru chceme osobu priradit.
     * @param osoba   Objekt osoby ktoru chceme vlozit na fakultu.
     * @return Uspesnost operacie.
     */
    public boolean pridajOsobu(Fakulta fakulta, Osoba osoba);


    /**
     * Tato funkcia zabezpecuje odstranovanie osob z fakulty v ramci skoly.
     *
     * @param osobaId Id osoby ktoru chceme odstranit z fakulty.
     * @return Uspesnost operacie.
     */
    public boolean odstranOsobu(int osobaId);

    /**
     * Tato funkcia zabezpecuje presuvanie osob medzi fakultami.
     *
     * @param osobneID      ID osoby ktoru presuvame.
     * @param nazovFakultyA Meno fakulty,z ktorej osoby berieme.
     * @param nazovFakultyB Meno fakulty,do ktorej osoby vkladame.
     * @return Uspesnost operacie.
     */
    public boolean presunOsobuMedziFakultami(int osobneID, String nazovFakultyA, String nazovFakultyB);


    /**
     * Tato funkcia zabezpecuje generovanie unikatneho ID. Pre nase potreby sa jedna o jednoduche ID zalozene
     * na udrziavani si hodnoty posledneho vygenerovaneho ID a inkrementovanie ho o 1.
     *
     * @return Unikatne ID pre osoby v nasej skole.
     */
    public int generujUnikatneID();


    /**
     * Tato funkcia zabezpecuje vyhladavanie osob v ramci celej skoly podla ID.
     *
     * @param osobneID ID osoby ktoru hladame.
     * @return Osoba, ktoru hladame. Jedna sa o jednu osobu, kedze ID je unikatne.
     */
    public Osoba vyhladajPodlaID(int osobneID);


    /**
     * Tato funkcia zabezpecuje vyhladavanie osob v ramci celej skoly podla mena.
     *
     * @param meno Meno osoby ktoru hladame.
     * @return Osoby ktorych meno zodpoveda kriteriu hladania.
     */
    public ArrayList<Osoba> vyhladajPodlaMena(String meno);


    /**
     * Tato funkcia zabezpecuje vyhladavanie osob podla fakulty.
     *
     * @param nazovFakulty Meno fakulty, ktorej osoby hladame.
     * @return Osoby ktorych fakulta zodpoveda kriteriu hladania.
     */
    public ArrayList<Osoba> vyhladajPodlaFakulty(String nazovFakulty);

    /**
     * Tato funkcia prejde vsetky globalne harky fakult a vytvori z nich jeden globalny harok
     * a tie znamky nasledne nastavy ziakom -> teda aj ak sa zmeni v classe ziak znamka, bude
     * prepisana pri dalsom update
     *
     * @return mapa(Objekt predmetu, mapa ( ID ziaka, Znamka))
     */
    public HashMap<Predmet, HashMap<Integer, Integer>> vygenerujGlobalnyHarokZnamok();

    /**
     * Tato funkcia prejde vsetkych ziakov a zapise im znamky z globalneho harku, do ktoreho
     * moze zapisovat len ucitel
     *
     * @return Uspesnost operacie.
     */
    public boolean zapisStudentomDokoncenePredmety();
}
