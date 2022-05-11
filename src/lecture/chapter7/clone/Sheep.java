package lecture.chapter7.clone;

import java.io.Serializable;

public class Sheep implements Cloneable {

  private String name;
  private int age;

  public Sheep(String name, int age){
    this.name = name;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }


  @Override
  public Sheep clone() throws CloneNotSupportedException{
    Sheep clonedSheep = (Sheep)super.clone();

    clonedSheep.age = 0;

    return clonedSheep;
  }


}
