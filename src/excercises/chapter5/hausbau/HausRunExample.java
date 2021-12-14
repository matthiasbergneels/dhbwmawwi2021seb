package excercises.chapter5.hausbau;

public class HausRunExample {
        public static void main(String[] args) throws Exception {

            System.out.println("Anzahl Häuser: " + Haus.getObjCnt());

            /*
            // Haeuser bauen
            Haus[] haeuser = {	new Haus(5),
                    new Haus("Hauptstrasse", "167A", 89872, "Wumshausen"),
                    new Haus(3, 18, 3, 234, true),
                    Haus.baueHausMitFentserUndTueren(10, 2)};


             */
            Haus erstesHaus = new Haus(5);
            Haus zweitesHaus = new Haus("Hauptstrasse", "167A", 89872, "Wumshausen");
            Haus drittesHaus = new Haus(3, 18, 3, 234, true);
            Haus viertesHaus = Haus.baueHausMitFentserUndTueren(10, 2);

            Haus[] haeuser = new Haus[4];

            haeuser[0] = erstesHaus;
            haeuser[1] = zweitesHaus;
            haeuser[2] = drittesHaus;
            haeuser[3] = viertesHaus;

            erstesHaus = null;
            zweitesHaus = null;
            drittesHaus = null;
            viertesHaus = null;

            System.out.println("Anzahl Häuser: " + Haus.getObjCnt());


            for(Haus haus : haeuser){
              System.out.println(haus);
              /*
              System.out.println("Hausinformationen: Etagen: " + haus.getEtagen() +
                                                  "; Tueren: " + haus.getTueren() +
                                                  "; Fenster: " + haus.getFenster() +
                                                  "; Flaeche: "+ haus.getFlaeche() +
                                                  "; Flachdach: nein; Adresse: Coblitzallee 7, 69782 Mannheim");

               */
            }

            // Haeuser abreissen
            haeuser[0] = null;
            haeuser[2] = null;

            // Garbage Collector anfragen
            System.gc();
            // Auf GC warten
            try {
                Thread.sleep(1000);
            } catch(Exception e){
                System.out.println("Ausnahmebehandlung für Thread.sleep()");
            }

            System.out.println("Anzahl Häuser: " + Haus.getObjCnt());

        }
    }
