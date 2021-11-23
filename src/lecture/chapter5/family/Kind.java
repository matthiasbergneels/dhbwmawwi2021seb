package lecture.chapter5.family;

public class Kind {

  private final Mann vater;
  private final Frau mutter;

  Kind(Mann vater, Frau mutter){
    if(vater != null){
      this.vater = vater;
    } else {
      // TODO: exception handling --> 2. Semester
      this.vater = new Mann();
    }

    if(mutter != null){
      this.mutter = mutter;
    } else {
      // TODO: exception handling --> 2. Semester
      this.mutter = new Frau();
    }

    // TODO: Kind bei Vater und Mutter setzen --> Kinder []
  }
}
