package lecture.chapter4;

public class OperatorExamples {

  public static void main(String[] args) {

    // arithemthische Operatoren

    int numberA = 5;
    int numberB = 10;

    int result = numberA + numberB;


    // Inkrement & Dekrement

    System.out.println(numberA);

    numberA++;    // --> numberA = numberA + 1;

    System.out.println(numberA);

    // post inkrement (erst der Ausdruck, dann das Inkrement)
    // Alternative:
    // result = numberA * numberB;
    // numberA = numberA + 1;
    result = numberA++ * numberB;

    System.out.println(result);

    // pre inkrement (erst das Inkrement, dann der Ausdruck
    // Alternative:
    // numberA = numberA + 1;
    // result = numberA * numberB;

    result = ++numberA * numberB;

    numberA = 1;

    result = numberA++ + numberA++ + numberA++;

    System.out.println(result);
    System.out.println(numberA);


    // Zuweisungsoperatoren
    numberA += numberB;   // numberA = numberA + numberB;

    // ? Operator
    boolean isRaining = false;

    String resultText = isRaining ? "Regenschirm einpacken" : "kein Regenschirm benötigt";

    System.out.println(resultText);

    {
      // String Verkettungen
      numberA = 4;
      numberB = 2;

      String textA = "Hallo";
      String textB = "Welt";

      resultText = numberA + numberB + textA + " " + textB + '!' + numberA + numberB;

      System.out.println(resultText);
    }
  }
}
