package excercises.chapter9;

public class Kunde implements Comparable<Kunde>{

    private String name;
    private String vorname;
    private int kundenNummer;

    public Kunde(String name, String vorname, int kundenNummer){
        this.setName(name);
        this.setVorname(vorname);
        this.setKundenNummer(kundenNummer);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public int getKundenNummer() {
        return kundenNummer;
    }
    public void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    @Override
    public int compareTo(Kunde o) {
        return this.getKundenNummer() - o.getKundenNummer();
    }

    @Override
    public String toString() {
        return "Kunden#: " + this.getKundenNummer() + ", Name: " + this.getName() + ", " + this.getVorname();
    }

    @Override
    public boolean equals(Object obj) {

        // Alias Check
        if(this == obj){
            return true;
        }

        // Null Check
        if(obj == null){
            return false;
        }

        // Type Check
        if (!(obj.getClass().equals(this.getClass()))) {
            return false;
        }

        // Attribute Check
        // Passend zu compareTo() Methode werden nur dort relevante Attribute verglichen
        Kunde kunde = (Kunde)obj;

        if(this.getKundenNummer() != kunde.getKundenNummer()){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int hashCode = 0;

        // Passend zu equals() werden nur dort relevante Attribute zur Erzeugung des HashCode verwendet
        hashCode = this.getKundenNummer();

        return hashCode;
    }
}
