package robson.WyrażeniaArytmetyczne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa przechowująca obiekt typou Liczba - ma przypisaną wartość double
public class Liczba extends WyrażenieArytmetyczne {
    @JsonProperty("wartosc")
    private double wartosc;

    @JsonCreator
    public Liczba(@JsonProperty("wartosc") double wartość) {
        this.wartosc = wartość;
    }

    public double wykonaj() { return wartosc; }

    public String toJava() {
        return String.valueOf(wartosc);
    }
}
