package robson.Wyjatki;

//Wyjątek NieprawidlowyProgram - rzucany podczas napotkanie nieprawidłowego składniowo programu
public class NieprawidlowyProgram extends Exception {
    public NieprawidlowyProgram(String errorMessage) {
        super(errorMessage);
    }
}
