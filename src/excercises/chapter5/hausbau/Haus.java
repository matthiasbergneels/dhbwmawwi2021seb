package excercises.chapter5.hausbau;

public class Haus {
    final static private int DEFAULT_TUEREN = 1;
    final static private int DEFAULT_FENSTER = 1;
    final static private int DEFAULT_ETAGEN = 1;
    final static private int DEFAULT_FLAECHE = 100;
    final static private String DEFAULT_STRASSE = "Coblitzallee";
    final static private String DEFAULT_HAUSNUMMER = "7";
    final static private int DEFAULT_PLZ = 69782;
    final static private String DEFAULT_ORT = "Mannheim";

    private int tueren;
    private int fenster;
    private int etagen;
    private int flaeche;
    private String strasse;
    private String hausnummer;
    private int plz;
    private String ort;
    private boolean flachdach;

    private static int objCnt = 0;


    public Haus(){
        this(0, 0, 0, 0, null, null, 0, null, false);
    }

    public Haus (int tueren, int fenster, int etagen, int flaeche, String strasse, String hausnummer, int plz, String ort, boolean flachdach){
        this.setEtagen(etagen);
        this.setFenster(fenster);
        this.setTueren(tueren);
        this.setFlaeche(flaeche);
        this.setStrasse(strasse);
        this.setHausnummer(hausnummer);
        this.setPlz(plz);
        this.setOrt(ort);
        this.setFlachdach(flachdach);

        objCnt++;
    }

    // Effective Java (2. Auflage) --> (static) factory methods
    public static Haus baueHausMitTüren(int tueren){
      return new Haus(tueren, DEFAULT_FENSTER, DEFAULT_ETAGEN, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
    }

  public static Haus baueHausMitFenstern(int fenster){
    return new Haus(DEFAULT_TUEREN, fenster, DEFAULT_ETAGEN, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  public static Haus baueHausMitEtagen(int etagen){
    return new Haus(DEFAULT_TUEREN, DEFAULT_FENSTER, etagen, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  public static Haus baueHausMitFentserUndTueren(int fenster, int tueren){
    return new Haus(tueren, fenster, DEFAULT_ETAGEN, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  // Konstruktoren

    // Nach den Vorschriften des Überladens ist es nicht möglich für jedes einzelne Attribut einen Konstruktor zu erzeugen!
    public Haus(int tueren){
        this(tueren, 0, 0, 0, null, null, 0, null, false);
    }

    public Haus(boolean flachdach){
        this(0, 0, 0, 0, null, null, 0, null, flachdach);
    }

    public Haus(String strasse, String hausnummer, int plz, String ort){
        this(0, 0, 0, 0, strasse, hausnummer, plz, ort, false);
    }

  public Haus(String strasse){
    this(strasse, null, 0, null);
  }

    public Haus(int tueren, int fenster, int etagen, int flaeche, boolean flachdach){
        this(tueren, fenster, etagen, flaeche, null, null, 0, null, flachdach);
    }






    public int getTueren() {
        return tueren;
    }
    public void setTueren(int tueren) {
        this.tueren = istNegativ(tueren) ? DEFAULT_TUEREN : tueren;
    }
    public int getFenster() {
        return fenster;
    }
    public void setFenster(int fenster) {
        this.fenster = istNegativ(fenster) ? DEFAULT_FENSTER : fenster;
    }
    public int getEtagen() {
        return etagen;
    }
    public void setEtagen(int etagen) {
        this.etagen = istNegativ(etagen) ? DEFAULT_ETAGEN : etagen;
    }
    public int getFlaeche() {
        return flaeche;
    }
    public void setFlaeche(int flaeche) {
        if(flaeche >= 100 && flaeche <= 500){
            this.flaeche = flaeche;
        }else{
            this.flaeche = DEFAULT_FLAECHE;
        }

    }
    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = isEmptyOrDefault(strasse, DEFAULT_STRASSE);
    }
    public String getHausnummer() {
        return hausnummer;
    }
    public void setHausnummer(String hausnummer) {
        this.hausnummer = isEmptyOrDefault(hausnummer, DEFAULT_HAUSNUMMER);;
    }
    public int getPlz() {
        return plz;
    }
    public void setPlz(int plz) {
        this.plz = istNegativ(plz) ? DEFAULT_PLZ : plz;
    }
    public String getOrt() {
        return ort;
    }
    public void setOrt(String ort) {
        this.ort = isEmptyOrDefault(ort, DEFAULT_ORT);
    }
    public boolean isFlachdach() {
        return flachdach;
    }
    public void setFlachdach(boolean flachdach) {
        this.flachdach = flachdach;
    }

    private boolean istNegativ(int zahl){
        return (zahl > 0) ? false : true;
    }

    private String isEmptyOrDefault(String pruefen, String defaultString){
        return (pruefen == null || pruefen.isEmpty()) ? defaultString : pruefen;
    }


    @Override
    public String toString() {
        return "Hausinformationen: "
                + "Etagen: " + getEtagen() + "; "
                + "Tueren: " + getTueren() + "; "
                + "Fenster: " + getFenster() + "; "
                + "Flaeche: " + getFlaeche() + "qm; "
                + "Flachdach: " + (isFlachdach() ? "ja" : "nein") + "; "
                + "Adresse: " + getStrasse() + " " + getHausnummer() + ", " + getPlz() + " " + getOrt()
                ;
    }




    @Override
    protected void finalize(){
        objCnt--;
    }

    public static int getObjCnt() {
        return objCnt;
    }


}
