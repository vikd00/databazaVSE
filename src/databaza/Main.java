package databaza;

public class Main {
    /**
     * @autor David Vikor, Andrej Makel, Libor Mladsi
     * @version 1.0
     * **/

    public static void main(String[] args) {
        Skola skola = new Skola("VSE", "Winstona Churchilla");
        PersistentcyHandler persistentcyHandler = new PersistentcyHandler(skola);
        persistentcyHandler.saveToFile();
        persistentcyHandler.loadFromFile();

    }
}
