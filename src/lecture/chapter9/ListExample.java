package lecture.chapter9;

import java.util.*;

public class ListExample {

  public static void main(String[] args) {

    List<String> nameList = new ArrayList<String>();

    nameList.add("Klaus");
    nameList.add("Gabi");
    nameList.add("Gertrude");
    nameList.add("Zeus");
    //nameList.add(50);

    System.out.println("Anzahl an Namen: " + nameList.size());
    System.out.println("Element am 2. Index: " + nameList.get(2));

    System.out.println("Enthält Zeus: " + nameList.contains("Zeus"));
    System.out.println("Enthält Fred: " + nameList.contains("Fred"));

    System.out.println("Zeus löschen: " + nameList.remove("Zeus"));
    System.out.println("Zeus löschen: " + nameList.remove("Zeus"));

    for(int i = 0; i < nameList.size(); i++){
      System.out.println("index " + i + ": " + nameList.get(i));
    }

    for(String name : nameList){
      System.out.println(name);
      /*
      if(name.equals("Gertrude")){
        nameList.remove("Gertrude"); --> keine externen Modificationen auf Containern während einer Iterration
      }
       */
    }

    Iterator<String> nameListIterator = nameList.iterator();
    while(nameListIterator.hasNext()){
      String name = nameListIterator.next();
      System.out.println(name);
      if(name.equals("Gertrude")){
        nameListIterator.remove();
        //nameList.add("Hans");
      }
    }
    System.out.println("Anzahl Namen: " + nameList.size());



    List<Integer> numbers = new ArrayList();

    numbers.add(50); // Auto Boxing --> Elementarer Datentyp in Objekt
    numbers.add(10);
    numbers.add(100);

    for(int number : numbers){ // --> Auto Unboxing Objekt in elementaren Datetyp
      System.out.println(number + 6);
    }




    List<FullName> fullNameList = new ArrayList<>();

    fullNameList.add(new FullName("Klaus", "Schmidt"));
    fullNameList.add(new FullName("Gabi", "Müller"));
    fullNameList.add(new FullName("Franz", "Müller"));
    fullNameList.add(new FullName("Zeus", "Gott"));
    fullNameList.add(new FullName("Klaus", "Schmidt"));

    System.out.println("Unsortierte Namen:");
    for(FullName name : fullNameList){
      System.out.println(name);
    }

    // Sortierung nach der natürlichen Ordnung
    Collections.sort(fullNameList);
    System.out.println("Natürliche Ordnung - Namen:");
    for(FullName name : fullNameList){
      System.out.println(name);
    }

    // Sortierung nach der externer Ordnung --> by sign Count
    Collections.sort(fullNameList, new SortFullNameBySignCount());
    System.out.println("Sortiert nach Anzahl der Zeichen - Namen:");
    for(FullName name : fullNameList){
      System.out.println(name);
    }

    // Sort mit Lambda Function über Comparator Interface - inline
    Collections.sort(fullNameList, (nameOne, nameTwo) -> {
      int signCountNameOne = nameOne.getName().length() + nameOne.getFamilyName().length();
      int signCountNameTwo = nameTwo.getName().length() + nameTwo.getFamilyName().length();

      return signCountNameOne - signCountNameTwo;
    });

    // Sort mit Lambda Function über Comparator Interface - aus FullName Class
    Collections.sort(fullNameList, FullName.sortByFirstNameSignCount);
  }
}
