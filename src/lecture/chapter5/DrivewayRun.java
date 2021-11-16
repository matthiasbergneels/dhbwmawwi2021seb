package lecture.chapter5;

public class DrivewayRun {

  public static void main(String[] args) {


    Car myCar = new Car(Car.ALLOWED_COLOR_BLUE, (short)150, Car.CarBrands.Mercedes, "MA-HH 1234");
    // Java Quellcode ohne IntelliJ "Hilfe": Car myCar = new Car("blau", (short)150, "Opel", "MA-HH 1234");

    Car yourCar = new Car(Car.ALLOWED_COLOR_RED, (short)230, Car.CarBrands.Audi, "MA-MM 5678");
    Car hisCar = new Car(Car.ALLOWED_COLOR_RED, (short)230, Car.CarBrands.Skoda, "HH-HI 987");

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS und ist " + myCar.getColor() + "; aktuelle Geschwindigkeit: " + myCar.getCurrentSpeed());
    System.out.println("Dein Auto hat " + yourCar.getHp() + " PS und ist " + yourCar.getColor() + "; aktuelle Geschwindigkeit: " + yourCar.getCurrentSpeed());

    /*
    myCar.color = "Blau";
    myCar.hp = 150;
    myCar.brand = "Opel";

    yourCar.color = "Schwarz";
    yourCar.hp = 230;
    yourCar.brand = "Mercedes";
     */

    myCar.setColor("Rot");


    myCar.accelerate(1000);
    myCar.accelerate(10);

    yourCar.accelerate(100);

    // currentSpeed --> Private
    // myCar.currentSpeed = 1000;

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS und ist " + myCar.getColor() + "; aktuelle Geschwindigkeit: " + myCar.getCurrentSpeed());
    System.out.println("Dein Auto hat " + yourCar.getHp() + " PS und ist " + yourCar.getColor() + "; aktuelle Geschwindigkeit: " + yourCar.getCurrentSpeed());

    myCar.brake();
    myCar.brake();
    myCar.brake();

    myCar.setColor("Grün");

    // currentSpeed --> Private
    //yourCar.currentSpeed = -10;

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS und ist " + myCar.getColor() + "; aktuelle Geschwindigkeit: " + myCar.getCurrentSpeed());
    System.out.println("Dein Auto hat " + yourCar.getHp() + " PS und ist " + yourCar.getColor() + "; aktuelle Geschwindigkeit: " + yourCar.getCurrentSpeed());

    yourCar.fullBrake();

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS und ist " + myCar.getColor() + "; aktuelle Geschwindigkeit: " + myCar.getCurrentSpeed());
    System.out.println("Dein Auto hat " + yourCar.getHp() + " PS und ist " + yourCar.getColor() + "; aktuelle Geschwindigkeit: " + yourCar.getCurrentSpeed());

  }
}
