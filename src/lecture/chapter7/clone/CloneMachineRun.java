package lecture.chapter7.clone;

public class CloneMachineRun {

  public static void main(String[] args) {

    Sheep dolly = new Sheep("Dolly", 5);

    try {
      Sheep clonedDolly = dolly.clone();

      System.out.println(dolly.getName() + ", " + dolly.getAge());
      System.out.println(clonedDolly.getName() + ", " + clonedDolly.getAge());

      clonedDolly.setName("Dolly-Clone");

      System.out.println(dolly.getName() + ", " + dolly.getAge());
      System.out.println(clonedDolly.getName() + ", " + clonedDolly.getAge());

    }catch (Exception e){
      System.out.println("Klonen ist schief gegangen!");
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
