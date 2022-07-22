package lecture.chapter13;

public class SortingAlgorithms {

  public static void main(String[] args) {

    int[] toSort = {50, 70, 100, 80, 40, 30, 20, 10 ,60};
    System.out.println("Unsortiert: ");
    printArray(toSort);


    System.out.println("Unsortierte Arrays:");
    System.out.println("===================");
    System.out.println("Bubble Sort V1 sortiert: ");
    int[] sorted = bubbleSortV1(toSort.clone());
    printArray(sorted);

    System.out.println("Bubble Sort V2 sortiert: ");
    sorted = bubbleSortV2(toSort.clone());
    printArray(sorted);

    System.out.println("Bubble Sort V3 sortiert: ");
    sorted = bubbleSortV3(toSort.clone());
    printArray(sorted);


    System.out.println("Sortierte Arrays:");
    System.out.println("=================");
    System.out.println("Bubble Sort V2 sortiert (auf Sortiertem Array): ");
    sorted = bubbleSortV2(sorted.clone());
    printArray(sorted);

    System.out.println("Bubble Sort V3 sortiert (auf Sortiertem Array): ");
    sorted = bubbleSortV3(sorted.clone());
    printArray(sorted);


  }


  public static int[] bubbleSortV1(int[] numbers){

    int swapCount = 0;
    long startTime = System.nanoTime();

    for(int i = numbers.length; i > 0; i--){
      for(int j = 0; j < numbers.length - 1; j++){
        if(numbers[j] > numbers[j+1]){
          // tauschen
          swap(numbers, j, j+1);
          swapCount++;
        }
      }
    }

    long stopTime = System.nanoTime();

    printRuntimeDuration("Bubble Sort V1", numbers.length, startTime, stopTime, swapCount);

    return numbers;
  }

  public static int[] bubbleSortV2(int[] numbers){

    int swapCount = 0;
    long startTime = System.nanoTime();

    for(int i = numbers.length; i > 0; i--){
      for(int j = 0; j < i - 1; j++){
        if(numbers[j] > numbers[j+1]){
          // tauschen
          swap(numbers, j, j+1);
          swapCount++;
        }
      }
    }

    long stopTime = System.nanoTime();
    printRuntimeDuration("Bubble Sort V2", numbers.length, startTime, stopTime, swapCount);

    return numbers;
  }

  public static int[] bubbleSortV3(int[] numbers){

    int swapCount = 0;

    long startTime = System.nanoTime();
    boolean swapped = false;

    for(int i = numbers.length; i > 0; i--){
      swapped = false;
      for(int j = 0; j < i - 1; j++){
        if(numbers[j] > numbers[j+1]){
          // tauschen
          swap(numbers, j, j+1);
          swapped = true;
          swapCount++;
        }
      }
      if(!swapped){
        break;
      }
    }

    long stopTime = System.nanoTime();
    printRuntimeDuration("Bubble Sort V3", numbers.length, startTime, stopTime, swapCount);

    return numbers;
  }

  private static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public static void printArray(int[] numbers){
    for(int number : numbers){
      System.out.print(number + ", ");
    }
    System.out.println();
  }

  private static void printRuntimeDuration(String algorithmName, int elementCount, long startTime, long endTime, int swapCount){
    long durationInNanoSeconds = endTime - startTime;
    long durationInMilliSeconds = (long) (durationInNanoSeconds / 10e5);

    System.out.println("Runtime for " + elementCount + " on " + algorithmName + ": " + durationInNanoSeconds + " ns (" + durationInMilliSeconds + " ms); swapped " + swapCount + " times");
  }
}
