package zad1;

import java.util.ArrayList;
import java.util.Collections;

/*
To jest klasa przechowująca podstawowe dane dotyczące robów żyjących na planszy.
Każda śmierć oraz powielenie roba jest tu rejestrowane.
 */
public class CentrumDanychORobach {
    private int max_wiek;
    private int min_wiek;
    private double śr_wiek;
    private int max_energia;
    private int min_energia;
    private double śr_energia;
    private int max_prg;
    private int min_prg;
    private double śr_prg;
    private ArrayList<Rob> żywe_roby;

    public CentrumDanychORobach(ArrayList<Rob> roby) { żywe_roby = roby; }

    //funkcja usuwająca z rejestru żywych robów osobniki, które nie przetrwały tury
    public void rejestrujZmarłeRoby() {
        ArrayList<Rob> nowe_roby = new ArrayList<>(); //podmieniamy dotychczasową listę na nową
        for(Rob rob : żywe_roby) {
            if(rob.żywy()) nowe_roby.add(rob);
        }
        żywe_roby = nowe_roby;
    }

    //funkcja dodająca do rejestru żywych robów nowe osobniki
    public void rejestrujNoweRoby(ArrayList<Rob> nowe_roby) {
        żywe_roby.addAll(nowe_roby);
        Collections.shuffle(żywe_roby);
    }

    //funkcja aktualizująca dane przechowywane przez Centrum Danych
    //na nowo liczy wartość każdego parametru
    public void aktualizujDane() {
        if(żywe_roby.size() == 0) {
            max_prg = 0;
            min_prg = 0;
            max_energia = 0;
            min_energia = 0;
            max_wiek = 0;
            min_wiek = 0;
            śr_energia = 0;
            śr_wiek = 0;
            śr_prg = 0;
        }
        else {
            ArrayList<Integer> energie_robów = new ArrayList<>();
            ArrayList<Integer> wieki_robów = new ArrayList<>();
            ArrayList<Integer> dł_prg_robów = new ArrayList<>();

            int suma_energia = 0;
            int suma_wiek = 0;
            int suma_dł_prg = 0;
            for(Rob rob : żywe_roby) {
                dł_prg_robów.add(rob.getProgram().getInstrukcje().size());
                suma_dł_prg += rob.getProgram().getInstrukcje().size();
                energie_robów.add(rob.getEnergia());
                suma_energia += rob.getEnergia();
                wieki_robów.add(rob.getWiek());
                suma_wiek += rob.getWiek();
            }
            max_prg = Collections.max(dł_prg_robów);
            min_prg = Collections.min(dł_prg_robów);
            max_energia = Collections.max(energie_robów);
            min_energia = Collections.min(energie_robów);
            max_wiek = Collections.max(wieki_robów);
            min_wiek = Collections.min(wieki_robów);
            śr_energia = ((double) suma_energia) / żywe_roby.size();
            śr_wiek = ((double) suma_wiek) / żywe_roby.size();
            śr_prg = ((double) suma_dł_prg) / żywe_roby.size();
        }
    }

    public int getMax_energia() { return max_energia; }
    public int getMin_energaia() { return min_energia; }
    public double getŚr_energaia() { return śr_energia; }

    public int getMax_wiek() { return max_wiek; }
    public int getMin_wiek() { return min_wiek; }
    public double getŚr_wiek() { return śr_wiek; }

    public int getMin_prg() { return min_prg; }
    public int getMax_prg() { return max_prg; }
    public double getŚr_prg() { return śr_prg; }

    public ArrayList<Rob> getŻyweRoby() { return żywe_roby; }
}
