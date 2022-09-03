package robson.InneInstrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import robson.Instrukcja;
import robson.WyrażeniaLogiczne.WyrażenieLogiczne;

/*
Klasa odpowiadjąca za instrukcję If.
Przechowuje warunek - wyrażenie logiczne,
bloki falsz i prawda - wykonujace sie w zależności od warunku
*/
public class If extends Instrukcja {
    @JsonProperty("warunek")
    private WyrażenieLogiczne warunek;
    @JsonProperty("blok_prawda")
    private Blok blok_prawda;
    @JsonProperty("blok_falsz")
    private Blok blok_falsz;

    @JsonCreator
    public If(@JsonProperty("warunek") WyrażenieLogiczne warunek, @JsonProperty("blok_prawda") Blok blok_prawda,
              @JsonProperty("blok_falsz") Blok blok_falsz) {
        this.blok_prawda = blok_prawda;
        this.blok_falsz = blok_falsz;
        this.warunek = warunek;
    }

    //w zależności od wartości warunku wykonujemy dany blok
    public double wykonaj() {
        if(zmienne == null) System.out.println("nul");

        if(blok_falsz != null) blok_falsz.setZmienne(zmienne);
        blok_prawda.setZmienne(zmienne);
        warunek.setZmienne(zmienne);

        if (warunek.wykonaj() == 1) {
            return blok_prawda.wykonaj();
        }
        else if (blok_falsz != null) {
            return blok_falsz.wykonaj();
        }
        else return 0;
    }

    public String toJava() {
        warunek.setUżyte_zmienne(użyte_zmienne);
        blok_prawda.setUżyte_zmienne(użyte_zmienne);
        if(blok_falsz != null) blok_falsz.setUżyte_zmienne(użyte_zmienne);

        StringBuilder s = new StringBuilder();
        s.append("if(" + warunek.toJava() + ") {\n" + blok_prawda.toJava() + "}");

        if(blok_falsz != null) {
            s.append("\nelse{\n" + blok_falsz.toJava() + "}");
        }
        return s.toString();
    }

    public boolean czyWyrażenie() {
        return false;
    }

    public boolean czyIfLubWhile() {
        return true;
    }
}
