package lecture.chapter11;

import java.io.Serializable;

public class Person implements Serializable {

  static final long serialVersionUID = 1L;

  private String name;
  private String familyName;
  private transient String fullName;

  public Person(String name, String familyName){
    this.name = name;
    this.familyName = familyName;
    setFullName();
  }

  private void setFullName(){
    this.fullName = this.name + " " + this.familyName;
  }

  @Override
  public String toString() {
    return this.fullName;
  }

  public String getName() {
    return name;
  }

  public String getFamilyName() {
    return familyName;
  }

  private Object readResolve(){
    this.setFullName();
    return this;
  }

}
