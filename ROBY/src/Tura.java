package zad1;

import java.util.ArrayList;

/*
To jest klasa reprezentująca pojedynczą turę.
Odowiada za uzupełnianie jedzenia na planszy, wypisywanie danych,
oraz wykonanie odpowiednich czynności orzez roby.
 */
public class Tura {
    private int numer;
    private int koszt_tury;
    private Plansza plansza;
    private CentrumDanychORobach cdr;
    private ArrayList<Rob> nowe_roby;
    private Mutacja mutacja; //obiekt mutacja potrzebny do mutowania programów robów
    private int ile_rośnie_jedzenie;
    private int co_ile_wypisz;

    public Tura(int numer, CentrumDanychORobach cdr, Mutacja mutacja,
                int ile_rośnie_jedzenie, int koszt_tury, Plansza plansza, int co_ile_wypisz) {

        this.plansza = plansza;
        this.mutacja = mutacja;
        this.numer = numer;
        this.koszt_tury = koszt_tury;
        this.cdr = cdr;
        this.co_ile_wypisz = co_ile_wypisz;
        nowe_roby = new ArrayList<>();
        this.ile_rośnie_jedzenie = ile_rośnie_jedzenie;
    }

    public void wykonajTurę() {
        //na początku tury pojawia się jedzenie na zregenerowanych polach
        for(int i = 0; i < plansza.getRozmiar_planszy_y(); i++) {
            for(int j = 0; j < plansza.getRozmiar_planszy_x(); j++) {
                Pole pole = plansza.getPole(i, j);
                if(pole.czyŻywieniowe() && !pole.czyPełne()
                   && pole.getCzas_Regeneracji() == ile_rośnie_jedzenie) {
                    pole.regenerujJedzenie();
                }
            }
        }

        ArrayList<Rob> żywe_roby = cdr.getŻyweRoby();
        for(Rob rob : żywe_roby) {
            rob.wykonajTurę(koszt_tury, this, mutacja);
        }

        //aktualizujemy dane w cdr - być może nowe roby się pojawiły albo jakieś zmarły
        cdr.rejestrujNoweRoby(nowe_roby);
        cdr.rejestrujZmarłeRoby();
        cdr.aktualizujDane();

        //na koniec tury zwiększamy czas regeneracji pól o 1
        for(int i = 0; i < plansza.getRozmiar_planszy_y(); i++) {
            for(int j = 0; j < plansza.getRozmiar_planszy_x(); j++) {
                if(plansza.getPole(i,j).żywieniowe && !plansza.getPole(i,j).czyPełne())
                    plansza.getPole(i,j).zwiekszCzasRegeneracji();
            }
        }

        plansza.aktualizujPolazŻywieniem();
        RaportOEwolucji raport = new RaportOEwolucji(plansza, cdr, numer);
        if(numer % co_ile_wypisz == 0) raport.zdajRaportSzczegółowy();
        raport.zdajRaportPodstawowy();
    }

    public void dodajNowegoRoba(Rob rob) {
        nowe_roby.add(rob);
    }
}
