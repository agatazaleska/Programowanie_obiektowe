package robson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import robson.Wyjatki.BladWykonania;
import robson.Wyjatki.NieprawidlowyProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Główna klasa projektu
 * udostępnia następujące metody:
 * wykonaj - wykonuje program w języku robson
 * tojava - konwertuje program w języku robson na program w javie
 * fromJSON - wczytuje program z pliku JSON
 * toJSON - zapisuje program do pliku JSON
 */

/*
* Do uruchomienia programu potrzebna jest biblioteka com.fasterxml.jackson dostępna w repozytorium Maven,
* A także wybranie biblioteki wbudowane javy.
* Aby wykonać program w języku robson należy w funkcji Main wywołać najpierw metodę fromJSON jako argument podając
* ścieżkę prowadzącą do wejściowego pliku, oraz następnie metodę wykonaj.
* Kolejno należy skompilować plik Robson.java oraz odpalić powstały plik wykonywalny.
*/

public class Robson {
    private static Instrukcja ins;

    //metoda wczytująca program w formacie JSON z pliku o ścieżce podanej w argumencie
    public static void fromJSON(String filename) throws NieprawidlowyProgram {
        ObjectMapper mapper = new ObjectMapper();
        ins = null;
        try {
            File input = new File(filename);
            ins = mapper.readValue(input, Instrukcja.class);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metoda konwertująca obiekt typu instrukcja do formatu JSON do pliku o ścieżce podanej w argumencie
    public static void toJSON(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File(filename), ins);
    }

    //metoda konwertująca program w języku JSON do programu w javie
    public static void toJava(String filename) throws IOException {
        //tablica pomocnicza tworząca listę zmiennych, z których korzysta program
        ArrayList<String> użyte_zmienne = new ArrayList<>();
        ins.setUżyte_zmienne(użyte_zmienne);

        int dot_index = filename.indexOf(".");
        String class_name = null;
        if (dot_index != -1) {
            class_name = filename.substring(0 , dot_index);
        }

        FileWriter file = new FileWriter(filename);
        String program = ins.toJava();
        StringBuilder zmienne = new StringBuilder();
        for(int i = 0; i < ins.getUżyte_zmienne().size(); i++) {
            zmienne.append("double " + użyte_zmienne.get(i) + " = 0;\n");
        }
        file.write("public class " + class_name + "{\n" +
                        "public static double wykonaj(){\n" + zmienne.toString() + program +"}\n" +
                        "public static void main(String[] args){\n" + "double wynik = wykonaj(); " +"System.out.println(wynik);" +"}\n"+"}");
        file.close();
    }

    public static double wykonaj() throws BladWykonania {
        //tworzymy mapę zmiennych (klucze - nazwy zmiennych, wartości - wartości zmiennych)
        //mapa ułatwia dostęp do zmiennych podczas wykonywania progamu
        HashMap<String, Double> zmienne = new HashMap<>();
        ins.setZmienne(zmienne);
        return ins.wykonaj();
    }

    public static void main(String[] args) throws IOException, NieprawidlowyProgram, BladWykonania {
        fromJSON("szybkie_potegowanie.txt");
        wykonaj();
    }
}