package lecture.chapter7;

public class NotEnoughFreeSlotsException extends Exception {

  private int freeSlots;

  public NotEnoughFreeSlotsException(int freeSlots, int bookedSlots){
    super("Es wurde versucht " + bookedSlots + " zu buchen. Es sind aber nur " + freeSlots + " frei!") ;
    this.freeSlots = freeSlots;
  }

  public int getFreeSlots(){
    return freeSlots;
  }
}
