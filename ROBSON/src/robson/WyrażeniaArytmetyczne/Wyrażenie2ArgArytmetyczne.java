package robson.WyrażeniaArytmetyczne;

import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa abstrakcyjna odpowiadająca za wyrażenia arytmetyczne dwuargumentowe
public abstract class Wyrażenie2ArgArytmetyczne extends WyrażenieArytmetyczne {
    @JsonProperty("argument1")
    protected WyrażenieArytmetyczne argument1;
    @JsonProperty("argument2")
    protected WyrażenieArytmetyczne argument2;

    public Wyrażenie2ArgArytmetyczne(WyrażenieArytmetyczne arg1,
                                     WyrażenieArytmetyczne arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    public String toJava() {
        argument1.setUżyte_zmienne(użyte_zmienne);
        argument2.setUżyte_zmienne(użyte_zmienne);

        return argument1.toJava() + " " + this.toString() + " " + argument2.toJava();
    }
}