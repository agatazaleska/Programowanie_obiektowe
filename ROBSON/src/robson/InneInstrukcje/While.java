package robson.InneInstrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import robson.Instrukcja;
import robson.WyrażeniaLogiczne.WyrażenieLogiczne;

/*
Klasa odpowiadjąca za instrukcję Blok
Przechowuje warunek - wyrażenie logiczne oraz blok instrukcji
*/
public class While extends Instrukcja {
    @JsonProperty("warunek")
    private WyrażenieLogiczne warunek;
    @JsonProperty("blok")
    private Blok blok;

    @JsonCreator
    public While( @JsonProperty("warunek") WyrażenieLogiczne warunek,
                  @JsonProperty("blok") Blok blok) {
        this.blok = blok;
        this.warunek = warunek;
    }

    //wykonujemy instrukcje z bloku dopóki warunek jest prawdziwy
    public double wykonaj() {
        blok.setZmienne(zmienne);
        warunek.setZmienne(zmienne);

        while(warunek.wykonaj() == 1) {
            blok.wykonaj();
        }
        return 0;
    }

    public String toJava() {
        warunek.setUżyte_zmienne(użyte_zmienne);
        blok.setUżyte_zmienne(użyte_zmienne);

        return "while(" + warunek.toJava() + ") {\n" + blok.toJava() + "}";
    }

    public boolean czyWyrażenie() {
        return false;
    }

    public boolean czyIfLubWhile() {
        return true;
    }
}
