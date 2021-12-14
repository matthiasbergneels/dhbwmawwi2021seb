package excercises.chapter5.bahnhof;

public class Zuglokomotive {
    private Gueterzug zug;

    private int nummer;
    private String typ;
    private String antrieb;
    private byte achsen;

    public Zuglokomotive(int nummer, String typ, String antrieb, byte achsen){
        this.setAchsen(achsen);
        this.setNummer(nummer);
        this.setAntrieb(antrieb);
        this.setTyp(typ);
    }


    public int getNummer() {
        return nummer;
    }
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
    public String getTyp() {
        return typ;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public String getAntrieb() {
        return antrieb;
    }
    public void setAntrieb(String antrieb) {
        this.antrieb = antrieb;
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
    return "Zuglokomotive{" +
      "nummer=" + nummer +
      ", typ='" + typ + '\'' +
      ", antrieb='" + antrieb + '\'' +
      ", achsen=" + achsen +
      '}';
  }
}
