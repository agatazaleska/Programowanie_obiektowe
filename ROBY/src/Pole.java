package zad1;

import java.util.ArrayList;
import java.util.Map;

/*
To jest klasa odpowiadająca za pole na planszy.
Przechowuje listę swoich sąsiadów skośnych (nie jest istotne który jest który),
oraz Mapę bliskich sąsiadów (chcemy wiedzieć kto jest górnym a kto dolnym sąsiadem).
Pole wie także za ile tur odnowi się na nim jedzenie (jeśli jest żywieniowe)
 */
public abstract class Pole {
    protected Map<Character, Pole> bliscy_sąsiedzi;
    protected ArrayList<Pole> sąsiedzi_na_ukos;
    protected int czas_regeneracji;
    protected int koord_x;
    protected int koord_y;

    protected boolean żywieniowe;

    public abstract boolean czyPełne();
    public abstract void regenerujJedzenie();
    public abstract void zabierzJedzenie();

    public boolean czyŻywieniowe() { return żywieniowe; }

    public void ustawSąsiadów(Map<Character, Pole> bliscy_s,
                              ArrayList<Pole> s_na_ukos) {
        bliscy_sąsiedzi = bliscy_s;
        sąsiedzi_na_ukos = s_na_ukos;
    }

    public Map<Character, Pole> getBliscy_sąsiedzi() { return bliscy_sąsiedzi; }
    public ArrayList<Pole> getSąsiedzi_na_ukos() { return sąsiedzi_na_ukos; }

    public abstract void zwiekszCzasRegeneracji();
    public int getKoord_x() { return koord_x; }
    public int getKoord_y() { return koord_y; }
    public int getCzas_Regeneracji() { return czas_regeneracji; }
}
