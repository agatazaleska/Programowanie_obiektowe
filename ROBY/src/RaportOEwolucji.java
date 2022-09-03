package zad1;

import java.util.ArrayList;

/*
To jest klasa odpowiadająca za raport zdawany pod koniec tury.
Przechowuje dane potrzebne do raportu.
Dysponuje raportem szczegółowym oraz podstawowym.
 */
public class RaportOEwolucji {
    Plansza plansza;
    CentrumDanychORobach cdr;
    int numer_tury;

    public RaportOEwolucji(Plansza plansza, CentrumDanychORobach cdr, int numer_tury) {
        this.cdr = cdr;
        this.plansza = plansza;
        this.numer_tury = numer_tury;
    }

    //szczegółowe informacje o każdym robie, oraz wydruk planszy
    public void zdajRaportSzczegółowy() {
        System.out.println("Szczegółowy opis stanu symulacji:");
        System.out.println("Plansza: (x - pola z pożywieniem . - pola bez pożywienia)");
        System.out.print(plansza.toString());

        System.out.println("Informacje o robach: ");
        ArrayList<Rob> roby = cdr.getŻyweRoby();
        if(roby.size() == 0) System.out.println("brak żywych robów :(");
        for(int i = 0; i < roby.size(); i++) {
            Rob rob = roby.get(i);
            System.out.println("Rob " + (i+1) + roby.get(i).toString());
        }
        System.out.print("\n");
    }

    //podstawowe informacje o stanie plamszy, oraz dane z CentrumDanychORobach
    public void zdajRaportPodstawowy() {
        System.out.println("Podstawowe dane o symulacji:");
        System.out.println( numer_tury + ", rob: " + cdr.getŻyweRoby().size() + ", żyw: " +
        plansza.getLiczba_pól_z_żywnością() + ", prg: " + cdr.getMin_prg() + "/" + String.format("%.2f",cdr.getŚr_prg()) + "/" +
        cdr.getMax_prg() + ", energ: " + cdr.getMin_energaia() + "/" + String.format("%.2f", cdr.getŚr_energaia()) + "/" +
        cdr.getMax_energia() + ", wiek: " + cdr.getMin_wiek() + "/" + String.format("%.2f", cdr.getŚr_wiek()) + "/" + cdr.getMax_wiek() + "\n");
    }
}
