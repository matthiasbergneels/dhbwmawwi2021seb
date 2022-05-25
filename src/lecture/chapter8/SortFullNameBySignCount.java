package lecture.chapter8;

import java.util.Comparator;

public class SortFullNameBySignCount implements Comparator<FullName> {

  public int compare(FullName nameOne, FullName nameTwo){
    int signCountNameOne = nameOne.getName().length() + nameOne.getFamilyName().length();
    int signCountNameTwo = nameTwo.getName().length() + nameTwo.getFamilyName().length();

    return signCountNameOne - signCountNameTwo;
  }
}
