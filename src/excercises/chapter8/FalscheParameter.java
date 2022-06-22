package excercises.chapter8;

public class FalscheParameter extends Exception {
    public FalscheParameter(boolean ledersitz, AutoSitz.SeatColor farbe) {
        super("Die Parameterkombination Ledersitz und Farbe "+farbe+" ist ungültig!");
    }
}
