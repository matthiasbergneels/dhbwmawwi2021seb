package excercises.chapter8;

public class AutoSitz {

    private boolean ledersitz;
    private SeatColor farbe;

    public enum SeatColor{
        WHITE, BLACK, BLUE, RED, GREEN, YELLOW;

        public String toString(){
            switch(this){
                case WHITE:
                    return "Weiss";
                case BLACK:
                    return "Schwarz";
                case BLUE:
                    return "Blau";
                case RED:
                    return "Rot";
                case GREEN:
                    return "Grün";
                case YELLOW:
                    return "Gelb";
                default:
                    return "Nicht definiert";
            }
        }
    }

    public AutoSitz(boolean ledersitz, SeatColor farbe) throws FalscheParameter {


        if (ledersitz && !(farbe == SeatColor.WHITE || farbe == SeatColor.BLACK)) {
            throw new FalscheParameter(ledersitz, farbe);
        }


        this.setFarbe(farbe);
        this.setLedersitz(ledersitz);
    }

    public boolean isLedersitz() {
        return ledersitz;
    }

    private void setLedersitz(boolean ledersitz) {
        this.ledersitz = ledersitz;
    }

    public SeatColor getFarbe() {
        return farbe;
    }

    private void setFarbe(SeatColor farbe) {
        this.farbe = farbe;
    }
}