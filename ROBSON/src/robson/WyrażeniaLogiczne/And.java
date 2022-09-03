package robson.WyrażeniaLogiczne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa obsługująca instrukcję And
public class And extends Wyrażenie2ArgLogiczne {
    @JsonCreator
    public And(@JsonProperty("argument1") WyrażenieLogiczne arg1, @JsonProperty("argument2") WyrażenieLogiczne arg2) {
        super(arg1, arg2);
    }

    @Override
    public double wykonaj() {
        argument1.setZmienne(zmienne);
        argument2.setZmienne(zmienne);
        if(argument1.wykonaj() == 1 && argument2.wykonaj() == 1) return 1;
        else return 0;
    }

    public String toString() {
        return "&&";
    }
}

