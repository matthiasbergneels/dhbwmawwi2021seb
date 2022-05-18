package lecture.chapter7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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