package lecture.excursion.unittest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  Calculator testCalculator;

  @BeforeEach
  void setup(){
    System.out.println("Before Each outerclass");
    testCalculator = new Calculator();
  }

  @AfterEach
  void tearDown(){
    System.out.println("After Each outerclass");
    testCalculator = null;
  }

  @Nested
  @DisplayName("Test cases for add method")
  class addTestCases{

    @BeforeEach
    void setup(){
      System.out.println("Before Each inner add class");
      testCalculator = new Calculator();
    }

    @AfterEach
    void tearDown(){
      System.out.println("After Each inner add class");
      testCalculator = null;
    }

    @Test
    @DisplayName("Add integer numbers")
    void add() {
      double result = testCalculator.add(5, 5);
      Assertions.assertEquals(10, result);
    }

    @Test
    @DisplayName("Add double numbers")
    void addDoubleNumbers() {
      double result = testCalculator.add(5.0, 5.0);
      Assertions.assertEquals(10.0, result);
    }

    @Test
    @DisplayName("Add big double numbers")
    void addBigDoubleNumbers() {
      double result = testCalculator.add(50000000000000.0, 10.0);
      Assertions.assertEquals(50000000000010.0, result);
    }
  }


  @ParameterizedTest(name = "{0} minus {1} should result in {2}")
  @DisplayName("Subtract test cases")
  @CsvSource({
    "5.0, 3.0, 2.0",
    "10, 11, -1",
    "50000, -50000, 100000"
  })
  void subtract(double numberA, double numberB, double expectedResult) {
    double result = testCalculator.subtract(numberA, numberB);

    Assertions.assertEquals(expectedResult, result);
  }

  @Test
  void multiply() {
  }

  @Test
  void divide() {
  }
}