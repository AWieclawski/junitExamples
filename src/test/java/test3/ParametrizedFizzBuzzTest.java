package test3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import test2.FizzBuzz;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Parametric tests for Fizz Buzz")
public class ParametrizedFizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @DisplayName("Should return Fizz if number is divisible by three")
    @ParameterizedTest(name = "{index} - value {0}")
    @ValueSource(ints = {3, 6, 9, 99})
    public void verifyIfReturnsBuzzWhenDivisable3(int number) {
        String expectedResult = "Fizz!";
        String actualResult = fizzBuzz.play(number);
        assertEquals(expectedResult, actualResult);

    }


    @DisplayName("Should return Buzz if number is divisible by three")
    @ParameterizedTest(name = "{index} - value {0}")
    @MethodSource("dataProvider")
    public void shouldReturnBuzzWhenDivisableBy5(int number) {
        String expectedResult = "Buzz!";
        String actualResult = fizzBuzz.play(number);
        assertEquals(expectedResult, actualResult);

    }

    private static Stream<Integer> dataProvider(){
        return Stream.of(5,20,110,205,10000);
    }

}
