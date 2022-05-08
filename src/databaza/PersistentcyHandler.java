package databaza;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import databaza.osoby.Osoba;
import databaza.osoby.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class PersistentcyHandler {
    private Skola skola;

    public PersistentcyHandler(Skola skola) {
        this.skola = skola;
    }

    public boolean saveToFile(){
        ArrayList<DataOsoba> zoznamOsob = new ArrayList<>();

        for(Fakulta f : skola.getFakulty().values()){
            for(Osoba o : f.getZoznamOsob().values()){
                DataOsoba dataOsoba = new DataOsoba();
                dataOsoba.setEmail(o.getEmail());
                dataOsoba.setMeno(o.getMeno());
                dataOsoba.setPriezvysko(o.getPriezvysko());
                dataOsoba.setId(o.getId());
                zoznamOsob.add(dataOsoba);
            }
        }

        Type type = new TypeToken<ArrayList<DataOsoba>>(){}.getType();

        try {
            FileWriter writer = new FileWriter("objects.txt");
            JsonElement element = new Gson().toJsonTree(zoznamOsob, type);
            JsonArray jsonArray = element.getAsJsonArray();
            String json = (new Gson().toJson(jsonArray));
            writer.write(json +"\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldnt create");
            return false;
        }
        return true;
    }

    public boolean loadFromFile(){
        ArrayList<DataOsoba> zoznamOsob = new ArrayList<>();
        Gson gson = new Gson();
        try {
            Scanner scanner = new Scanner(new File("objects.txt"));

            while (scanner.hasNextLine()) {
                String json = scanner.nextLine();
                DataOsoba testcopy = gson.fromJson(json, DataOsoba.class);
                System.out.println(testcopy);
            }
            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
