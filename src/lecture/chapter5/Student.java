package lecture.chapter5;

public class Student {

  private int studentId;
  private String name;

  public Student(int studentId, String name) {
    setStudentId(studentId);
    setName(name);
  }

  // Überladen: Signatur "float"
  public void drink(float amount){
    System.out.println(name + " trinkt " + amount + " l");
  }

  // Überladen: Signatur "float, float"
  public void drink(float amount, float percentageOfAlocohol){
    // System.out.println(name + " trinkt " + amount + " l und wird betrunken." );
    this.drink(amount);
    System.out.println("und wird betrunken.");
  }

  // Überladen: Signatur "float, boolean"
  public void drink(float amount, boolean poisened){
    this.drink(amount);
    if(poisened){
      System.out.println("und stirbt." );
    }
  }

  public void drink(float amountOfLiquid, float percentageOfAlcohol, boolean poisened ){
    this.drink(amountOfLiquid/2, percentageOfAlcohol);
    this.drink(amountOfLiquid/2, poisened);
  }

  // Signatur der Übergabeparameter muss sich unterschieden in: Anzahl, Typisierung UND / ODER Reihenfolge der Typisierung
  // Valide Signatur unterschiede zum Überladen:
  // float, float
  // float, double
  // double, float
  // int, double


  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
