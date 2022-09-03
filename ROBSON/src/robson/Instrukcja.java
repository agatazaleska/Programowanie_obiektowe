package robson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import robson.InneInstrukcje.Blok;
import robson.InneInstrukcje.If;
import robson.InneInstrukcje.Przypisanie;
import robson.InneInstrukcje.While;
import robson.Porównania.*;
import robson.WyrażeniaArytmetyczne.*;
import robson.WyrażeniaLogiczne.*;

import java.util.ArrayList;
import java.util.HashMap;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
              include = JsonTypeInfo.As.PROPERTY,
              property = "typ")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Blok.class),
        @JsonSubTypes.Type(value = If.class),
        @JsonSubTypes.Type(value = While.class),
        @JsonSubTypes.Type(value = Przypisanie.class),
        @JsonSubTypes.Type(value = Zmienna.class),
        @JsonSubTypes.Type(value = False.class),
        @JsonSubTypes.Type(value = True.class),
        @JsonSubTypes.Type(value = And.class),
        @JsonSubTypes.Type(value = Or.class),
        @JsonSubTypes.Type(value = Not.class),
        @JsonSubTypes.Type(value = Liczba.class),
        @JsonSubTypes.Type(value = Plus.class),
        @JsonSubTypes.Type(value = Dzielenie.class),
        @JsonSubTypes.Type(value = Minus.class),
        @JsonSubTypes.Type(value = Razy.class),
        @JsonSubTypes.Type(value = Mniejsze.class, name = "<"),
        @JsonSubTypes.Type(value = MniejszeRówne.class, name = "<="),
        @JsonSubTypes.Type(value = Większe.class, name = ">"),
        @JsonSubTypes.Type(value = WiększeRówne.class, name = ">="),
        @JsonSubTypes.Type(value = Równe.class, name = "=="),
})

/*
* Klasa obsługująca instrukcję.
* Przechowuje pomocniczą tablicę i mapę. Udostępnia metody: toJava() oraz wykonaj()
*/
public abstract class Instrukcja {
    @JsonIgnore
    protected HashMap<String, Double> zmienne;
    @JsonIgnore
    protected ArrayList<String> użyte_zmienne;

    public abstract double wykonaj();
    public abstract String toJava();

    public void setZmienne(HashMap<String, Double> zmienne) {
        this.zmienne = zmienne;
    }
    public void setUżyte_zmienne(ArrayList<String> zmienne) { this.użyte_zmienne = zmienne; }

    public ArrayList<String> getUżyte_zmienne() { return użyte_zmienne; }

    public HashMap<String, Double> getZmienne() {
        return zmienne;
    }

    public abstract boolean czyWyrażenie();

    public abstract boolean czyIfLubWhile();
}
