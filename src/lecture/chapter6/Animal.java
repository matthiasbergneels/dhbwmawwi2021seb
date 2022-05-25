package lecture.chapter6;

public abstract class Animal {

  private float size;
  private String description;
  private float weight;


  public Animal(float size, String description, float weight) {
    setSize(size);
    setDescription(description);
    setWeight(weight);
  }

  public void eat(){
    System.out.println("Das Tier " + description + " frisst!");
  }

  public abstract void breath();

  public final void move(){
    System.out.println("Das Tier " + description + " bewegt sich!");
  }

  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  @Override
  public String toString(){
    return super.toString() + " - Description: " + description
                            + "; Größe: " + size
                            + "; Gewicht " + weight;
  }

  public boolean equals(Object o){
    // Alias-Vergleich
    if(this == o){
      return true;
    }

    // null-vergleich
    if(o == null){
      return false;
    }

    // Typ-Vergleich
    if(this.getClass() != o.getClass()){
      return false;
    }

    // Attribut-Vergleiche
    Animal equalsAnimal = (Animal) o;
    if(this.size != equalsAnimal.getSize()){
      return false;
    }

    if(!this.description.equals(equalsAnimal.getDescription())){
      return false;
    }

    if(this.weight != equalsAnimal.getWeight()){
      return false;
    }

    return true;
  };
}
