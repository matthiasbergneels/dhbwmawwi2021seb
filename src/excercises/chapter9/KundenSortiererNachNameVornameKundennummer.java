package excercises.chapter9;

import java.util.Comparator;

public class KundenSortiererNachNameVornameKundennummer implements Comparator<Kunde> {

    @Override
    public int compare(Kunde o1, Kunde o2) {

        // Vergleiche und Sortiere nach Nachname
        if(!o1.getName().equals(o2.getName())){
            return o1.getName().compareTo(o2.getName());
        }

        // bei Gleichheit des Nachnamens
        // Vergleiche und Sortiere nach Vorname
        if(!o1.getVorname().equals(o2.getVorname())){
            return o1.getVorname().compareTo(o2.getVorname());
        }

        // bei Gleichheit des Vornamesn --> Kunden werden als identisch angesehen
        return 0;
    }


}
