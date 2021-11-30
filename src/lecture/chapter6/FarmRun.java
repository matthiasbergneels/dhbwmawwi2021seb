package lecture.chapter6;

public class FarmRun {

  public static void main(String[] args) {

    //Animal myAnimal = new Animal(15f, "Peter", 30f); --> Abstrakte Klassen können nicht instanziert werden
    Dog myDog = new Dog(60f, "Bello", 40f, "Schäferhund");
    Bird myBird = new Bird(5f, "Tweety", 15f, true);

    /*
    myAnimal.breath();
    myAnimal.eat();
    myAnimal.move();
    //myAnimal.bark(); --> Spezialisierung in Hund
    */


    myDog.breath();
    myDog.eat();
    myDog.eat(500f);
    myDog.move();
    myDog.bark();

    myBird.breath();
    myBird.eat();
    myBird.move();
    myBird.tweet();

    System.out.println(myDog.toString());
    System.out.println(myBird); // --> toString wird implizit zur Konvertierung des Objektes in eine String aufgerufen
    System.out.println(myBird.hashCode());

    //System.out.println(myAnimal);

  }
}
