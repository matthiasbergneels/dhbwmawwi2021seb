package lecture.chapter3;

public class DatatypeExamples {

  public static void main(String[] args) {

    // Deklaration
    int numberA;

    // Inititialisierung
    numberA = 42;

    // Deklaration & Initialisierung
    int numberB = 13;

    boolean isTired;
    isTired = true;

    System.out.println(isTired);

    numberA = 10;

    // Deklaration & Initialisierung einer Konstanten
    final double MATH_PI = 3.14;

    // nicht möglich, da konstant
    // MATH_PI = 5;


    // Ganzzahlenliterale

    // Dezimalliteral (Werte 0 - 9 ohne führende 0)
    numberA = 42;
    System.out.println(numberA);

    // Oktalliteral (Werte 0 - 7 mit führender 0)
    numberA = 012;
    System.out.println(numberA);

    // Hexadezimalliteral (Werte 0 - 9, A - F mit Prefix 0x)
    numberA = 0x2A;
    System.out.println(numberA);

    int colorCodeRed = 0xFF0000;

    // Long-Literal
    long veryLongNumber = 42000000000l;


    short smallNumber = 42;

    // implizite Typisierung
    var numberC = 42;             // --> implizite Typisierung auf Integer
    var numberD = 3.14;           // --> implizite Typisierung auf Double
    var veryLongNumberB = 67l;    // implizite Typisierung auf Long


    // Gleitkommazahl-Literale

    // Double-Literal
    double bigPreciseNumberA = .5;
    System.out.println(bigPreciseNumberA);

    bigPreciseNumberA = 3.;     // --> bigPreciseNumberA = 3;
    System.out.println(bigPreciseNumberA);

    bigPreciseNumberA = 3.14e2;
    System.out.println(bigPreciseNumberA);

    bigPreciseNumberA = 3.14e-2;
    System.out.println(bigPreciseNumberA);

    bigPreciseNumberA = 3.14e5d;
    System.out.println(bigPreciseNumberA);


    // Float-Literal (wie Double-Literal aber zwingend mit Suffix f/F)
    float notSoPreciseNumberA = 3.14e5f;

    // Char-Literal
    char firstSign = 'a';
    System.out.println(firstSign);

    firstSign = '5';
    System.out.println(firstSign);

    firstSign = '!';
    System.out.println(firstSign);

    firstSign = 70;
    System.out.println(firstSign);

    firstSign = '\u2764';
    System.out.println(firstSign);


    // Zeichenketten-Literal

    String myText = "Hier steht \"mein\" Text! \nIn mehreren \tZeilen. \u2764";
    System.out.println(myText);

    // Textblock Literal (seit Java 15)
    String htmlAsBlock = """
            <html>
              <body>
                <p>Hello, world</p>
              </body>
            </html>
            """;

    System.out.println(htmlAsBlock);


    // Typkonvertierung

    short smallNumberA = 42;

    int biggerNumberA;

    // Konvertierung --> short zu int --> implizite / erweiternde Konvertierung
    biggerNumberA = smallNumberA;
    System.out.println(biggerNumberA);

    biggerNumberA = biggerNumberA + 1;

    // Konvertierung --> int zu short --> explizite / einschränkende Konvertierung
    smallNumberA = (short)biggerNumberA;
    System.out.println(smallNumberA);

    // Konvertierung Gleitkomma zu Ganzzahl --> Abschneiden der Nachkommastellen
    biggerNumberA = (int)bigPreciseNumberA;
    System.out.println(biggerNumberA);

    // Konvertierung Gleitkomma zu Ganzzahl --> Abschneiden der Nachkommastellen
    bigPreciseNumberA = 3.54;
    biggerNumberA = (int)bigPreciseNumberA;
    System.out.println(biggerNumberA);
  }
}
