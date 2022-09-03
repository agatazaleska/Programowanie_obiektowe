package zad1;

//To jest klasa odpowiadająca za instrukcję "idź".
public class Idź extends Instrukcja {

    public void wykonaj(Rob rob) {
        Pole lok = rob.getLokalizacja();
        switch (rob.getKierunek()) {
                case 'g':
                    rob.wejdźNaPole(lok.getBliscy_sąsiedzi().get('g'));
                    break;
                case 'l':
                    rob.wejdźNaPole(lok.getBliscy_sąsiedzi().get('l'));
                    break;
                case 'p':
                    rob.wejdźNaPole(lok.getBliscy_sąsiedzi().get('p'));
                    break;
                case 'd':
                    rob.wejdźNaPole(lok.getBliscy_sąsiedzi().get('d'));
                    break;
            }

            Pole nowa_lokalizacja = rob.getLokalizacja();
            if (nowa_lokalizacja.czyPełne())
                rob.zjedzJedzenie(nowa_lokalizacja);
    }

    public Character charSymbol() { return 'i'; }
}
