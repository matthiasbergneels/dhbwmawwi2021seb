package excercises.chapter5.bahnhof;

public class Fracht {
    private Gueterwagon wagon;

    protected String bezeichnung;
    protected double menge;
    protected String verpackung;
    protected double volumen;

    public Fracht(String bezeichnung, double menge, String verpackung){
        this.setBezeichnung(bezeichnung);
        this.setMenge(menge);
        this.setVerpackung(verpackung);
    }

    public Gueterwagon getWagon() {
        return wagon;
    }

    public void setWagon(Gueterwagon wagon) {
        this.wagon = wagon;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }

    public String getVerpackung() {
        return verpackung;
    }

    public void setVerpackung(String verpackung) {
        this.verpackung = verpackung;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

  @Override
  public String toString() {
    return "Fracht{" +
      "bezeichnung='" + bezeichnung + '\'' +
      ", menge=" + menge +
      ", verpackung='" + verpackung + '\'' +
      ", volumen=" + volumen +
      '}';
  }
}
