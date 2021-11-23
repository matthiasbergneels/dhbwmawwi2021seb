package lecture.chapter5.family;

public class Mann {

  private Frau ehefrau;
  private Kind[] kinder;

  public Mann() {
    kinder = new Kind[20];
  }

  public Frau getEhefrau() {
    return ehefrau;
  }

  public void setEhefrau(Frau ehefrau) {
    this.ehefrau = ehefrau;
  }
}
