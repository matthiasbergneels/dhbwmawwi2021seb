package lecture.chapter6;

public class Bird extends Animal {

  private boolean canFly;

  public Bird(float size, String description, float weight, boolean canFly){
    super(size, description, weight);
    setCanFly(canFly);
  }

  public void tweet(){
    System.out.println("Der Vogel " + this.getDescription() + " zwitschert! *piep*");
  }

  @Override
  public void eat(){
    super.eat();
    System.out.println(" in dem Körner gepickt werden");
  }

  @Override
  public void breath(){
    System.out.println("Der Vogel " + getDescription() + " atmet! (Wie ein Vogel)");
  }

  public boolean canFly() {
    return canFly;
  }

  public void setCanFly(boolean canFly) {
    this.canFly = canFly;
  }


  public boolean equals(Object o){
    // Alias-Vergleich
    if(this == o){
      return true;
    }

    // Delegation an Super-Klasse
    if(!super.equals(o)){
      return false;
    }

    // Attribut-Vergleich
    Bird equalsBird = (Bird)o;

    if(!this.canFly != equalsBird.canFly()){
      return false;
    }

    return true;
  };
}

