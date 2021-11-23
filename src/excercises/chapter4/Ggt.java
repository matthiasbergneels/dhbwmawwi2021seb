package excercises.chapter4;

public class Ggt {

    public static void main(String[] args) {

        int numberA = 240;
        int numberB = 70;

        if(numberA == 0 || numberB == 0){
            System.out.println("NumberA und/oder NumberB dürfen nicht 0 sein.");
            return; // beendet die Methode
        }

        while(numberA != numberB){
            if(numberA > numberB){
                numberA = numberA - numberB;
                // Alternative: numberA -= numberB;
            }else if(numberB > numberA){
                numberB = numberB - numberA;
                // Alternative: numberB -= numberA;
            }
        }

        System.out.println("GGT ist: " + numberA);
    }
}
