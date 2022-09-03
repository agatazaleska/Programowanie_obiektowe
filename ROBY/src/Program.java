package zad1;

import java.util.ArrayList;

/*
To jest klasa odpowiadająca za program Roba.
Przechowuje listę instrukcji, które tworzą program oraz kod programu w postaci napisu.
 */
public class Program {
    private ArrayList<Instrukcja> instrukcje;
    private String kod_programu;

    //program jest tworzony na podstawie jego kodu
    public Program(String kod_programu) {
        this.kod_programu = kod_programu;
        instrukcje = new ArrayList<>();
        for (int i = 0; i < kod_programu.length(); i++) {
            switch(kod_programu.charAt(i)) {
                case 'p':
                    instrukcje.add(new Prawo());
                    break;
                case 'l':
                    instrukcje.add(new Lewo());
                    break;
                case 'i':
                    instrukcje.add(new Idź());
                    break;
                case 'w':
                    instrukcje.add(new Wąchaj());
                    break;
                case 'j':
                    instrukcje.add(new Jedz());
                    break;
            }
        }
    }

    public ArrayList<Instrukcja> getInstrukcje() { return instrukcje; }
    public String getKod_programu() { return kod_programu; }
}
