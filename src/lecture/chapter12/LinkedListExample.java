package lecture.chapter12;

public class LinkedListExample {

  public static void main(String[] args) {

    LinkedList wordList = new LinkedList();

    wordList.add("Erstens");
    wordList.add("Zweitens");
    wordList.add("Drittens");
    wordList.add("Drittens");
    wordList.add("Klaus");
    wordList.add("Drittens");
    wordList.add("Drittens");
    wordList.add("Drittens");
    wordList.add("Fünftens");

    System.out.println("Erstens :" + wordList.contains("Erstens"));       // Big-O: Best-Case --> O(1)
    System.out.println("Klaus :" + wordList.contains("Klaus"));           // Big-O: Mid-Case --> O (5) --> Average-Case --> O(n/2)
                                                                          // --> Wegfall von Konstanten O(n)
    System.out.println("Fünftens :" + wordList.contains("Fünftens"));     // Big-O: Worst-Case --> O (n)
    System.out.println("HansFranz :" + wordList.contains("HansFranz"));   // Big-O: Worst-Case --> O (n)



    System.out.println("Anzahl Elemente in der Liste: " + wordList.size());
    wordList.printList();

    System.out.println("Lösche Drittens: " + wordList.remove("Drittens"));
    System.out.println("Lösche Erstens: " + wordList.remove("Erstens"));
    System.out.println("Lösche Zweitens: " + wordList.remove("Zweitens"));
    System.out.println("Lösche Fünftens: " + wordList.remove("Fünftens"));

    System.out.println("Anzahl Elemente in der Liste: " + wordList.size());
    wordList.printList();

    wordList.add("LetztesElement");

    System.out.println("Anzahl Elemente in der Liste: " + wordList.size());
    wordList.printList();

    System.out.println("Liste beendet");

  }
}
