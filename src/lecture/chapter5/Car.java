package lecture.chapter5;

public class Car {

    // Attribute - Zustand der Objekte

    // Sichtbarkeitsmodifier: private, (default), protected, public
    private String color = "Schwarz";
    private short hp;
    private String licensePlate;
    private int currentSpeed = 0;
    final CarBrands brand;

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
    }


    // Methoden - Verhalten der Objekte
    void accelerate(int accelerationSpeed){
      if(accelerationSpeed < hp / 10){
        currentSpeed = currentSpeed + accelerationSpeed;
      } else {
        currentSpeed = currentSpeed + hp / 10;
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

    public void setColor(String parameterColor){
      if (parameterColor.equalsIgnoreCase(ALLOWED_COLOR_BLACK) |
        parameterColor.equalsIgnoreCase(ALLOWED_COLOR_RED) |
        parameterColor.equalsIgnoreCase(ALLOWED_COLOR_BLUE) |
        parameterColor.equalsIgnoreCase(ALLOWED_COLOR_GREEN)) {
        color = parameterColor;
      } else {
        color = ALLOWED_COLOR_BLACK;
      }

    }

    public void setHp(short parameterHp){
      if(parameterHp >= 50 && parameterHp <= 999){
        hp = parameterHp;
      } else {
        hp = 100;
      }
    }

}
