package databaza;

import databaza.osoby.Osoba;
import databaza.osoby.Student;
import databaza.osoby.Ucitel;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Ucitel u1 = new Ucitel(2, "Jozef", "Mrkvicka","jozm11@vse.cz");
        Ucitel u2 = new Ucitel(2, "Jozef2", "Mrkvicka2","jozm11@vse.cz2");
        Ucitel u3 = new Ucitel(33, "Jozef2", "Mrkvicka2","jozm11@vse.cz2");
        Predmet p1 = new Predmet("4IZ110", u1, 5);
        Predmet p2 = new Predmet("4IZ110", u1, 5);
        Predmet p3 = new Predmet("4IZ113", u1, 5);

        HashMap<Predmet ,Integer> predmety = new HashMap<>();
        predmety.put(p1 ,1);
        predmety.put(p2, 2);

        Student s1 = new Student(1, "David", "Vikor", "vikd00@vse.cz", "Bakalarske", predmety );

        ArrayList<Osoba> ucitelia = new ArrayList<>();
        ucitelia.add(u1);
        ucitelia.add(u2);
        ucitelia.add(s1);




        Fakulta fis = new Fakulta("FIS", 300000, ucitelia);

        Skola skola = new Skola("VSE", "Winstona Churchilla");
        System.out.println(skola);
        skola.addFakulta(fis);
        skola.pridajOsobuNaFakultu(fis, u3);
        System.out.println(skola);

        skola.zapisStudentoviZnamku(p1,21,12,12);
        System.out.println(skola);

    }
}
