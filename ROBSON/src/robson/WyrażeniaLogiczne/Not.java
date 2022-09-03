package robson.WyrażeniaLogiczne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa obsługująca instrukcję Not
public class Not extends Wyrażanie1ArgLogiczne {
    @JsonCreator
    public Not(@JsonProperty("argument1") WyrażenieLogiczne argument) {
        super(argument);
    }

    @Override
    public double wykonaj() {
        argument.setZmienne(zmienne);
        if(argument.wykonaj() == 0) return 1;
        else return 0;
    }

    public String toString() {
        return "!";
    }
}
