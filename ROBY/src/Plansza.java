package zad1;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/*
To jest klasa reprezentująca planszę, na której żyją roby.
Przechowuje wszystkie swoje pola, wymiar oraz ilość pól z żywnością.
 */
public class Plansza {
    private int rozmiar_planszy_x;
    private int rozmiar_planszy_y;
    private Pole[][] pola;
    private int liczba_pól_z_żywnością;

    public Plansza() throws FileNotFoundException {
        class BłędnyZnak extends Exception { }
        class RóżneDługościWierszy extends Exception { }
        class ZaMałoWierszyLubKolumn extends Exception{ }

        Scanner sc = new Scanner(new File("plansza.txt"));
        int x = 0, y = 0;
        String line;

        try { //najpierw identyfikujemy wymiar planszy
            String s;
            Scanner counter = new Scanner(new File("plansza.txt"));
            if(counter.hasNextLine()) {
                x = counter.nextLine().length();
                y += 1;
            }
            while(counter.hasNextLine()) {
                y += 1;
                s = counter.nextLine();
                if(s.length() != x) throw new RóżneDługościWierszy();
            }
            counter.close();
            if(x == 0 || y == 0) throw new ZaMałoWierszyLubKolumn();
        }
        catch (ZaMałoWierszyLubKolumn w) {
            System.out.println("Za mało wierszy lub kolumn w pliku plansza.txt");
            System.exit(1);
        }
        catch (RóżneDługościWierszy w) {
            System.out.println("Różne długości wierszy w pliku plansza.txt - plansza nie jest prostokątem");
            System.exit(1);
        }


        int pola_żywieniowe = 0;

        pola = new Pole[y][x];
        int current_line = 0;

        try{
            while(sc.hasNextLine()) {
                line = sc.nextLine();

                for(int i = 0; i < x; i++) {
                    if(line.charAt(i) == 'x') {
                        pola[current_line][i] = new PoleŻywieniowe(current_line, i);
                        pola_żywieniowe += 1;
                    }
                    else if(line.charAt(i) == ' ') pola[current_line][i] = new PolePuste(current_line, i);
                    else throw new BłędnyZnak();
                }
                current_line += 1;
            }
            sc.close();
        }
        catch (BłędnyZnak w) {
            System.out.println("Błędny znak w pliku plansza.txt");
            System.exit(1);
        }


        liczba_pól_z_żywnością = pola_żywieniowe;
        rozmiar_planszy_x = x;
        rozmiar_planszy_y = y;
        ustawSąsiadówPól();
    }

    private void ustawSąsiadówPól() {
        for(int i = 0; i < rozmiar_planszy_y; i++) {
            for(int j = 0; j < rozmiar_planszy_x; j++) {
                Map<Character, Pole> bliscy_s = new HashMap<>();
                ArrayList<Pole> ukośni_s = new ArrayList<>();

                bliscy_s.put('p', pola[i][(j+1)%rozmiar_planszy_x]);
                if(j > 0) bliscy_s.put('l', pola[i][j-1]);
                else bliscy_s.put('l', pola[i][rozmiar_planszy_x - 1]);

                bliscy_s.put('g', pola[(i+1)%rozmiar_planszy_y][j]);
                if(i > 0) bliscy_s.put('d', pola[i-1][j]);
                else bliscy_s.put('d', pola[rozmiar_planszy_y - 1][j]);

                ukośni_s.add(pola[(i+1)%rozmiar_planszy_y][(j+1)%rozmiar_planszy_x]);
                if(i > 0) ukośni_s.add(pola[i-1][(j+1)%rozmiar_planszy_x]);
                else ukośni_s.add(pola[rozmiar_planszy_y - 1][(j+1)%rozmiar_planszy_x]);
                if(j > 0) ukośni_s.add(pola[(i+1)%rozmiar_planszy_y][j-1]);
                else ukośni_s.add(pola[(i+1)%rozmiar_planszy_y][rozmiar_planszy_x - 1]);

                if(i > 0 && j > 0) ukośni_s.add(pola[i-1][j-1]);
                else if (i > 0) ukośni_s.add(pola[i-1][rozmiar_planszy_x - 1]);
                else if (j > 0) ukośni_s.add(pola[rozmiar_planszy_y - 1][j-1]);
                else ukośni_s.add(pola[rozmiar_planszy_y - 1][rozmiar_planszy_x - 1]);

                pola[i][j].ustawSąsiadów(bliscy_s, ukośni_s);
            }
        }
    }

    public void aktualizujPolazŻywieniem() {
        int licznik = 0;
        for(int i = 0; i < rozmiar_planszy_y; i++) {
            for(int j = 0; j < rozmiar_planszy_x; j++) {
                if(pola[i][j].czyPełne()) licznik++;
            }
        }
        liczba_pól_z_żywnością = licznik;
    }

    public Pole getPole(int y, int x) { return pola[y][x]; }
    public int getRozmiar_planszy_x() { return rozmiar_planszy_x; }
    public int getRozmiar_planszy_y() { return rozmiar_planszy_y; }
    public int getLiczba_pól_z_żywnością() { return liczba_pól_z_żywnością; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < rozmiar_planszy_y; i++) {
            for(int j = 0; j < rozmiar_planszy_x; j++) {
                if(pola[i][j].czyPełne()) s.append("x");
                else s.append(".");
            }
            s.append("\n");
        }
        return s.toString();
    }
}