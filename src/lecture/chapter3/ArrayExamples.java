package lecture.chapter3;

public class ArrayExamples {

  public static void main(String[] args) {

    int numberA, numberB, numberC, numberD, numberE;

    int[] numbers = new int[5];

    numbers[0] = 42;
    numbers[1] = 162;
    numbers[2] = 76;
    numbers[3] = 99;
    numbers[4] = 122;

    System.out.println(numbers[3]);

    short[] luckyNumbers = {13, 7, 55, 32, 17, 99, 125};

    System.out.println("Ausgabe von LuckyNumbers mit For-Each Schleife:");
    for(short currentNumber : luckyNumbers){
      if(currentNumber == 55){
        currentNumber = 0;
        continue;
      }
      if(currentNumber == 99){
        System.out.println("Satan!!!");
        break;
      }
      System.out.println(currentNumber);
    }

    System.out.println("Schleifen Durchlauf - Ende");

    System.out.println("Ausgabe LuckyNumbers mit For:");
    for(int i = 0; i < luckyNumbers.length; i++){
      if(luckyNumbers[i] == 55){
        luckyNumbers[i] = 0;
      }
      System.out.println(luckyNumbers[i]);
    }

    System.out.println("Schleifen Durchlauf - Ende");

    System.out.println(luckyNumbers[2]);
    System.out.println(luckyNumbers.length);


    char[][] tictactoe = new char[3][3];

    /*
       0 1 2
    0  X
    1    O
    2  O
    */

    tictactoe[1][1] = 'O';
    tictactoe[0][0] = 'X';
    tictactoe[0][2] = 'O';


    String[][] sentences = new String[5][];

    sentences[0] = new String[3];
    sentences[0][0] = "Ich";
    sentences[0][1] = "liebe";
    sentences[0][2] = "Dich";

    sentences[1] = new String[5];
    sentences[1][0] = "Ich";
    sentences[1][1] = "liebe";
    sentences[1][2] = "aber";
    sentences[1][3] = "Currywurst";
    sentences[1][4] = "mehr";

    sentences[2] = new String[2];
    sentences[2][0] = "Du";
    sentences[2][1] = "doof";


  }
}
