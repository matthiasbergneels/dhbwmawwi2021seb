package excercises.chapter5.bahnhof;

public class Gueterwagon {
    private Gueterzug zug;
    private Fracht[] fracht;

    private double maxLast;
    private String typ;
    private byte achsen;

    public Gueterwagon(int nummer, String typ, byte achsen){
        this.setAchsen(achsen);
        this.setMaxLast(achsen);
        this.setTyp(typ);
    }
    public Fracht[] getFracht() {
        return fracht;
    }

    public void setFracht(Fracht[] fracht) {
        this.fracht = fracht;

        // bi-direktionale Beziehung setzen
        if(fracht != null){
            for(Fracht einzelFracht : fracht){
                einzelFracht.setWagon(this);
            }
        }
    }

    public double getGesamtFrachtVolumen(){
        double gesamtFrachtVolumen = 0;

        for(Fracht aktuelleFracht: fracht){
            // Hier versteckt sich Polymorphy ;-)
            gesamtFrachtVolumen += aktuelleFracht.getVolumen();
        }

        return gesamtFrachtVolumen;
    }

    public double getMaxLast() {
        return maxLast;
    }

    public void setMaxLast(double maxLast) {
        this.maxLast = maxLast;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public byte getAchsen() {
        return achsen;
    }

    public void setAchsen(byte achsen) {
        this.achsen = achsen;
    }
    public Gueterzug getZug() {
        return zug;
    }
    public void setZug(Gueterzug zug) {
        this.zug = zug;
    }

  @Override
  public String toString() {
    return "Gueterwagon{" +
      "zug=" + zug +
      ", maxLast=" + maxLast +
      ", typ='" + typ + '\'' +
      ", achsen=" + achsen +
      '}';
  }
}