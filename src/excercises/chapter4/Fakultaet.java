package excercises.chapter4;

import java.util.Scanner;

public class Fakultaet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie eine Zahl ein: ");
        int fakultaet = scanner.nextInt();
        int result = 1;

        while(fakultaet > 0){
            result = result * fakultaet--;
            // Alternativ: result *= fakultaet--;
            //fakultaet--;
        }

        System.out.println("Die Fakultät beträgt: " + result);
    }
}
