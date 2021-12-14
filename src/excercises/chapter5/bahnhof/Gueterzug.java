package excercises.chapter5.bahnhof;

public class Gueterzug {
    private Zugfuehrer fahrer;

    private Zuglokomotive lok;
    private Gueterwagon[] wagons;


    private int nummer;
    private double laenge;
    private int anzWagons;


    public Gueterzug(Zuglokomotive lok, Gueterwagon[] wagons, int nummer, int anzWagons){

        this.setAnzWagons(anzWagons);
        this.setNummer(nummer);

        this.setLok(lok);
        this.setWagons(wagons);

        System.out.println(this);
    }

    public Gueterzug(int nummer, int anzWagons){
        this(erzeugeLokomotive(), erzeugeWagons(anzWagons), nummer, anzWagons);
    }

    public Zugfuehrer getFahrer() {
        return fahrer;
    }

    public void setFahrer(Zugfuehrer fahrer) {
        this.fahrer = fahrer;
    }

    public Zuglokomotive getLok() {
        return lok;
    }

    public void setLok(Zuglokomotive lok) {
        if(lok != null){
            this.lok = lok;
        }else{
            this.lok = erzeugeLokomotive();
        }

        // bi-direktionale Beziehung setzen
        this.lok.setZug(this);

    }

    public Gueterwagon[] getWagons() {
        return wagons;
    }

    public void setWagons(Gueterwagon[] wagons) {
        if(wagons != null){
            this.wagons = wagons;
        }else{
            this.wagons = erzeugeWagons(2);

        }
        this.setAnzWagons(this.wagons.length);

        // bi-direktionale Beziehung setzen
        for(Gueterwagon wagon : this.wagons){
            wagon.setZug(this);
        }

    }

    public void setWagons(Gueterwagon wagon){
        if(wagon != null){
            Gueterwagon[] wagons = {wagon};
            this.wagons = wagons;
        }else{
            this.wagons = erzeugeWagons(1);
        }
    }

    public void fahren(){
        if(fahrer != null){
            System.out.println("Tschu Tschu Tschu... ");
        }else{
            System.out.println("Lokomitive kann ohne Zugfuherer nicht fahren");
        }
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public int getAnzWagons() {
        return anzWagons;
    }

    public void setAnzWagons(int anzWagons) {
        this.anzWagons = anzWagons;
    }

    public double getGesamtFrachtVolumen(){
        double gesamtFrachtVolumen = 0;

        for(Gueterwagon aktuellerWagon : wagons){
            gesamtFrachtVolumen += aktuellerWagon.getGesamtFrachtVolumen();
        }

        return gesamtFrachtVolumen;
    }

    private static Gueterwagon[] erzeugeWagons(int anzahl){
        Gueterwagon[] wagons = new Gueterwagon[anzahl];
        for(int i = 0; i < wagons.length; i++){
            wagons[i] = new Gueterwagon(1000 + i, "Kastenwagon", (byte)4);
        }
        return wagons;
    }

    private static Zuglokomotive erzeugeLokomotive() {
        return new Zuglokomotive(1234, "SuperLok", "Elektro", (byte)8);
    }

  @Override
  public String toString() {
    return "Gueterzug{" +
      "nummer=" + nummer +
      ", laenge=" + laenge +
      ", anzWagons=" + anzWagons +
      '}';
  }
}
