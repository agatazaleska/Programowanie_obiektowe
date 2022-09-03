package robson.WyrażeniaLogiczne;

import com.fasterxml.jackson.annotation.JsonCreator;

//Klasa przechowująca instruckję - wartość logiczną false
public class True extends WyrażenieLogiczne {
    @JsonCreator
    public True() { }

    public double wykonaj() {
        return 1;
    }

    public String toJava() {
        return "true";
    }
}
