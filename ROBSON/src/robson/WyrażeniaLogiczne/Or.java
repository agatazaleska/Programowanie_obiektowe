package robson.WyrażeniaLogiczne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa obsługująca instrukcję Or
public class Or extends Wyrażenie2ArgLogiczne {
    @JsonCreator
    public Or(@JsonProperty("argument1") WyrażenieLogiczne arg1,
              @JsonProperty("argument2") WyrażenieLogiczne arg2) {
        super(arg1, arg2);
    }

    @Override
    public double wykonaj() {
        argument1.setZmienne(zmienne);
        argument2.setZmienne(zmienne);
        if(argument1.wykonaj() == 1 || argument2.wykonaj() == 1) return 1;
        else return 1;
    }

    public String toString() {
        return "||";
    }
}
