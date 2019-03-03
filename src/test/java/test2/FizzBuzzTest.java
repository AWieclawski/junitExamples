package test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {


    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Should return Fizz for number divisible by 3")
    public void checkForFizz() {

        int test = 3;

        String result = FizzBuzz.play(test);

        assertEquals(result, "Fizz!");

    }

    @Test
    @DisplayName("Should return Buzz for number divisible by 5")
    public void checkForBuzz() {

        int test = 5;

        String result = FizzBuzz.play(test);

        assertEquals(result, "Buzz!");

    }

    @Test
    @DisplayName("Should return FizzBuzz for number divisible by 15")
    public void checkForFizzBuzz() {

        int test = 3 * 5;

        String result = FizzBuzz.play(test);

        assertEquals(result, "FizzBuzz!");

    }

    @Test
    @DisplayName("Should return the String of the number if it is not divisible by 5 or 3")
    public void checkForNumberToStringItSelf() {

        int test = 2;

        String result = FizzBuzz.play(test);

        assertEquals(result, Integer.toString(test));

    }

    @Test
    @DisplayName("Should thrown the Exception for the number 0 or lower")
    public void shouldThrowExceptionForNumberEqualsSero() {

        final int test = 0;

        Assertions.assertThrows(ArithmeticException.class, () -> FizzBuzz.play(test));

    }

}