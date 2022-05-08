package databaza;

import databaza.osoby.Osoba;

import java.util.HashMap;

/**
 * IFakulta
 * Interface pre implementaciu objektu fakulta.
 */
public interface IFakulta {
    /**
     * Tato funkcia zabezpecuje pridavanie osob v ramci fakulty.
     * @param osoba Objekt typu Osoba ktory chceme pridat.
     * @return Uspesnost operacie.
     */
    public boolean vlozOsobu(Osoba osoba);

    /**
     * Tato funkcia zabezpecuje odstranovanie osob z fakulty v ramci skoly.
     * @param osobaID Id osoby ktoru chceme odstranit z fakulty.
     * @return Uspesnost operacie.
     */
    public boolean odoberOsobu(int osobaID);

    /**
     * Tato funkcia prejde vsetky objekty a pri tych ktore su typu Ucitel ziska ich harok so znamkami
     * a nasledne ich spoji do jedneho globalneho harka
     * @return mapa(Objekt predmetu, mapa(ID ziaka, Znamka))
     */
    public HashMap<Predmet, HashMap<Integer, Integer>> vygenerujGlobalnyHarokZnamok();

}
