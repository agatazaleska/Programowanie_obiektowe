package robson.WyrażeniaLogiczne;

import com.fasterxml.jackson.annotation.JsonProperty;

//Klasa abstrakcyjna obsługująca wyrażenie logiczne jednoargumentowe
public abstract class Wyrażanie1ArgLogiczne extends WyrażenieLogiczne {
    @JsonProperty("argument")
    protected WyrażenieLogiczne argument;

    public Wyrażanie1ArgLogiczne(WyrażenieLogiczne argument) {
        this.argument = argument;
    }

    public String toJava() {
        argument.setUżyte_zmienne(użyte_zmienne);
        return this.toString() + " " + argument.toJava();
    }
}
