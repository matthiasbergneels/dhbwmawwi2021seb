package lecture.chapter7;

public interface Bookable {

  boolean bookSlots(int slotsToBook);
  int freeSlots();

  default boolean reserveSlots(int slotsToReserve){
    System.out.println("Reserve Methode im Interface!");
    return false;
  }

  default boolean priorityBooking(int slotsToBook){
    return false;
  }
}
