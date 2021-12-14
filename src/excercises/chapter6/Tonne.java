package excercises.chapter6;

import excercises.chapter5.bahnhof.Fracht;

public class Tonne extends Fracht {

    private int hoehe;
    private int radius;

    public Tonne(String bezeichnung, double Menge, int hoehe, int radius){
        super(bezeichnung, Menge, "Tonne");
        this.verpackung = "Tonne";
        this.setHoehe(hoehe);
        this.setRadius(radius);

        // alternativ - berechnen des Volumens zur Laufzeicht
        //this.setVolumen();
    }

    public int getHoehe() {
        return hoehe;
    }
    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // alternativ - berechnen des Volumens zur Laufzeit
    @Override
    public double getVolumen() {
        return (this.getHoehe() * this.getRadius() * 2 * Math.PI);
    }

  @Override
  public String toString() {
    return "Tonne{" +
      " " + super.toString() + " " +
      "hoehe=" + hoehe +
      ", radius=" + radius +
      '}';
  }
}
