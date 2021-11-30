package lecture.chapter5;

import java.util.GregorianCalendar;

public class ParakingGarage {

  private Car[] parkingLots;

  public ParakingGarage(int numberOfParkingLots){
    parkingLots = new Car[numberOfParkingLots];
  }

  public int parkCar(Car car){
    for(int i = 0; i < parkingLots.length; i++){
      if(parkingLots[i] == null){
        parkingLots[i] = car;
        return i;
      }
    }
    return -1;
  }

  public Car getCarFromParkingLot(int lotNumber){
    Car car = parkingLots[lotNumber];
    parkingLots[lotNumber] = null;
    return car;
  }
}
