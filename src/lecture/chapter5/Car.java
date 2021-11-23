package lecture.chapter5;

public class Car {

    // Attribute - Zustand der Objekte

    // Sichtbarkeitsmodifier: private, (default), protected, public
    private String color = "Schwarz";
    private short hp;
    private String licensePlate;
    private int currentSpeed = 0;
    final CarBrands brand;

    // Klassenattribut(e)
    private static int carCount = 0;

    // öffentliche Konstanten
    public final static String ALLOWED_COLOR_BLUE = "Blau";
    public final static String ALLOWED_COLOR_RED = "Rot";
    public final static String ALLOWED_COLOR_BLACK = "Schwarz";
    public final static String ALLOWED_COLOR_GREEN = "Grün";

    public enum CarBrands{
      Mercedes, Volvo, BMW, Fiat, Skoda, Audi
    }

    // Konstruktor(en)
    Car(String parameterColor, short parameterHp, CarBrands parameterBrand, String parameterLicensePlate){
      setColor(parameterColor);
      setHp(parameterHp);
      brand = parameterBrand;
      licensePlate = parameterLicensePlate;

      currentSpeed = 0;

      carCount++;
    }


    // Methoden - Verhalten der Objekte
    void accelerate(int accelerationSpeed){
      if(accelerationSpeed < hp / 10){
        this.currentSpeed = this.currentSpeed + accelerationSpeed;
      } else {
        this.currentSpeed = this.currentSpeed + hp / 10;
      }
    }

    void brake(){
      currentSpeed = currentSpeed - 10;
      if(currentSpeed < 0){
        currentSpeed = 0;
      }
    }

    void fullBrake(){
      currentSpeed = 0;
    }


    // getter- / setter- Methoden

    public int getCurrentSpeed(){
      return currentSpeed;
    }

    public String getColor(){
      return color;
    }

    public String getLicensePlate(){
      return licensePlate;
    }

    public short getHp(){
      return hp;
    }

    /* --> weil public final
    public String getBrand(){
      return brand;
    }
     */

    public void setColor(String color){
      if (color.equalsIgnoreCase(ALLOWED_COLOR_BLACK) |
        color.equalsIgnoreCase(ALLOWED_COLOR_RED) |
        color.equalsIgnoreCase(ALLOWED_COLOR_BLUE) |
        color.equalsIgnoreCase(ALLOWED_COLOR_GREEN)) {
        this.color = color;
      } else {
        this.color = ALLOWED_COLOR_BLACK;
      }
    }

    public void setHp(short hp){
      if(hp >= 50 && hp <= 999){
        this.hp = hp;
      } else {
        this.hp = 100;
      }
    }

    protected void finalize(){
      carCount--;
      System.out.println("Das " + this.color + " Auto mit " + this.hp + " PS und dem Nummernschild " + this.licensePlate + " wurde verschrottet");
    }

    // Klassenmethode(n)
    public static int getCarCount(){
      return carCount;
    }
}
