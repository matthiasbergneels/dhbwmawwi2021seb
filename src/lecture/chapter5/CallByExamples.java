package lecture.chapter5;

public class CallByExamples {

  public static void main(String[] args) {


    // Call by value (in Java bei primitiven Datentypen - mit Ausnahmen)
    int numberA = 5;
    int numberB;

    // Zuweisung --> Call by value (Wertübergabe / Wert kopier)
    numberB = numberA;

    numberA = numberA + 10;

    System.out.println("NumberA: " + numberA);
    System.out.println("NumberB: " + numberB);


    // Call by Reference (in Java bei komplexen Datentypen)

    Person herrBergNeels = new Person();
    Person profDrRitterbusch = new Person();

    // Call by Reference
    Person matthias = herrBergNeels;
    Person papa = matthias;
    Person hasiPupsi = herrBergNeels;

    System.out.println("Hat Herr Berg-Neels ein blaues Auge? " + herrBergNeels.hasBlueEye());
    System.out.println("Hat Prof. Dr. Ritterbusch ein blaues Auge? " + profDrRitterbusch.hasBlueEye());
    System.out.println("Hat Herr HasiPupsi ein blaues Auge? " + hasiPupsi.hasBlueEye());

    hasiPupsi.hitInFace();

    System.out.println("Hat Herr HasiPupsi ein blaues Auge? " + hasiPupsi.hasBlueEye());
    System.out.println("Hat Prof. Dr. Ritterbusch ein blaues Auge? " + profDrRitterbusch.hasBlueEye());
    System.out.println("Hat Herr Berg-Neels ein blaues Auge? " + herrBergNeels.hasBlueEye());

  }
}
