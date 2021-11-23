package excercises.chapter4;

public class Ungerade {
    public static void main(String[] args) {


        int og = 10;

        if(args.length == 1){
            og = Integer.parseInt(args[0]);
        }

        System.out.println("Ungerade Zahlen bis " + og + ":");

        System.out.println("While Schleife:");
        System.out.println("===============");
        int counter = 0;
        while(counter <= og){
            if(counter % 2 != 0){
                System.out.print(counter + " ");
            }
            counter++;
        }

        System.out.println("\n\nDo-While Schleife:");
        System.out.println("===============");
        counter = 0;
        do{
            if(counter % 2 != 0){
                System.out.print(counter + " ");
            }
            counter++;
        }while(counter <= og);


        System.out.println("\n\nFor Schleife Alternative 1:");
        System.out.println("===============");

        for(int i = 1; i <= og; i++){
            if(i % 2 != 0){
                System.out.print(i + " ");
            }
        }

        System.out.println("\n\nFor Schleife Alternative 2:");
        System.out.println("===============");

        for(int i = 1; i <= og; i = i + 2){
            System.out.print(i + " ");
        }

        System.out.println("\n\nFor Schleife Alternative 3:");
        System.out.println("===============");

        for(int i = 1; i <= og; i++){

            double zwerg = (double)i / 2;
            double zwerg2 = (int)(i / 2);
            if(zwerg != zwerg2){
                System.out.print(i + " ");
            }
        }

    }
}