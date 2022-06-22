package excercises.chapter9;

public class TestKundeVergleich {

    public static void main(String[] args) {

        Kunde ersterKunde = new Kunde("Müller", "Klaus", 4711);
        Kunde zweiterKunde = new Kunde("Mayer", "Gabi", 9811);
        Kunde dritterkunde = new Kunde("Heinrich", "Helmut", 4711);


        System.out.println("Erster Kunde: \t" + ersterKunde);
        System.out.println("Zweiter Kunde: \t" + zweiterKunde);
        System.out.println("Dritter Kunde: \t" + dritterkunde);


        System.out.println("Erster Kunde hashCode(): \t" + ersterKunde.hashCode());
        System.out.println("Zweiter Kunde hashCode(): \t" + zweiterKunde.hashCode());
        System.out.println("Dritter Kunde hashCode(): \t" + dritterkunde.hashCode());


        System.out.println("Vergleich erster und zweiter Kunde: " + ersterKunde.equals(zweiterKunde));
        System.out.println("Vergleich erster und dritter Kunde: " + ersterKunde.equals(dritterkunde));
    }

}

