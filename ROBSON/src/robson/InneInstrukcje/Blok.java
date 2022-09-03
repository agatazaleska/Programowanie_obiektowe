package robson.InneInstrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import robson.Instrukcja;

import java.util.ArrayList;
import java.util.List;


//Klasa odpowiadjąca za instrukcję Blok. Przechowuje tablice instrukcji.
public class Blok extends Instrukcja {
    @JsonProperty("instrukcje")
    private List<Instrukcja> instrukcje;

    @JsonCreator
    public Blok(@JsonProperty("instrukcje") List<Instrukcja> instrukcje) {
        this.instrukcje = new ArrayList<>();
        for(int i = 0; i < instrukcje.size(); i++) {
            this.instrukcje.add(instrukcje.get(i));
        }
    }

    public Blok() { }

    //wykonujenmy po kolei instrukcje z listy oraz zwracamy wynik ostatniej
    public double wykonaj() {
        if(zmienne == null) System.out.println("nul");
        int i = 0;
        while(i < instrukcje.size() - 1) {
            instrukcje.get(i).setZmienne(zmienne);
            instrukcje.get(i).wykonaj();
            i++;
        }
        instrukcje.get(i).setZmienne(zmienne);
        return instrukcje.get(i).wykonaj();
    }

    //zamieniamy na kod w javie wszystkie instrukcje w bloku
    public String toJava() {
        StringBuilder s = new StringBuilder("");
        for(int i = 0; i < instrukcje.size(); i++) {
            instrukcje.get(i).setUżyte_zmienne(użyte_zmienne);

            if(instrukcje.get(i).czyWyrażenie()) s.append("return ");
            s.append(instrukcje.get(i).toJava());
            if(!instrukcje.get(i).czyIfLubWhile()) s.append(";");
            s.append("\n");
        }
        return s.toString();
    }

    public List<Instrukcja> getInstrukcje() {
        return instrukcje;
    }

    public void setInstrukcje(List<Instrukcja> instrukcje) {
        this.instrukcje = instrukcje;
    }

    public boolean czyWyrażenie() {
        return false;
    }

    public boolean czyIfLubWhile() {
        return false;
    }
}
