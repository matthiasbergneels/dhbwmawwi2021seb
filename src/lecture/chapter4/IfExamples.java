package lecture.chapter4;

public class IfExamples {

  public static void main(String[] args) {

    int grade = 3;

    if(grade <= 4) {
      System.out.println("Klausur bestanden");
      System.out.println("juhu!");
    } else {
      System.out.println("Durchgefallen");
      System.out.println("Muss ich wiederholen");
    }

    // Alternative:
    System.out.print((grade <= 4) ? "Klausur bestanden\njuhu!\n" : "Durchgefallen\nMuss ich wiederholen\n");


    if(grade < 2){
      System.out.println("Sehr gut bestanden");
    } else if (grade >= 3 & grade <= 4) {
      System.out.println("Das war knapp!");
    } else if (grade >= 2 & grade <= 3) {
      System.out.println("bestanden");
    } else {
      System.out.println("Durchgefallen");
      System.out.println("Muss ich wiederholen");
    }

    System.out.println("Programm Ende");




    // Short Circuite Evaluation

    boolean isRaining = true;
    boolean haveToLeaveHouse = false;

    if(haveToLeaveHouse && isRaining){
      System.out.println("Nimm einen Regenschirm mit");
    } else {
      System.out.println("Du brauchst keinen Regenschirm");
    }

    int numberA = 5;

    /*
    Wahrheitstabelle für &

    &     true  false
    true  true  false
    false false false
     */

    if(numberA > 10 & numberA++ < 100){
      System.out.println("NumberA ist zwischen 11 und 99");
    } else {
      System.out.println("NumberA ist kleiner gleich 10 und größer gleich 100");
    }

    System.out.println(numberA);

    String myText = null;

    if(myText != null && myText.length() > 10){
      System.out.println("der text ist länger als 10 Zeichen");
    } else {
      System.out.println("Der text hat weniger als 10 Zeichen oder es gibt keinen Text");
    }

    // Alternative

    if(myText != null){
      if(myText.length() > 10){
        System.out.println("der text ist länger als 10 Zeichen");
      } else {
        System.out.println("Der Text hat weniger als 10 Zeichen");
      }
    }

  }
}
