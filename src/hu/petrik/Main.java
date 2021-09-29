package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesLista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        Bejegyzes bejegyzes1 = new Bejegyzes("Random1", "Test1");
        Bejegyzes bejegyzes2 = new Bejegyzes("Random2", "Test2");

        bejegyzesLista.add(bejegyzes1);
        bejegyzesLista.add(bejegyzes2);

        bejegyzesLista.addAll(fajlBeolvaso("bejegyzesek.txt"));

        System.out.print("adj egy számot: ");
        int szam = sc.nextInt();
        for (int i = 0; i < szam; i++) {
            System.out.print("Szerző? ");
            String szerzo = sc.next();
            System.out.print("Bejegyzés tartalma? ");
            String tartalom = sc.next();

            bejegyzesLista.add(new Bejegyzes(szerzo, tartalom));
        }
    }
        public static void randomLikok(){
            int meret = bejegyzesLista.size();
            for (int i = 0; i < 20; i++) {
                int random = rnd.nextInt(meret - 0) + 0;
                bejegyzesLista.get(random).getLikeok();
            }
        }

    public static void felhasznaloModositsaMasodikBejegyzest() {
        String tartalom;
        System.out.print("A 2. bejegyzésnek módosulnia kell\n\tAdjon újat: ");
        tartalom = sc.next();
        bejegyzesLista.get(1).setTartalom(tartalom);
    }


    public static List<Bejegyzes> fajlBeolvaso(String fajlNev) {
        ArrayList<Bejegyzes> bejegyzesLista = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] adatok = line.split(";");
                Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
                bejegyzesLista.add(bejegyzes);
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bejegyzesLista;
    }
}
