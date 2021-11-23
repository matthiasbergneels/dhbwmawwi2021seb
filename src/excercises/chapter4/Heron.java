package excercises.chapter4;

public class Heron {

    public static void main(String[] args) {

        double startValue = 24;
        double interimSolutionA = startValue;
        double interimSolutionB = 0;

        do{
            if(interimSolutionB != 0){
                interimSolutionA = interimSolutionB;
            }
            interimSolutionB = (interimSolutionA + startValue / interimSolutionA) / 2;
            System.out.println("Zwischenergebnis: " + interimSolutionB);

        }while((interimSolutionA - interimSolutionB) > 0.00001);

        System.out.println("Die Wurzel aus " + startValue + " ist ca. " + interimSolutionB);






    }
}
