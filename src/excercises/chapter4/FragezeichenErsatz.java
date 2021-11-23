package excercises.chapter4;

public class FragezeichenErsatz {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        // Aufgabenstellung: Ersetzen
        boolean erg = (a==b) ? false : true;

        // Lösung 1:
        erg = !(a==b);
        // Lösung 2:
        erg = a!=b;

        erg = a > b ^ b > a;

        erg = operator(a, b);

        /* Nicht erlaubte Lösung (nach Aufgabenstellung)
        if(a==b){
            erg = false;
        }else{
            erg = true;
        }

        */
    }

    public static boolean operator(int a, int b){
        // Ersetzen: return (a==b) ? false : true;
        return !(a==b);
    }


}
