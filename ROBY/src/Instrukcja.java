package zad1;

//To jest klasa odpowiadająca za instrukcje wykonywane przez Roby.
public abstract class Instrukcja {
    public abstract void wykonaj(Rob rob);
    public abstract Character charSymbol();
}
