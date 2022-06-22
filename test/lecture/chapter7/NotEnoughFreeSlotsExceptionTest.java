package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotEnoughFreeSlotsExceptionTest {


  @Test
  void ExceptionClassCreationTest(){
    NotEnoughFreeSlotsException testException =
          new NotEnoughFreeSlotsException(10, 100);

    Assertions.assertEquals("Es wurde versucht 100 zu buchen. Es sind aber nur 10 frei!", testException.getMessage());
    Assertions.assertEquals(10, testException.getFreeSlots());

  }

  @Test
  void getFreeSlots() {
  }
}