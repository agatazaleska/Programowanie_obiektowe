package robson.WyrażeniaArytmetyczne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa odpowiadająca za instrukcje minus
//Jako argumenty podajemy wyrażenia arytmetyczne
public class Minus extends Wyrażenie2ArgArytmetyczne {
    @JsonCreator
    public Minus(@JsonProperty("argument1") WyrażenieArytmetyczne arg1,
                 @JsonProperty("argument2") WyrażenieArytmetyczne arg2) {
        super(arg1, arg2);
    }

    @Override
    public double wykonaj() {
        argument1.setZmienne(zmienne);
        argument2.setZmienne(zmienne);
        return argument1.wykonaj() - argument2.wykonaj();
    }

    public String toString() {
        return "-";
    }
}
