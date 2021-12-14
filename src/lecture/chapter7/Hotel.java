package lecture.chapter7;

public class Hotel implements Bookable{

  private int roomCount;
  private int bookedRoomCount;

  public Hotel(int roomCount){
    this.roomCount = roomCount;
    this.bookedRoomCount = 0;
  }

  public void clean(){
    System.out.println("Die Zimmer im Hotel werden geputzt");
  }

  @Override
  public boolean bookSlots(int slotsToBook){
    if(slotsToBook <= freeSlots()){
      bookedRoomCount = bookedRoomCount + slotsToBook;
      return true;
    }

    return false;
  }

  @Override
  public int freeSlots(){
    return roomCount - bookedRoomCount;
  }

  @Override
  public boolean reserveSlots(int slotsToReserve){
    System.out.println("Reserve in Hotel!");
    return false;
  }

}
