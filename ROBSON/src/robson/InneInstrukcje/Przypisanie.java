package robson.InneInstrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import robson.Instrukcja;
import robson.WyrażeniaArytmetyczne.WyrażenieArytmetyczne;

/*
Klasa odpowiadjąca za instrukcję Przypisanie
Przechowuje nazwe zmiennej - String oraz wartosc - wryażenieArytmetyczne
*/
public class Przypisanie extends Instrukcja {
    @JsonProperty("nazwa")
    private String nazwa;
    @JsonProperty("wartosc")
    private WyrażenieArytmetyczne wartosc;

    @JsonCreator
    public Przypisanie(@JsonProperty("nazwa") String nazwa,
                       @JsonProperty("wartosc") WyrażenieArytmetyczne wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    @Override
    public double wykonaj() {
        wartosc.setZmienne(zmienne);
        Double w = wartosc.wykonaj();
        zmienne.put(nazwa, w);
        return w;
    }

    public String toJava() {
        wartosc.setUżyte_zmienne(użyte_zmienne);
        return nazwa + " = " + wartosc.toJava();
    }

    public boolean czyWyrażenie() {
        return false;
    }

    public boolean czyIfLubWhile() {
        return false;
    }
}
