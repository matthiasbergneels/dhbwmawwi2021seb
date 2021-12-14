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


    // Narrowing Cast -> Sichbarkeit einschränkend (impliziter Cast)
    Animal anyAnimal = myDog;

    anyAnimal.move();
    anyAnimal.eat();
    anyAnimal.breath();
    //anyAnimal.bark(); --> durch die Animal Referenz ist die Sichtbarkeit eingeschränkt

    Object anyObject = anyAnimal;

    System.out.println(anyObject);

    // Widening Cast --> Sichbarkeit erweiternd
    Dog anyDog = (Dog)anyAnimal;

    anyDog.breath();
    anyDog.eat();
    anyDog.move();
    anyDog.bark();



    Animal[] shelter = new Animal[5];
    // Narrowing Cast
    shelter[0] = myDog;
    shelter[1] = myBird;
    shelter[2] = new Bird(14f, "Funny", 10f, true);
    shelter[3] = new Bird(14f, "Pingi", 10f, false);
    shelter[4] = new Dog(49f, "Wuffi", 30f, "Bully");

    System.out.println("Bauer läuft durch den Stall und kümmert sich um jedes Tier:");
    for(Animal currentAnimal : shelter){
      currentAnimal.breath();
      currentAnimal.eat();
      currentAnimal.move();

      if(currentAnimal instanceof Dog){
        Dog currentDog = (Dog)currentAnimal;

        currentDog.bark();
      } else {
        System.out.println(currentAnimal.getDescription() + " ist kein Hund!");
      }
    }
  }
}
