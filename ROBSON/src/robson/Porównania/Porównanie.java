package robson.Porównania;

import com.fasterxml.jackson.annotation.JsonProperty;
import robson.WyrażeniaArytmetyczne.WyrażenieArytmetyczne;
import robson.WyrażeniaLogiczne.WyrażenieLogiczne;

//Klasa abstrakcyjna odpowiadająca za obiekty typu porównanie
public abstract class Porównanie extends WyrażenieLogiczne {
    @JsonProperty("argument1")
    WyrażenieArytmetyczne argument1;
    @JsonProperty("argument2")
    WyrażenieArytmetyczne argument2;

    public Porównanie(WyrażenieArytmetyczne arg1, WyrażenieArytmetyczne arg2) {
        argument1 = arg1;
        argument2 = arg2;
    }

    public String toJava() {
        argument1.setUżyte_zmienne(użyte_zmienne);
        argument2.setUżyte_zmienne(użyte_zmienne);

        return argument1.toJava() + this.toString() + argument2.toJava();
    }
}
