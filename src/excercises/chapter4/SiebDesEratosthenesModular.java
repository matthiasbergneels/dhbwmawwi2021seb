package excercises.chapter4;

public class SiebDesEratosthenesModular {

    public static void main(String[] args) {

        int og = UserInput.returnUserInputAsInteger("Primzahlen bis Obergrenze: ");

        boolean[] primzahl = erzeugeUndInitialisiereBooleanArray(og);

        for(int i = 2; i < primzahl.length; i++){
            if(primzahl[i]){
                int vielfaches = i + i;

                while(vielfaches < primzahl.length){
                    primzahl[vielfaches] = false;
                    vielfaches = vielfaches + i;
                }
            }
        }

        ausgabePrimzahlen(primzahl);
    }

    static boolean[] erzeugeUndInitialisiereBooleanArray(int obergrenze){
        boolean[] primzahlArray = new boolean[obergrenze + 1];

        for(int i = 0; i < primzahlArray.length; i++){
            primzahlArray[i] = true;
        }

        return primzahlArray;
    }

    static void ausgabePrimzahlen(boolean[] primzahlenArray){
        System.out.println("Primzahlen: ");
        for(int i = 0; i < primzahlenArray.length; i++){
            if(primzahlenArray[i]){
                System.out.println(i);
            }
        }
        System.out.println("Ausgabe der Primzahlen beendet!");
    }
}
