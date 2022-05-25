package lecture.chapter8;

import java.util.*;

public class MapExample {

  public static void main(String[] args) {

    Map<Integer, String> colorCodes = new HashMap<>();

    colorCodes.put(1000, "rot");
    colorCodes.put(2000, "blau");
    colorCodes.put(3000, "lila");
    colorCodes.put(4000, "gelb");
    colorCodes.put(5000, "gelb");
    colorCodes.put(1000, "grün");

    System.out.println("Wert für Schlüssel 2000: " + colorCodes.get(2000));
    System.out.println("Wert für Schlüssel 1000: " + colorCodes.get(1000));
    System.out.println("Anzahl Elemente: " + colorCodes.size());

    colorCodes.remove(3000);

    Set<Integer> colorKeys = colorCodes.keySet();
    Iterator<Integer> colorKeyIterator = colorKeys.iterator();
    while(colorKeyIterator.hasNext()){
      int colorKey = colorKeyIterator.next();
      System.out.println("Schlüssel: " + colorKey + " - Wert: " + colorCodes.get(colorKey));
    }

    Collection<String> colorValues = colorCodes.values();
    for(String color : colorValues){
      System.out.println(color);
    }
  }
}
