package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//To jest klasa odpowiadająca za przechowywanie i wczytywanie parametrów z wejścia.
public class Parametry {
    private final int ilość_parametrów = 15;
    private int ile_tur;
    private int ile_daje_jedzenie;
    private int ile_rośnie_jedzenie;
    private int koszt_tury;
    private String spis_instr;
    private int pocz_ile_robów;
    private int pocz_energia;
    private String pocz_progr;
    private double pr_powielenia;
    private double ułamek_energii_rodzica;
    private int limit_powielenia;
    private double pr_zmiany_instr;
    private double pr_usunięcia_instr;
    private double pr_dodania_instr;
    private int co_ile_wypisz;

    public int getIle_tur() { return ile_tur; }
    public int getIle_daje_jedzenie() { return ile_daje_jedzenie; }
    public int getIle_rośnie_jedzenie() { return ile_rośnie_jedzenie; }
    public int getKoszt_tury() { return koszt_tury; }
    public String getSpis_instr() { return spis_instr; }
    public int getPocz_ile_robów() { return pocz_ile_robów; }
    public int getPocz_energia() { return pocz_energia; }
    public String getPocz_progr() { return pocz_progr; }
    public double getPr_powielenia() { return pr_powielenia; }
    public double getUłamek_energii_rodzica() { return ułamek_energii_rodzica; }
    public double getPr_zmiany_instr() { return pr_zmiany_instr; }
    public int getLimit_powielenia() { return limit_powielenia; }
    public double getPr_dodania_instr() { return pr_dodania_instr; }
    public double getPr_usunięcia_instr() { return pr_usunięcia_instr; }
    public int getCo_ile_wypisz() { return co_ile_wypisz; }

    public Parametry() throws FileNotFoundException {
        class NiepoprawnaIlośćParametrów extends Exception { }
        Scanner sc = new Scanner(new File("parametry.txt"));

        try {
            int ile_parametrów = 0;
            while(sc.hasNext()) {
                skanujToken(sc);
                ile_parametrów++;
            }
            if(ile_parametrów != ilość_parametrów) throw new NiepoprawnaIlośćParametrów();
        }
        catch (NiepoprawnaIlośćParametrów w) {
            System.out.println("Niepoprawna ilość parametrów");
            System.exit(1);
        }
    }

    //zczytujemy parametry (sprawdzamy także poprawność danych)
    private void skanujToken(Scanner sc) {
        class NiepoprawnaNazwaParametru extends Exception { }

        try {
            String nazwa_parametru = sc.next();
            switch(nazwa_parametru) {
                case "ile_tur":
                    this.ile_tur = sc.nextInt();
                    break;
                case "ile_daje_jedzenie":
                    this.ile_daje_jedzenie = sc.nextInt();
                    break;
                case "ile_rośnie_jedzenie":
                    this.ile_rośnie_jedzenie = sc.nextInt();
                    break;
                case "koszt_tury":
                    this.koszt_tury = sc.nextInt();
                    break;
                case "spis_instr":
                    this.spis_instr = sc.next();
                    break;
                case "pocz_ile_robów":
                    this.pocz_ile_robów = sc.nextInt();
                    break;
                case "pocz_energia":
                    this.pocz_energia = sc.nextInt();
                    break;
                case "pocz_progr":
                    this.pocz_progr = sc.next();
                    break;
                case "pr_powielenia":
                    this.pr_powielenia = sc.nextDouble();
                    break;
                case "ułamek_energii_rodzica":
                    this.ułamek_energii_rodzica = sc.nextDouble();
                    break;
                case "pr_zmiany_instr":
                    this.pr_zmiany_instr = sc.nextDouble();
                    break;
                case "pr_dodania_instr":
                    this.pr_dodania_instr = sc.nextDouble();
                    break;
                case "pr_usunięcia_instr":
                    this.pr_usunięcia_instr = sc.nextDouble();
                    break;
                case "limit_powielenia":
                    this.limit_powielenia = sc.nextInt();
                    break;
                case "co_ile_wypisz":
                    this.co_ile_wypisz = sc.nextInt();
                    break;
                default:
                    throw new NiepoprawnaNazwaParametru();
            }
        }
        catch (NiepoprawnaNazwaParametru w) {
            System.out.println("Niepoprawna nazwa parametru w pliku parametry.txt");
            System.exit(1);
        }
    }
}
