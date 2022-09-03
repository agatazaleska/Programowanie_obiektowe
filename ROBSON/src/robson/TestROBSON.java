package robson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Klasa testująca działanie programu (wczytanie kodu ROBSON i wykonanie)
 * na przykładzie algorytmu Euklidesa.
 */
public class TestROBSON {
    private static Instrukcja ins;

    public static void Test(String robson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ins = null;
        ins = mapper.readValue(robson, Instrukcja.class);

        HashMap<String, Double> zmienne = new HashMap<>();
        ins.setZmienne(zmienne);

        if(ins.wykonaj() == 16.0) {
            System.out.println("Test zakończony sukcesem");
        }
        else System.out.println("Test zakończony porażką");
    }

    public static void main(String[] args) throws IOException {
        String euklides = "{\"typ\":\"Blok\",\"instrukcje\":[" + "{\"typ\":\"Przypisanie\",\"nazwa\":\"a\",\"wartosc\":{" +
                "\"typ\":\"Liczba\",\"wartosc\":48.0}}," +
                "{\"typ\":\"Przypisanie\",\"nazwa\":\"b\",\"wartosc\":{" +
                "\"typ\":\"Liczba\",\"wartosc\":32.0}}," +
                "{\"typ\":\"While\"," +
                "\"warunek\":{\"typ\":\"Not\",\"argument\":{\"typ\":\"==\",\"argument1\":{\"typ\":" +
                "\"Zmienna\",\"nazwa\":\"a\"},\"argument2\":{\"typ\":\"Zmienna\",\"nazwa\":\"b\"}}}," +
                "\"blok\":{\"typ\":\"Blok\",\"instrukcje\":[" +
                "{\"typ\":\"If\",\"warunek\":{\"typ\":\"<\",\"argument1\":{\"typ\":" +
                "\"Zmienna\",\"nazwa\":\"a\"},\"argument2\":{\"typ\":\"Zmienna\",\"nazwa\":\"b\"}}," +
                "\"blok_prawda\":{\"typ\":\"Blok\",\"instrukcje\":[" +
                "{\"typ\":\"Przypisanie\",\"nazwa\":\"b\",\"wartosc\":{\"typ\":\"Minus\",\"argument1\":{" +
                "\"typ\":\"Zmienna\",\"nazwa\":\"b\"},\"argument2\":{\"typ\":\"Zmienna\",\"nazwa\":\"a\"}}}]}," +
                "\"blok_falsz\":{\"typ\":\"Blok\",\"instrukcje\":[" +
                "{\"typ\":\"Przypisanie\",\"nazwa\":\"a\",\"wartosc\":{\"typ\":\"Minus\",\"argument1\":{" +
                "\"typ\":\"Zmienna\",\"nazwa\":\"a\"},\"argument2\":{\"typ\":\"Zmienna\",\"nazwa\":\"b\"}}}]}}]}}," +
                "{\"typ\":\"Zmienna\",\"nazwa\":\"a\"}]}";
        Test(euklides);
    }
}
