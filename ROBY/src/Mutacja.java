package zad1;

import java.util.ArrayList;
import java.util.Random;

/*
To jest klasa odpowiadająca za mutacje programu Robów.
Przechowuje parametry określające przebieg mutacji.
 */
public class Mutacja {
    private double pr_dodania_instr;
    private double pr_usunięcia_instr;
    private double pr_zmiany_instr;
    private String dostępne_instr;

    public Mutacja(double pr_dodania_instr, double pr_usunięcia_instr,
                   double pr_zmiany_instr, String dostępne_instr) {

        this.pr_dodania_instr = pr_dodania_instr;
        this.pr_usunięcia_instr = pr_usunięcia_instr;
        this.pr_zmiany_instr = pr_zmiany_instr;
        this.dostępne_instr = dostępne_instr;
    }

    public String mutujKodProgramu(String kod_programu) {
        //dla wygody operowania tworzymy ArrayListę przechowującą kod programu
        ArrayList<Character> nowy_program = new ArrayList<>();
        for(int i = 0; i < kod_programu.length(); i++) {
            nowy_program.add(kod_programu.charAt(i));
        }

        Random rand = new Random();

        boolean czy_usuwać = rand.nextDouble() <= pr_usunięcia_instr;
        boolean czy_dodawać = rand.nextDouble() <= pr_dodania_instr;
        boolean czy_zmieniać = rand.nextDouble() <= pr_zmiany_instr;

        if(czy_usuwać)
            if(nowy_program.size() > 0)
                nowy_program.remove(nowy_program.size() - 1);

        if(czy_dodawać) {
            int index_nowej_instr = rand.nextInt(dostępne_instr.length());
            Character nowa_instr = dostępne_instr.charAt(index_nowej_instr);
            nowy_program.add(nowa_instr);
        }

        if(czy_zmieniać) { //interesuje nas którą instrukcję zmieniamy i co wstawiamy w jej miejsce
            if(nowy_program.size() > 0) {
                int index_zmiany = rand.nextInt(nowy_program.size());
                int index_nowej_instr = rand.nextInt(dostępne_instr.length());
                Character nowa_instr = dostępne_instr.charAt(index_nowej_instr);
                nowy_program.set(index_zmiany, nowa_instr);
            }
        }

        String nowy_kod_programu = new String();
        for(int i = 0; i < nowy_program.size(); i++) { nowy_kod_programu += nowy_program.get(i); }

        return nowy_kod_programu;
    }
}
