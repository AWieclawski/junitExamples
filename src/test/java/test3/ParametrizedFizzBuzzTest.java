package test3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test2.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Parametric tests for Fizz Buzz")
public class ParametrizedFizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest(name = "{index} - shouldbe divisible by {0}")
    @ValueSource(ints = {3, 6, 9, 99})
    public void verifyIfReturnsBuzzWhenDivisable3(int number) {
        String expectedResult = "Fizz!";
        String actualResult = fizzBuzz.play(number);
        assertEquals(expectedResult, actualResult);

    }

}
