package zad1;

import java.util.ArrayList;
import java.util.Map;

//To jest klasa odpowiadająca za instrukcję "jedz".
public class Jedz extends Instrukcja{

    public void wykonaj(Rob rob) {
        Pole lok = rob.getLokalizacja();
        ArrayList<Pole> s_na_ukos = lok.getSąsiedzi_na_ukos();
        Map<Character, Pole> s_bliscy = lok.getBliscy_sąsiedzi();

        //jak już znajdziemy pole z pożywieniem kończymy wywołanie
        for(Pole pole : s_bliscy.values()) {
            if(pole.czyPełne()) {
                rob.wejdźNaPole(pole);
                rob.zjedzJedzenie(pole);
                return;
            }
        }
        for(Pole pole : s_na_ukos) {
            if(pole.czyPełne()) {
                rob.wejdźNaPole(pole);
                rob.zjedzJedzenie(pole);
                return;
            }
        }
    }

    public Character charSymbol() { return 'j'; }
}
