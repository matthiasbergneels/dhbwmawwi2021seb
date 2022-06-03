package lecture.excursion.innerclasses;

import java.util.Locale;

public class OuterClass {

  private int identifier;

  public static interface InnerInterface{
    void print(String message);
  }

  public InnerInterface myInnerAnonymousClass = new InnerInterface() {
    @Override
    public void print(String message) {
      System.out.println(this.getClass().getName() + " Innere anonyme Klasse im Objektkontext sagt: " + message + " - " + identifier);
    }
  };

  public static InnerInterface myInnerStaticAnonymousClass = new InnerInterface() {
    @Override
    public void print(String message) {
      System.out.println(this.getClass().getName() + " Innere anonyme Klasse im Klassenkontext sagt: " + message);
    }
  };

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

  public abstract class InnerAbstractElementClass{

    int innerIdentifier;

    InnerAbstractElementClass(int innerIdentifier){
      this.innerIdentifier = innerIdentifier;
    }

    abstract void print(String message);
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

  void printFromInnerAnonymousClass(String message){

    // inner anonymous class
    InnerInterface myInnerAnonymousClass = new InnerInterface() {
      @Override
      public void print(String message) {
        System.out.println(this.getClass().getName() + " Innere anonyme Klasse sagt: " + message + " - " + identifier);
      }
    };

    myInnerAnonymousClass.print(message);
  }

  void printFromInnerAnonymousClassAbstractBased(String message){

    // inner anonymous class
    InnerAbstractElementClass myInnerAnonymousClass = new InnerAbstractElementClass(66) {

      @Override
      void print(String message) {
          System.out.println(this.getClass().getName() + " Innere abstrakte Element Klasse sagt: " + message + " - OuterClass:" + identifier + " - InnerClass: " + this.innerIdentifier);
      }
    };

    myInnerAnonymousClass.print(message);
  }

  void printFromLambdaFunction(String message){

    //identifier = identifier + 1;

    final String additionalText = "myText";

    InnerInterface myLambdaFunction = (String lambdaMessage) -> {
      System.out.println(this.getClass().getName() + " Lambda Funktion sagt: " + lambdaMessage + " - OuterClass:" + identifier + additionalText);
    };

    myLambdaFunction.print(message);
  }

  void printFromShortedLambdaFunction(String message){

    //identifier = identifier + 1;

    final String additionalText = "myText";

    InnerInterface myLambdaFunction = lambdaMessage ->
      System.out.println(this.getClass().getName() + " verkürzte Lambda Funktion sagt: " + lambdaMessage + " - OuterClass:" + identifier + additionalText);;

    myLambdaFunction.print(message);
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


    myOuterClass.printFromInnerAnonymousClass(message);
    myOuterClass.printFromInnerAnonymousClassAbstractBased(message);

    myOuterClass.myInnerAnonymousClass.print(message);
    mySecondOuterClass.myInnerAnonymousClass.print(message);

    OuterClass.myInnerStaticAnonymousClass.print(message);

    myOuterClass.printFromLambdaFunction(message);
    myOuterClass.printFromShortedLambdaFunction(message);
  }
}
