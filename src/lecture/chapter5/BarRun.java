package lecture.chapter5;

public class BarRun {

  public static void main(String[] args) {

    Student klaus = new Student(4711, "Klaus");
    Student gabi = new Student(4822, "Gabi");


    klaus.drink(1.0f);
    klaus.drink(0.33f, 5.5f);
    klaus.drink(0.1f, true);
  }
}
