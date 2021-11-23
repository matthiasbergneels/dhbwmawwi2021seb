package excercises.chapter4;

public class Fibonacci {

    public static void main(String[] args) {

        int range = 10;

        int[] fibonacci = new int[range];

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for(int i = 2; i < range; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        for(int number : fibonacci){
            System.out.print(number + " ");
        }


    }

}
