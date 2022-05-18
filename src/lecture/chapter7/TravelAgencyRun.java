package lecture.chapter7;

public class TravelAgencyRun {

  public static void main(String[] args){

    Bookable[] bookableEntities = new Bookable[5];

    // Narrowing Cast --> Sichbarkeit auf die "Fähigkeiten" von Bookable eingeschränkt
    bookableEntities[0] = new Plane(100);
    bookableEntities[1] = new Hotel(250);
    bookableEntities[2] = new Hotel(10);
    bookableEntities[3] = new Plane(500);
    bookableEntities[4] = new Plane(200);


    for(Bookable currentBookableEntity : bookableEntities){
      // Polymorphie durch Interfaces

      System.out.println("Freie Plätze: " + currentBookableEntity.freeSlots());

      try {
        int slotsToBook = 110;
        currentBookableEntity.bookSlots(slotsToBook);
        System.out.println("Buchung erfolgreich - " + slotsToBook + " gebucht!");
      } catch(NotEnoughFreeSlotsException e){
        System.out.println(e.getMessage());
        System.out.println("Wir buchen die verbleibenden Plätze");

        try{
          currentBookableEntity.bookSlots(e.getFreeSlots());
        }catch(NotEnoughFreeSlotsException missingSlotsException){
          System.out.println("Jetzt ist es sinnlos!");
        } catch(NullPointerException nullPointerException){
          System.out.println("Jetzt ist alles im Eimer!");
          return;
        }

      }  finally {
        System.out.println("Ich laufe immer!!");
      }

      //System.out.println("Buchung erfolgreich? " + booked);
      System.out.println("Freie Plätze: " + currentBookableEntity.freeSlots());

      System.out.println(currentBookableEntity.toString());

      System.out.println(currentBookableEntity.reserveSlots(100));

      if(currentBookableEntity instanceof Plane){
        // widening Cast --> Sichbarkeit erweitern
        Plane myPlane = (Plane)currentBookableEntity;
        myPlane.fly();
      }

    }

  }
}
