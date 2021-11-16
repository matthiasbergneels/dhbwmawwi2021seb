package lecture.chapter5;

public class DrivewayRun {

  public static void main(String[] args) {


    Car myCar = new Car();
    Car yourCar = new Car();


    myCar.color = "Blau";
    myCar.hp = 150;
    myCar.brand = "Opel";

    yourCar.color = "Schwarz";
    yourCar.hp = 230;
    yourCar.brand = "Mercedes";

    myCar.accelerate(50);
    myCar.accelerate(10);

    yourCar.accelerate(100);

    System.out.println("Mein Auto hat " + myCar.hp + " PS und ist " + myCar.color + "; aktuelle Geschwindigkeit: " + myCar.currentSpeed);
    System.out.println("Dein Auto hat " + yourCar.hp + " PS und ist " + yourCar.color + "; aktuelle Geschwindigkeit: " + yourCar.currentSpeed);

    myCar.brake();
    myCar.brake();
    myCar.brake();

    System.out.println("Mein Auto hat " + myCar.hp + " PS und ist " + myCar.color + "; aktuelle Geschwindigkeit: " + myCar.currentSpeed);
    System.out.println("Dein Auto hat " + yourCar.hp + " PS und ist " + yourCar.color + "; aktuelle Geschwindigkeit: " + yourCar.currentSpeed);

    yourCar.fullBrake();

    System.out.println("Mein Auto hat " + myCar.hp + " PS und ist " + myCar.color + "; aktuelle Geschwindigkeit: " + myCar.currentSpeed);
    System.out.println("Dein Auto hat " + yourCar.hp + " PS und ist " + yourCar.color + "; aktuelle Geschwindigkeit: " + yourCar.currentSpeed);

  }
}
