package zad1;

//To jest klasa reprezentująca pole puste.
public class PolePuste extends Pole{

    public PolePuste(int koord_y, int koord_x) {
        this.koord_x = koord_x;
        this.koord_y = koord_y;
        żywieniowe = false;
        czas_regeneracji = 0;
    }

    public void regenerujJedzenie() { }
    public void zabierzJedzenie() { }
    public void zwiekszCzasRegeneracji() { }

    public boolean czyPełne() {
        return false;
    }
}
