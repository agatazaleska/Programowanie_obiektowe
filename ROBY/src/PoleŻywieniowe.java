package zad1;

//To jest klasa reprezentująca pole żywieniowe.
public class PoleŻywieniowe extends Pole {
    private boolean czy_pełne;

    public PoleŻywieniowe(int koord_y, int koord_x) {
        this.koord_x = koord_x;
        this.koord_y = koord_y;
        żywieniowe = true;
        czy_pełne = true;
        czas_regeneracji = 0;
    }

    public boolean czyPełne() {
        return czy_pełne;
    }

    //funkcja przywracająca jedzenie na pole
    public void regenerujJedzenie() {
        czy_pełne = true;
        czas_regeneracji = 0;
    }

    public void zwiekszCzasRegeneracji() { czas_regeneracji += 1; }
    public void zabierzJedzenie() { czy_pełne = false; }
}
