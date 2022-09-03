package zad1;
import java.util.Map;

//To jest klasa odpowiadająca za instrukcję "wąchaj".
public class Wąchaj extends Instrukcja {

    public void wykonaj(Rob rob) {
        Map<Character, Pole> sąsiedzi = rob.getLokalizacja().getBliscy_sąsiedzi();
        if(sąsiedzi.get('g').czyPełne()) rob.setKierunek('g');
        else if(sąsiedzi.get('p').czyPełne()) rob.setKierunek('p');
        else if(sąsiedzi.get('l').czyPełne()) rob.setKierunek('l');
        else if(sąsiedzi.get('d').czyPełne()) rob.setKierunek('d');
    }

    public Character charSymbol() { return 'w'; }
}
