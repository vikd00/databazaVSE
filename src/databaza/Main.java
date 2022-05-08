package databaza;

import databaza.osoby.Externista;
import databaza.osoby.Osoba;
import databaza.osoby.Student;
import databaza.osoby.Ucitel;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        Skola skola = new Skola("VSE", "Winstona Churchilla");
//
//        Ucitel u1 = new Ucitel(skola.generujId(), "Jozef", "Mrkvicka","jozm11@vse.cz");
//        Ucitel u2 = new Ucitel(skola.generujId(), "Jozef2", "Mrkvicka2","jozm11@vse.cz2");
//        Ucitel u3 = new Ucitel(skola.generujId(), "Jozef2", "Mrkvicka2","jozm11@vse.cz2");
//        Predmet p1 = new Predmet("4IZ110", u1, 5);
//        Predmet p2 = new Predmet("4IZ110", u1, 5);
//        Predmet p3 = new Predmet("4IZ113", u1, 5);
//
//        HashMap<Predmet ,Integer> predmety = new HashMap<>();
//        predmety.put(p1 ,1);
//        predmety.put(p2, 2);
//
//        Student s1 = new Student(skola.generujId(), "David", "Vikor", "vikd00@vse.cz", "Bakalarske", predmety );
//
//        ArrayList<Osoba> ucitelia = new ArrayList<>();
//        ucitelia.add(u1);
//        ucitelia.add(u2);
//        ucitelia.add(s1);
//
//
//
//
//        Fakulta fis = new Fakulta("FIS", 300000, ucitelia);
//        skola.addFakulta(fis);
//
//        System.out.println(skola.getFakulty().get("FIS").getZoznamUcitelov().get(0));
//        skola.getFakulty().get("FIS").getZoznamUcitelov().get(0).zapisZnamku(p1,1,5);
//        System.out.println(skola);

        Fakulta f1 = new Fakulta("FIS", 300000);
        Fakulta f2 = new Fakulta("FFU", 304000);
        Skola skola = new Skola("VSE", "Winstona Churchilla");
        skola.pridajFakultu(f1);
        skola.pridajFakultu(f2);
        skola.pridajFakultu(new Fakulta("FHM", 302000));
        skola.getFakulty().get("FFU").vlozOsobu(new Student(skola.generujUnikatneID(), "David", "Vikor", "vikd00@vse.cz", "Bakalarske"));
        skola.getFakulty().get("FIS").vlozOsobu(new Student(skola.generujUnikatneID(), "Jano", "Janosik", "janj00@vse.cz", "Magisterske"));
        skola.getFakulty().get("FIS").vlozOsobu(new Ucitel(skola.generujUnikatneID(), "Ernest", "Vlek", "ernv00@vse.cz", 25000));
        Predmet p1 = new Predmet("4IZ110", skola.vyhladajPodlaID(4),5 );
        skola.getFakulty().get("FIS").vlozPredmet(p1);
        ((Ucitel) skola.getFakulty().get("FIS").getZoznamOsob().get(4)).zapisZnamku(p1,2, 4);
        skola.presunOsobuMedziFakultami(3, f1.getNazov(), f2.getNazov());
        System.out.println(skola.getFakulty().get("FIS").getZoznamOsob());
        System.out.println(skola.getFakulty().get("FFU").getZoznamOsob());

        Externista e1 = new Externista(1,"A","b","SAS");

        try {
            FileWriter writer = new FileWriter("objects.txt");
            String json = (new Gson().toJson(e1));
            writer.write(json+"\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldnt create");
        }

        Gson gson = new Gson();
        try {
            Scanner scanner = new Scanner(new File("objects.txt"));

            while (scanner.hasNextLine()) {
                String json = scanner.nextLine();
                Externista testcopy = gson.fromJson(json, Externista.class);
                System.out.println(testcopy.getMeno() + testcopy.getPriezvysko() + testcopy.getEmail());
                //System.out.println(testcopy.test2);
            }
            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
