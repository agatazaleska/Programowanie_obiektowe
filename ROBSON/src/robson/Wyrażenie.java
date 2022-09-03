package robson;

//Klasa abstrakcyjna obsługująca wyrażenie (zarówno logiczne jak i arytmetczne)
public abstract class Wyrażenie extends Instrukcja{
    public boolean czyWyrażenie() {
        return true;
    }

    public boolean czyIfLubWhile() {
        return false;
    }
}
