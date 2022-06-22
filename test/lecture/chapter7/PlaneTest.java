package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaneTest {

  Plane testPlane;

  @BeforeEach
  void setup(){
    testPlane = new Plane(100);
  }

  @Test
  void bookSlotsSuccessfull() {
    Assertions.assertDoesNotThrow(() -> {
        testPlane.bookSlots(99);
      }
      );
  }

  @Test
  void bookSlotsException() {

    NotEnoughFreeSlotsException testException = Assertions.assertThrows(NotEnoughFreeSlotsException.class, () -> {
      testPlane.bookSlots(101);
    });

    Assertions.assertEquals("Es wurde versucht 101 zu buchen. Es sind aber nur 100 frei!", testException.getMessage());
    Assertions.assertEquals(100, testException.getFreeSlots());

  }
}