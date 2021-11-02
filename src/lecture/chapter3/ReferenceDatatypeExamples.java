package lecture.chapter3;

public class ReferenceDatatypeExamples {

  public static void main(String[] args) {


    int numberA = 5;
    int numberB = 10;
    double numberC = 5.0;

    System.out.println(numberA == numberB);
    System.out.println(numberA == numberC);


    String myText1 = "Hallo";
    String myText2 = "Hallo";

    String myText3 = new String("Hallo");

    System.out.println(myText3);

    System.out.println("String Vergleich ==");
    System.out.println(myText1 == myText2);
    System.out.println(myText1 == myText3);

    System.out.println("String Vergleich mit equals()");
    System.out.println(myText1.equals(myText2));
    System.out.println(myText1.equals(myText3));
  }
}
