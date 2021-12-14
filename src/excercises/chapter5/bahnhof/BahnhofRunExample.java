package excercises.chapter5.bahnhof;


import excercises.chapter6.Kiste;
import excercises.chapter6.Tonne;

import java.sql.Date;


public class BahnhofRunExample {

    public static void main(String[] args) {

        // narrowing Cast
        Fracht[] ladung = {	new Fracht("Zeug", 1007.0, "Pappe"),
                new Fracht("Mehr Zeug", 678.0, "Plastik"),
                new Fracht("Flüssiges Zeug", 500.0, "Fass"),
                new Tonne("noch mehr flüssiges Zeug", 678.0, 100, 45),
                new Kiste("Magazine", 600, 50, 60, 32)};

        Gueterwagon meinWagon = new Gueterwagon(1678, "Kastenwagon", (byte)6);

        meinWagon.setFracht(ladung);

        Zuglokomotive meineLok = new Zuglokomotive(1987, "Spezielle Lok", "Solar", (byte)10);

        Gueterwagon[] wagons = {meinWagon};
        Gueterzug meinZug = new Gueterzug(meineLok, wagons, 19892, 1);

        Gueterzug nochEinZug = new Gueterzug(1892, 3);


        meinZug.setFahrer(new Zugfuehrer("Müller", "Klaus", 18982, Date.valueOf("1990-12-24")));

        nochEinZug.fahren();
        meinZug.fahren();


        for(Fracht aktuelleFracht: ladung){
            // Nutzen der Polymorphy --> weil ich nicht weiß ob es eine Fracht, eine Tonne oder eine Kiste ist
            // aber die spezifische Methode ausgeführt wird.
            System.out.println("Aktuelles Volumen: " + aktuelleFracht.getVolumen());
        }


        // Finde die Polymorphy ;-)
        System.out.println("Gesamt Fracht-Volumen des Güterzuges: " + meinZug.getGesamtFrachtVolumen() + " m^3");

        System.out.println("Informationen über meinZug:");
        System.out.println("Gueterzug: " + meinZug);
        System.out.println("Fahrer: " + meinZug.getFahrer());
        System.out.println("Lokomotive: " + meinZug.getLok());

    }
}

