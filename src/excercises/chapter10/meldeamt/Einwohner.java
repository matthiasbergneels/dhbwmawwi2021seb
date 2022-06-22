package excercises.chapter10.meldeamt;

import java.io.Serializable;
import java.util.ResourceBundle;

public class Einwohner implements Comparable<Einwohner>, Serializable {

    public static final long serialVersionUID = 2L;

    private static final String RESSOURCE_IDENTIFIER_UILABELS = "excercises.chapter10.meldeamt.i18n.uilabels";

    enum Title {
        MRS, MR, DIVERS;

        @Override
        public String toString() {
            ResourceBundle uiLabelBundle = ResourceBundle.getBundle(RESSOURCE_IDENTIFIER_UILABELS);
            switch (this){
                case MR:
                    return uiLabelBundle.getString("valuehelp_title_mr");
                case MRS:
                    return uiLabelBundle.getString("valuehelp_title_mrs");
                case DIVERS:
                    return uiLabelBundle.getString("valuehelp_title_divers");
            }
            return null;
        }
    }


    public static final String FAMILIENSTAND_LEDIG = "ledig";
    public static final String FAMILIENSTAND_VERHEIRATET = "verheiratet";
    public static final String FAMILIENSTAND_VERWITWET = "verwitwet";
    public static final String FAMILIENSTAND_GESCHIEDEN = "geschieden";


    private String name;
    private String vorname;
    private String gebName;
    private String email;
    private Title anrede;
    private String familienstand;


    public Einwohner (String name, String vorname, String gebName, String email, Title anrede, String familienstand){
        this.setName(name);
        this.setVorname(vorname);
        this.setGebName(gebName);
        this.setEmail(email);
        this.setAnrede(anrede);
        this.setFamilienstand(familienstand);
    }


    @Override
    public int compareTo(Einwohner o) {
        int comp = this.getName().compareTo(o.getName());
        if(comp == 0){
            comp = this.getVorname().compareTo(o.getVorname());
        }

        return comp;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){ return true; }
        if(o == null){ return false; }
        if(this.getClass() != o.getClass()){ return false; }

        Einwohner e = (Einwohner)o;

        if(!this.getName().equals(e.getName())){ return false; }
        if(!this.getVorname().equals(e.getVorname())){ return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() ^ this.getVorname().hashCode();
    }

    @Override
    public String toString() {
        return this.getAnrede() + " "
                + this.getVorname() + " "
                + this.getName()
                + (this.getGebName() != null ? " (" + this.getGebName() +  ")" : "" ) + ";\t "
                + "EMail: " + this.getEmail()
                + "\tFamilienstand: " + this.getFamilienstand();
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

    public String getGebName() {
        return gebName;
    }

    public void setGebName(String gebName) {
        this.gebName = gebName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Title getAnrede() {
        return anrede;
    }

    public void setAnrede(Title anrede) {
        this.anrede = anrede;
    }

    public String getFamilienstand() {
        return familienstand;
    }

    public void setFamilienstand(String familienstand) {
        this.familienstand = familienstand;
    }

}
