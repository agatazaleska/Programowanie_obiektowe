package robson.WyrażeniaArytmetyczne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa odpowiadająca za obiekt typu Zmienna - przechowuje swoją nazwę - String
public class Zmienna extends WyrażenieArytmetyczne {
    @JsonProperty("nazwa")
    private String nazwa;

    @JsonCreator
    public Zmienna(@JsonProperty("nazwa") String nazwa) {
        this.nazwa = nazwa;
    }

    public double wykonaj() {
        return zmienne.get(nazwa);
    }

    public String toJava() {
        if (!użyte_zmienne.contains(nazwa)) użyte_zmienne.add(nazwa);
        return nazwa;
    }
}
