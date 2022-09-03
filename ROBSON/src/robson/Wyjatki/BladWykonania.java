package robson.Wyjatki;

//Wyjątek BladWykonania - rzucany podczas napotkania problemu podczas wykonywania programu
public class BladWykonania extends Exception {
    public BladWykonania(String errorMessage) {
        super(errorMessage);
    }
}
