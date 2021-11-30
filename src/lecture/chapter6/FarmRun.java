package lecture.chapter6;

public class FarmRun {

  public static void main(String[] args) {

    Animal myAnimal = new Animal(15f, "Peter", 30f);
    Dog myDog = new Dog(60f, "Bello", 40f, "Schäferhund");

    myAnimal.breath();
    myAnimal.eat();
    myAnimal.move();
    //myAnimal.bark(); --> Spezialisierung in Hund

    myDog.breath();
    myDog.eat();
    myDog.move();
    myDog.bark();

  }
}
