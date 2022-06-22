package excercises.chapter8;

import static excercises.chapter8.AutoSitz.SeatColor.*;

public class AutoSitzManufaktur {

    public static void main(String[] args) {
        try {
            AutoSitz validSeat1 = new AutoSitz(false, RED);
            System.out.println("Erste Sitz gebaut.");
            AutoSitz validSeat2 = new AutoSitz(true, BLACK);
            System.out.println("Zweite Sitz gebaut.");
            AutoSitz validSeat3 = new AutoSitz(true, BLUE);
            System.out.println("Dritte Sitz gebaut.");
            AutoSitz validSeat4 = new AutoSitz(false, RED);
            System.out.println("Vierte Sitz gebaut.");
        } catch(FalscheParameter e){
            System.out.println(e.getMessage());
            System.out.println("Das hat doch alles keinen Sinn mehr!");
            return;
        } finally {
            System.out.println("Sitzproduktion beendet - Maschinen werden ausgeschaltet!");
        }

        System.out.println("Die Sitze sind fertig gebaut!");
    }
}
