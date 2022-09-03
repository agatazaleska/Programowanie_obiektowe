package zad1;
import zad1.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
To jest klasa odpowiadająca za wykonanie symulacji.
Odpowiada za utworzenie planszy, wygenerowanie robów i przeprowadzenie tur.
 */
public class Symulacja {
    private Parametry parametry;
    private Plansza plansza;

    public Symulacja() throws IOException {
        this.parametry = new Parametry();
        this.plansza = new Plansza();
    }

    //rozmieszczamy roby na losowych polach zwrócone w losowym kierunku
    public ArrayList<Rob> generujRoby(int ile_robów, int ile_daje_jedzenie, String pocz_progr,
                                      int pocz_energia, double pr_powielenia, double ułamek_energii_rodzica) {

        ArrayList<Rob> roby = new ArrayList<>();
        Character[] możliwe_kierunki = {'g', 'd', 'l', 'p'};

        for(int i = 0; i < ile_robów; i++) {
            Random random = new Random();
            int lok_x = random.nextInt(plansza.getRozmiar_planszy_x());
            int lok_y = random.nextInt(plansza.getRozmiar_planszy_y());
            Character kierunek = możliwe_kierunki[random.nextInt(możliwe_kierunki.length)];

            roby.add(new Rob(ile_daje_jedzenie, pocz_progr, pocz_energia, pr_powielenia,
                             ułamek_energii_rodzica, plansza.getPole(lok_y,lok_x), kierunek, parametry.getLimit_powielenia()));
        }
        return roby;
    }

    //funkcja symuluje ewolucję oraz wypisuje jej stan
    public void symulujEwolucję() {
        ArrayList<Rob> roby = generujRoby(parametry.getPocz_ile_robów(), parametry.getIle_daje_jedzenie(),
                                          parametry.getPocz_progr(), parametry.getPocz_energia(),
                                          parametry.getPr_powielenia(), parametry.getUłamek_energii_rodzica());

        CentrumDanychORobach cdr = new CentrumDanychORobach(roby);
        Mutacja mutacja_robów = new Mutacja(parametry.getPr_dodania_instr(), parametry.getPr_usunięcia_instr(),
                                            parametry.getPr_zmiany_instr(), parametry.getSpis_instr());

        System.out.println("STAN POCZĄTKOWY:");
        cdr.aktualizujDane();
        RaportOEwolucji raport = new RaportOEwolucji(plansza, cdr, 0);
        raport.zdajRaportSzczegółowy();

        for(int i = 1; i < parametry.getIle_tur() + 1; i++) {
            Tura obecna_tura = new Tura(i, cdr, mutacja_robów, parametry.getIle_rośnie_jedzenie(),
                                        parametry.getKoszt_tury(), plansza, parametry.getCo_ile_wypisz());
            obecna_tura.wykonajTurę();
        }

        System.out.println("STAN KOŃCOWY:");
        cdr.aktualizujDane();
        raport = new RaportOEwolucji(plansza, cdr, parametry.getIle_tur());
        raport.zdajRaportSzczegółowy();
    }

    public Parametry getParametry() { return parametry; }

    public static void main(String[] args) throws IOException {
        Symulacja symulacja = new Symulacja();
        symulacja.symulujEwolucję();
    }
}
