package lecture.chapter9;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

  public static void main(String[] args) {

    Set<String> nameSet = new TreeSet<>();

    nameSet.add("Klaus");
    nameSet.add("zeus");
    nameSet.add("Gertrude");
    nameSet.add("Gabi");
    nameSet.add("Michael");
    nameSet.add("alfred");

    System.out.println("Anzahl Namen: " + nameSet.size());
    System.out.println("Enthält Zeus: " + nameSet.contains("Zeus"));
    System.out.println("Lösche Gertrude: " + nameSet.remove("Gertrude"));
    System.out.println("Lösche Gertrude: " + nameSet.remove("Gertrude"));

    Iterator<String> nameSetIterator = nameSet.iterator();
    while(nameSetIterator.hasNext()){
      String name = nameSetIterator.next();
      System.out.println(name);
    }



    Set<FullName> fullNameSet = new TreeSet<>();

    fullNameSet.add(new FullName("Klaus", "Schmidt"));
    fullNameSet.add(new FullName("Gabi", "Müller"));
    fullNameSet.add(new FullName("Franz", "Müller"));
    fullNameSet.add(new FullName("Zeus", "Gott"));
    fullNameSet.add(new FullName("Klaus", "Schmidt"));

    FullName firstFullName = new FullName("Hans", "Franz");
    FullName secondFullName = new FullName("Hans", "Franz");
    FullName thirdFullName = firstFullName;

    System.out.println("First equals Third: " + firstFullName.equals(thirdFullName));
    System.out.println("First equals Seconds: " + firstFullName.equals(secondFullName));

    fullNameSet.add(firstFullName);
    fullNameSet.add(secondFullName);
    fullNameSet.add(thirdFullName);

    for(FullName name : fullNameSet){
      System.out.println(name);
    }


    String nameOne = "Klaus";
    String nameTwo = new String("Klaus");
    String nameThree = nameOne;

    System.out.println("nameOne == nameTwo: " + (nameOne == nameTwo));
    System.out.println("nameOne == nameThree: " + (nameOne == nameThree));

    System.out.println("nameOne equals nameThree: " + (nameOne.equals(nameThree)));
    System.out.println("nameThree equals nameOne: " + (nameThree.equals(nameOne)));
    System.out.println("nameOne equals nameTwo: " + (nameOne.equals(nameTwo)));


    TreeSet<FullName> nameSetByLength = new TreeSet<>(new SortFullNameBySignCount());
    nameSetByLength.addAll(fullNameSet);


    System.out.println("Name Set sorted by sign count:");
    for(FullName name : nameSetByLength){
      System.out.println(name);
    }


    nameSetByLength.add(new FullName("a", "b"));
    nameSetByLength.add(new FullName("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "b"));

    System.out.println("Name Set sorted by sign count:");
    for(FullName name : nameSetByLength){
      System.out.println(name);
    }

  }
}
