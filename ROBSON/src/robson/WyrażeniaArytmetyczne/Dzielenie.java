package robson.WyrażeniaArytmetyczne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import robson.Wyjatki.BladWykonania;

//Klasa odpowiadająca za instrukcje dzielenia
//Jako argumenty podajemy wyrażenia arytmetyczne
public class Dzielenie extends Wyrażenie2ArgArytmetyczne {
    @JsonCreator
    public Dzielenie(@JsonProperty("argument1") WyrażenieArytmetyczne arg1,
                     @JsonProperty("argument2") WyrażenieArytmetyczne arg2) {
        super(arg1, arg2);
    }

    //Rzucamy wyjątek w razie dzielenia przez 0
    @Override
    public double wykonaj() {
        try {
            if(argument2.wykonaj() == 0) throw new BladWykonania("Dzielenie przez 0");
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }

        argument1.setZmienne(zmienne);
        argument2.setZmienne(zmienne);
        return argument1.wykonaj() / argument2.wykonaj();
    }

    public String toString() {
        return "/";
    }
}
