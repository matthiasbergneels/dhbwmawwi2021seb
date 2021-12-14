package excercises.chapter5.bahnhof;

import java.util.Calendar;
import java.util.Date;

public class Zugfuehrer {
    private Gueterzug zug;

    private String Name;
    private String Vorname;
    private int id;
    private Date gebDate;

    public Zugfuehrer(String name, String vorname, int id, Date gebDate){
        this.setName(vorname);
        this.setVorname(vorname);
        this.setId(id);
        this.setGebDate(gebDate);
    }

    public Gueterzug getZug() {
        return zug;
    }

    public void setZug(Gueterzug zug) {
        if(zug != null){
            zug.setFahrer(null);
        }
        this.zug = zug;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  public Date getGebDate() {
    return gebDate;
  }

  public void setGebDate(Date gebDate) {
      // muss mindestens 18 Jahre alt sein
      Calendar expectedMinBirthDate = Calendar.getInstance();
      expectedMinBirthDate.add(Calendar.YEAR, -18);

      Calendar actualBirthDate = Calendar.getInstance();
      actualBirthDate.setTime(gebDate);

      if(actualBirthDate.before(expectedMinBirthDate)){
        this.gebDate = gebDate;
      }
  }

  @Override
  public String toString() {
    return "Zugfuehrer{" +
      "Name='" + Name + '\'' +
      ", Vorname='" + Vorname + '\'' +
      ", id=" + id +
      ", gebDate=" + gebDate +
      '}';
  }
}
