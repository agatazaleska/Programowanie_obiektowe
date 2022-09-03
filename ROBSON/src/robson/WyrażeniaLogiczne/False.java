package robson.WyrażeniaLogiczne;

import com.fasterxml.jackson.annotation.JsonCreator;

//Klasa przechowująca instruckję - wartość logiczną false
public class False extends WyrażenieLogiczne {
    @JsonCreator
    public False() { }

    public double wykonaj() {
        return 0;
    }

    public String toJava() { return "false"; }
}
