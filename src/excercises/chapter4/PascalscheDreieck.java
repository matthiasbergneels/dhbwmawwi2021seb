package excercises.chapter4;

public class PascalscheDreieck {
    public static void main(String[] args) {
        final String PLATZHALTER = "\t";
        final int KLEINSTER_WERT = 1;

        int ebenen = 10;

        int[][] pyramide = new int[ebenen][];

        // Array fuer Pyramide vorbereiten
        for(int i = 0; i < ebenen; i++){
            pyramide[i] = new int[i+1];
            if(i == 0 || i == 1){
                for(int j = 0; j < pyramide[i].length; j++){
                    pyramide[i][j] = KLEINSTER_WERT;
                }
            }
        }

        // Pyramide füllen
        for(int i = 2; i < ebenen; i++){
            for(int j = 0; j < pyramide[i].length; j++){
                if(j == 0 || j == (pyramide[i].length - 1)){
                    pyramide[i][j] = KLEINSTER_WERT;
                }else{
                    pyramide[i][j] = pyramide[i-1][j] + pyramide[i-1][j-1];
                }
            }
        }

        // Pyramide ausgeben "einfach"!
        for(int[] ebene : pyramide){
            for(int zahl : ebene){
                System.out.print(zahl + " ");
            }
            System.out.println();
        }

        // Pyramide ausgeben "komplexer"
        for(int i = 0; i < ebenen; i++){
            for(int k = 0; k <= (ebenen - i); k++){
                System.out.print(PLATZHALTER);
            }
            for(int j = 0; j < pyramide[i].length; j++){

                System.out.print(PLATZHALTER + pyramide[i][j] + PLATZHALTER);
            }
            System.out.println();
        }
    }

}
