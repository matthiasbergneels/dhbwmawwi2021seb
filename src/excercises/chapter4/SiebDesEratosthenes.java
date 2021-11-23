package excercises.chapter4;

import javax.swing.*;

public class SiebDesEratosthenes {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog("Geben Sie eine Zahl ein:");
        int og = Integer.parseInt(s);

        boolean[] primzahl = new boolean[og + 1];

        // Annahme: jede Zahl ist eine Primzahl, bis das Gegenteil bewiesen ist
        for(int i = 0; i < primzahl.length; i++){
            primzahl[i] = true;
        }

        for(int i = 2; i < primzahl.length; i++){
            if(primzahl[i]){
                int vielfaches = i + i;

                while(vielfaches < primzahl.length){
                    primzahl[vielfaches] = false;
                    vielfaches = vielfaches + i;
                }
            }
        }

        System.out.println("Primzahlen bis " + og);
        for(int i = 2; i < primzahl.length; i++){
            if(primzahl[i]){
                System.out.print(i + " ");
            }
        }
    }
}
