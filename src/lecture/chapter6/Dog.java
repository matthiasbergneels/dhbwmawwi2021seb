package lecture.chapter6;

public final class Dog extends Animal{

  private String breed;

  public Dog(float size, String description, float weight, String breed){
    super(size, description, weight);
    setBreed(breed);
  }

  // Überschreiben der Methode aus Animal
  @Override
  public void eat(){
    System.out.println("Der Hund " + getDescription() + " frisst Fleisch...");
  }

  // Überladen der Methode eat aus Animal
  public void eat(float amountOfMeat){
    eat();
    System.out.println("und zwar " + amountOfMeat + " Gramm!");
  }

  @Override
  public void breath(){
    System.out.println("Der Hund " + getDescription() + " atmet! (Wie ein Hund)");
  }

  public void bark(){
    System.out.println("Der Hund " + getDescription() + " bellt! *wuff*");
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  @Override
  public String toString(){
    return super.toString()
          + "; Rasse: " + breed;
  }
}
