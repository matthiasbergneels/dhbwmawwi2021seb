package lecture.chapter8;

import java.util.Comparator;

public class FullName implements Comparable<FullName>{

  public static Comparator<FullName> sortByFirstNameSignCount = (nameOne, nameTwo) -> {
    return nameOne.name.length() - nameTwo.name.length();
  };

  private String name;
  private String familyName;

  public FullName(String name, String familyName){
    this.name = name;
    this.familyName = familyName;
  }

  public String getName(){
    return name;
  }

  public String getFamilyName(){
    return familyName;
  }

  @Override
  public String toString() {
    return this.familyName + ", " + this.name;
  }

  @Override
  public int compareTo(FullName o) {

    if(!this.familyName.equals(o.familyName)){
      return this.familyName.compareTo(o.familyName);
    }

    return this.name.compareTo(o.name);
  }

  public boolean equals(Object o){

    // Alias-Vergleich
    if(this == o){
      return true;
    }

    // null-Prüfung
    if(o == null){
      return false;
    }

    // Typ-Vergleich
    if(this.getClass() != o.getClass()){
      return false;
    }

    /* Alternative für Typ Vergleich
    if(!(o instanceof FullName)){
      return false;
    }
     */

    // Attribut-Vergleich
    FullName equalsFullName = (FullName)o;

    /*
    if(!this.name.equals(equalsFullName.name)){
      return false;
    }

    if(!this.familyName.equals(equalsFullName.familyName)){
      return false;
    }
     */

    return (this.compareTo(equalsFullName) == 0);
  }

  public int hashCode() {
    return name.hashCode() + familyName.hashCode();
  }

  /*
  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 13 * result + (familyName != null ? familyName.hashCode() : 0);
    return result;
  }

   */
}
