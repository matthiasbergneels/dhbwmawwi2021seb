package lecture.chapter7;

public class TravelAgencyRun {

  public static void main(String[] args) {

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

      boolean booked = currentBookableEntity.bookSlots(50);

      System.out.println("Buchung erfolgreich? " + booked);
      System.out.println("Freie Plätze: " + currentBookableEntity.freeSlots());

      System.out.println(currentBookableEntity.toString());
    }

  }
}
