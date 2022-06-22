package excercises.chapter9;

import java.util.*;

public class TestKunde {

    public static void main(String[] args) {

        // Initialisierung der Kunden
        Kunde[] initialeKunden = {
                new Kunde("Mustermann", "Klaus", 4711),
                new Kunde("Beispiel", "Hans", 5180),
                new Kunde("Mustermann", "Hilde", 4712),
                new Kunde("Vorbild", "Theodor", 8278),
                new Kunde("Dummy", "Jimmy", 1111),
                new Kunde("UMBENNEN", "Klaus", 4711),
        };

        // Aufgabe 1

        // Kundenverzeichnis als Menge (Set) anlegen
        Set<Kunde> kundenVerzeichnis = new TreeSet<Kunde>();

        // Initial angelegte Kunden in neues Kundenverzeichnis (Menge) übertragen
        kundenVerzeichnis.addAll(Arrays.asList(initialeKunden));


        // Kundenverzeichnis über Iterator auslesen
        System.out.println("Ausgabe der Sortierten Kundenmenge:");
        Iterator<Kunde> kundenIterator = kundenVerzeichnis.iterator();

        while(kundenIterator.hasNext()){
            System.out.println(kundenIterator.next());
        }


        // Aufgabe 2

        // Kundenverzeichnis als Liste (List) anlegen
        List<Kunde> kundenVerzeichnisNachName = new Vector<Kunde>();

        // Initial angelegte Kunden in neues Kundenverzeichnis (Liste) übertragen
        kundenVerzeichnis.addAll(Arrays.asList(initialeKunden));

        // Sortieren der Liste nach spezifischer Sportiervorschrift
        Collections.sort(kundenVerzeichnisNachName, new KundenSortiererNachNameVornameKundennummer());;

        // Kundenverzeichnis über Iterator auslesen
        System.out.println("Ausgabe der Sortierten Kundenliste:");
        kundenIterator = kundenVerzeichnisNachName.iterator();

        while(kundenIterator.hasNext()){
            System.out.println(kundenIterator.next());
        }
    }
}
