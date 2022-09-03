package robson.Porównania;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import robson.WyrażeniaArytmetyczne.WyrażenieArytmetyczne;

//Klasa odpowiadające za porównanie "<". Jako argumenty przyjmuje wyrażenia arytmetyczne

@JsonTypeName("<")
public class Mniejsze extends Porównanie {
    @JsonCreator
    public Mniejsze(@JsonProperty("argument1") WyrażenieArytmetyczne arg1,
                    @JsonProperty("argument2") WyrażenieArytmetyczne arg2) {
        super(arg1, arg2);
    }

    @Override
    public double wykonaj() {
        argument1.setZmienne(zmienne);
        argument2.setZmienne(zmienne);
        if(argument1.wykonaj() < argument2.wykonaj()) return 1;
        else return 0;
    }

    public String toString() {
        return "<";
    }
}
