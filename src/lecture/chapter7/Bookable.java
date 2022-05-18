package lecture.chapter7;

public interface Bookable {

  void bookSlots(int slotsToBook) throws NotEnoughFreeSlotsException, NullPointerException;
  int freeSlots();

  default boolean reserveSlots(int slotsToReserve){
    System.out.println("Reserve Methode im Interface!");
    return false;
  }

  default boolean priorityBooking(int slotsToBook){
    return false;
  }
}
