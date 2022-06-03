package lecture.excursion.innerclasses;

public class OuterClass {

  private int identifier;

  // inner top level class
  public static class InnerTopLevelClass{

    void print(String message){
      System.out.println(this.getClass().getName() + " Innere Top Level Klasse sagt: " + message);
    }
  }

  // inner element class
  public class InnerElementClass{

    void print(String message){
      System.out.println(this.getClass().getName() + " Innere Element Klasse sagt: " + message + " - " + identifier);
    }
  }

  void printFromInnerLocalClass(String message){

    // inner local class
    class InnerLocalClass{
      void print(String message){
        System.out.println(this.getClass().getName() + " Innere lokale Klasse sagt: " + message + " - " + identifier);
      }
    }

    InnerLocalClass myInnerLocalClass = new InnerLocalClass();
    myInnerLocalClass.print(message);
  }

  void printFromSecondInnerLocalClass(String message){

    // inner local class
    class InnerLocalClass{
      void print(String message){
        System.out.println(this.getClass().getName() + " Innere zweite lokale Klasse sagt: " + message + " - " + identifier);
      }
    }

    InnerLocalClass myInnerLocalClass = new InnerLocalClass();
    myInnerLocalClass.print(message);
  }

  void printFromThirdInnerLocalClass(String message){

    // inner local class
    class InnerThirdLocalClass{
      void print(String message){
        System.out.println(this.getClass().getName() + " Innere dritte lokale Klasse sagt: " + message + " - " + identifier);
      }
    }

    InnerThirdLocalClass myInnerLocalClass = new InnerThirdLocalClass();
    myInnerLocalClass.print(message);
  }

  public OuterClass(int identifier){
    this.identifier = identifier;
  }

  public static void main(String[] args) {
    String message = "Hello World";

    System.out.println(OuterClass.class.getName() + " - Äussere Klasse sagt: " + message);

    OuterClass.InnerTopLevelClass myInnerTopLevelClass = new OuterClass.InnerTopLevelClass();
    myInnerTopLevelClass.print(message);

    OuterClass myOuterClass = new OuterClass(42);
    OuterClass.InnerElementClass myInnerElementClass = myOuterClass.new InnerElementClass();
    myInnerElementClass.print(message);

    OuterClass mySecondOuterClass = new OuterClass(99);
    OuterClass.InnerElementClass myOtherInnerElementClass = mySecondOuterClass.new InnerElementClass();
    myOtherInnerElementClass.print(message);

    myOuterClass.printFromInnerLocalClass(message);
    myOuterClass.printFromSecondInnerLocalClass(message);
    myOuterClass.printFromThirdInnerLocalClass(message);
  }
}
