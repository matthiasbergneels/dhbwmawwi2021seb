package excercises.chapter10.meldeamt;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ListenOperationen {

    private static final String EINWOHNER_DATEI_PFAD = System.getProperty("user.dir") + File.separator + "EinwohnerListe.dat";

    private static Set<Einwohner> liste = new TreeSet<Einwohner>();

    private static Einwohner ermittleObjekt(String name, String vorname){
        Einwohner e = null;

        Iterator<Einwohner> i = liste.iterator();
        while(i.hasNext()){
            e = i.next();
            if((name.equals(e.getName()) &&
                    vorname.equals(e.getVorname()))){
                return e;
            }
        }

        return null;
    }

    public static boolean hinzufuegen(String name, String vorname, String gebName, String email, Einwohner.Title anrede, String familienstand){
        Einwohner e = new Einwohner(name, vorname, gebName, email, anrede, familienstand);
        boolean erg = liste.add(e);
        return erg;
    }

    public static boolean anzeigen(String name, String vorname){

        Einwohner e = ermittleObjekt(name, vorname);

        if(e == null){
            return false;
        }else{
            System.out.println(e);
            return true;
        }
    }

    public static boolean suchen(String name, String vorname){

        Einwohner e = ermittleObjekt(name, vorname);

        if(e == null){
            return false;
        }else{
            return true;
        }
    }

    public static boolean loeschen(String name, String vorname){
        Einwohner e = ermittleObjekt(name, vorname);

        if(e == null){
            return false;
        }else{
            liste.remove(e);
            return true;
        }
    }

    public static void listeAusgeben(){
        if(liste.size() > 0){
            System.out.println("Einwohner:");

            for(Einwohner e : liste){
                System.out.println(e);
            }
        }else{
            System.out.println("Die Liste ist leer!");
        }
    }

    protected static void speichernEinwohnerListeInDatei(){

        File einwohnerListeDatei = new File(EINWOHNER_DATEI_PFAD);

        if(!einwohnerListeDatei.exists()){
            try{
                einwohnerListeDatei.createNewFile();
            }catch(IOException e){
                System.out.println("Datei: " + einwohnerListeDatei.getName() + " konnte nicht erstellt werden.");
                return;
            }
        }

        try(FileOutputStream einwohnerOutputDateiStream = new FileOutputStream(einwohnerListeDatei);
            ObjectOutputStream einwohnerOutputObjectStream = new ObjectOutputStream(einwohnerOutputDateiStream)){

            einwohnerOutputObjectStream.writeObject(liste);

        } catch(IOException e){
            System.out.println("Fehler beim schreiben der Einwohnerdaten.");
            return;
        }

        System.out.println(liste.size() + " Einwohner in " + einwohnerListeDatei.getPath() + " gespeichert.");
    }

    protected static void ladenEinwohnerListeVonDatei(){

        File einwohnerListeDatei = new File(EINWOHNER_DATEI_PFAD);

        if(!einwohnerListeDatei.exists()){
            System.out.println("Keine Einwohner-Datei gefunden.");
            return;
        }

        try(FileInputStream einwohnerInputDateiStream = new FileInputStream(einwohnerListeDatei);
            ObjectInputStream einwohnerInputObjectStream = new ObjectInputStream(einwohnerInputDateiStream)){

            liste = (Set<Einwohner>)einwohnerInputObjectStream.readObject();
            System.out.println(liste.size() + " Einwohner von " + einwohnerListeDatei.getPath() + " geladen.");

        }catch(Exception e){
            System.out.println("Fehler beim lesen der Datei " + einwohnerListeDatei.getName());
        }

    }
}
