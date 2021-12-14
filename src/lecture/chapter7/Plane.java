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
  public boolean bookSlots(int slotsToBook) {
    if(slotsToBook <= freeSlots()){
      for(int i = 0; i < seats.length; i++){
        if(!seats[i]){
          seats[i] = true;
          slotsToBook--;
        }

        if(slotsToBook == 0){
          return true;
        }
      }
    }

    return false;
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
