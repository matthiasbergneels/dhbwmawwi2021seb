package lecture.chapter5;

public class Car {

    String color;
    short hp;
    String licensePlate;
    int currentSpeed;
    String brand;


    void accelerate(int accelerationSpeed){
      currentSpeed = currentSpeed + accelerationSpeed;
    }



    void brake(){
      currentSpeed = currentSpeed - 10;
      if(currentSpeed < 0){
        currentSpeed = 0;
      }
    }

    void fullBrake(){
      currentSpeed = 0;
    }


}
