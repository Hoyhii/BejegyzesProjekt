package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        legnepszerubb();
        randomLikok();
        felhasznaloModositsaMasodikBejegyzest();
        konzolraIratas();
    }

    public static void randomLikok() {
        int meret = bejegyzesLista.size();
        for (int i = 0; i < 20; i++) {
            int random = rnd.nextInt(meret);
            bejegyzesLista.get(random).getLikeok();
        }
    }

    public static void felhasznaloModositsaMasodikBejegyzest() {
        String tartalom;
        System.out.print("A 2. bejegyzésnek módosulnia kell\n\tAdjon újat: ");
        tartalom = sc.next();
        bejegyzesLista.get(1).setTartalom(tartalom);
    }

    public static void konzolraIratas() {
        String bejegyzesek = "";
        for (Bejegyzes bejegyzes : bejegyzesLista) {
            bejegyzesek += bejegyzes + "\n";
        }
        System.out.println(bejegyzesek);
    }
    public static void harmincotnelTobbLike(){
        int likeszam = 0;
        for (var item: bejegyzesLista) {
            if(item.getLikeok() > 35)
                likeszam++;
        }
        System.out.println("Ennyi bejegyzésre likeoltak 35-nél többen: " + likeszam);
    }
    public static void tizenotnelKevesebbLike(){
        int likeszam = 0;

        for (var item: bejegyzesLista) {
            if(item.getLikeok() < 15)
                likeszam++;
        }

        System.out.println("Ennyi bejegyzésre likoltak 15-nél kevesebben: " + likeszam);
    }
    public static void csokkenobe(){

        System.out.println("Csökkenő sorrendbe rendezve: ");
        Collections.sort(bejegyzesLista, Collections.reverseOrder());

        for (Bejegyzes bejegyzes: bejegyzesLista) {
            System.out.println(bejegyzes);
        }
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

    public static void legnepszerubb() {
        int legTobbLike = 0;
        for (int i = 0; i < bejegyzesLista.size(); i++) {
            if (bejegyzesLista.get(legTobbLike).getLikeok() < bejegyzesLista.get(i).getLikeok()) {
                legTobbLike = i;
            }
        }
        System.out.println("Legnépszerübb bejegyzés: \n" + bejegyzesLista.get(legTobbLike));
    }
}