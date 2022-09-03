package zad1;

//To jest klasa odpowiadająca za instrukcję "lewo".
public class Lewo extends Instrukcja {

    public void wykonaj(Rob rob) {
        switch (rob.getKierunek()) {
            case 'g':
                rob.setKierunek('l');
                break;
            case 'l':
                rob.setKierunek('d');
                break;
            case 'd':
                rob.setKierunek('p');
            case 'p':
                rob.setKierunek('g');
        }
    }

    public Character charSymbol() { return 'l'; }
}
