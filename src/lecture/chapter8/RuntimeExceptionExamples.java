package lecture.chapter8;

public class RuntimeExceptionExamples {

  public static void main(String[] args) {

    String myText = null;

    if(myText != null) {
      System.out.println("Mein Text in Kleinbuchstaben:");
      System.out.println(myText.toLowerCase());

      System.out.println("Das war mein Text");
    } else {
      System.out.println("myText ist null");
    }

    try {

      System.out.println("Mein Text in Kleinbuchstaben:");
      System.out.println(myText.toLowerCase());

      System.out.println("Das war mein Text");

      int[] numbers = {1, 2, 3, 4, 5, 6};

      for (int i = 0; i <= numbers.length; i++) {
        System.out.println(numbers[i]);
      }
    }catch(NullPointerException e){
      System.out.println("myText ist null");

    }

  }
}
