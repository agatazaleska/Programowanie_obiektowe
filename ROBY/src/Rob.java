package zad1;

import java.util.Random;

/*
To jest klasa odpowiadająca za Roba. Przechowuje wszystkie dane o nim,
oraz dane potrzebne do powielenia oraz pożywienia się.
 */
public class Rob {
    private Program program;
    private Character kierunek;
    private int wiek;
    private Pole lokalizacja;
    private int energia;
    private int ile_daje_jedzenie;
    private int limit_powielenia;
    private boolean czy_żywy;
    private double pr_powielenia;
    private double ułamek_energii_dla_potomstwa;

    public Rob(int ile_daje_jedzenie, String kod_progr, int energia, double pr_powielenia,
               double ułamek_energii_rodzica, Pole lokalizacja, Character kierunek, int limit_powielenia) {

        czy_żywy = true;
        wiek = 0;
        this.ile_daje_jedzenie = ile_daje_jedzenie;
        this.energia = energia;
        this.kierunek = kierunek;
        this.lokalizacja = lokalizacja;
        this.pr_powielenia = pr_powielenia;
        ułamek_energii_dla_potomstwa = ułamek_energii_rodzica;
        program = new Program(kod_progr);
        this.limit_powielenia = limit_powielenia;
    }

    //funkcja odpowiadająca za wykonanie wszystkich czynności wchodzących w skład tury
    public void wykonajTurę(int kosz_tury, Tura tura, Mutacja mutacja) {
        pobierzEnergie(kosz_tury);
        if (energia < 0) {
            zgiń();
            return;
        }
        wykonajProgram();
        if (!czy_żywy) return;

        Random rand = new Random();
        boolean czy_powielać = rand.nextDouble() <= pr_powielenia;

        if (czy_powielać && energia >= limit_powielenia) {
            Rob nowy_rob = powielSie(mutacja);
            tura.dodajNowegoRoba(nowy_rob);
        }
        wiek += 1;
    }

    //funkcja powielająca roba - zwraca nowego roba
    private Rob powielSie(Mutacja mutacja) {
        Character nowy_kierunek;
        if (kierunek == 'p') nowy_kierunek = 'l';
        else if (kierunek == 'l') nowy_kierunek = 'p';
        else if (kierunek == 'g') nowy_kierunek = 'd';
        else nowy_kierunek = 'g';

        int energia_dziecka = (int) Math.floor(ułamek_energii_dla_potomstwa * energia);
        pobierzEnergie(energia_dziecka);

        String nowy_program = mutacja.mutujKodProgramu(program.getKod_programu());
        return new Rob(ile_daje_jedzenie, nowy_program, energia_dziecka, pr_powielenia,
                       ułamek_energii_dla_potomstwa, lokalizacja, nowy_kierunek, limit_powielenia);
    }

    //funkcja wykonująca wszystkie instrukcje wchodzące w skład programu roba
    private void wykonajProgram() {
        for (Instrukcja instrukcja : program.getInstrukcje()) {
            if (energia > 0) {
                pobierzEnergie(1);
                instrukcja.wykonaj(this);
            } else {
                zgiń();
                return;
            }
        }
    }

    private void zgiń() { czy_żywy = false; }

    public boolean żywy() { return czy_żywy; }

    private void pobierzEnergie(int ile) { energia -= ile; }

    public int getWiek() { return wiek; }
    public int getEnergia() { return energia; }
    public Character getKierunek() { return kierunek; }
    public Pole getLokalizacja() { return lokalizacja; }
    public Program getProgram() { return program; }

    public void setKierunek(Character kierunek) { this.kierunek = kierunek; }
    public void wejdźNaPole(Pole lokalizacja) { this.lokalizacja = lokalizacja; }

    //funkcja odpowiadająca za jedzenie
    public void zjedzJedzenie(Pole p) {
        energia += ile_daje_jedzenie;
        p.zabierzJedzenie();
    }

    public String toString() {
        return (": lokalizacja - (" + lokalizacja.getKoord_y() +
                "," + lokalizacja.getKoord_x() + ")" + (lokalizacja.czyŻywieniowe() ? " - pole żywieniowe" : " - pole puste") +
                ", energia - " + energia + ", wiek - " +
                wiek + ", program - " + ( program.getInstrukcje().size() == 0 ? "pusty" : program.getKod_programu()));
    }
}



