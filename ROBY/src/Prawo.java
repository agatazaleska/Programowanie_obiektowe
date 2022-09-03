package zad1;

//To jest klasa odpowiadająca za instrukcję "prawo".
public class Prawo extends Instrukcja{

    public void wykonaj(Rob rob) {
        switch (rob.getKierunek()) {
            case 'g':
                rob.setKierunek('p');
                break;
            case 'l':
                rob.setKierunek('g');
                break;
            case 'd':
                rob.setKierunek('l');
            case 'p':
                rob.setKierunek('d');
        }
    }

    public Character charSymbol() { return 'p'; }
}
