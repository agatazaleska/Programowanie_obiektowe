package robson.WyrażeniaLogiczne;

import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa abstrakcyjna obsługująca wyrażenie logiczne dwuargumentowe
public abstract class Wyrażenie2ArgLogiczne extends WyrażenieLogiczne {
    @JsonProperty("argument1")
    protected WyrażenieLogiczne argument1;
    @JsonProperty("argument2")
    protected WyrażenieLogiczne argument2;

    public Wyrażenie2ArgLogiczne(WyrażenieLogiczne arg1,
                                 WyrażenieLogiczne arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    public String toJava() {
        argument1.setUżyte_zmienne(użyte_zmienne);
        argument2.setUżyte_zmienne(użyte_zmienne);

        return argument1.toJava() + this.toString() + argument2.toJava();
    }
}
