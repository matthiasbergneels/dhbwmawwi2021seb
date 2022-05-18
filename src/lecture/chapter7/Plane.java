package lecture.chapter7;

public class Plane implements Bookable{

  private boolean[] seats; // --> false = free seat, true = booked seat

  public Plane(int numberOfSeats){
    seats = new boolean[numberOfSeats];
  }

  public void fly(){
    System.out.println("Und ich flieg, flieg, flieg... *sing*");
  }


  @Override
  public void bookSlots(int slotsToBook) throws NotEnoughFreeSlotsException {
    if(slotsToBook > freeSlots()) {
      throw new NotEnoughFreeSlotsException(freeSlots(), slotsToBook);
    }

      for(int i = 0; i < seats.length; i++){
        if(!seats[i]){
          seats[i] = true;
          slotsToBook--;
        }

        if(slotsToBook == 0){
          return;
        }
      }

  }

  @Override
  public int freeSlots() {
    int freeSlots = 0;
    for(boolean seat : seats){
      if(!seat){
        freeSlots++;
      }
    }

    return freeSlots;
  }
}
