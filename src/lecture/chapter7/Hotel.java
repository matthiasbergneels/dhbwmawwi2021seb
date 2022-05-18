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
  public void bookSlots(int slotsToBook) throws NotEnoughFreeSlotsException{
    if(slotsToBook > freeSlots()){
      throw new NotEnoughFreeSlotsException(freeSlots(), slotsToBook);
    }

    if(slotsToBook == 10){
      throw new NullPointerException();
    }

    bookedRoomCount = bookedRoomCount + slotsToBook;
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
