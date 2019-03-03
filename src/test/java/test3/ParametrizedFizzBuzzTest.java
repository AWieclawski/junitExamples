package test3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
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


    @DisplayName("Should return Buzz if number is divisible by five")
    @ParameterizedTest(name = "{index} - value {0}")
    @MethodSource("dataProvider")
    public void shouldReturnBuzzWhenDivisableBy5(int number) {
        String expectedResult = "Buzz!";
        String actualResult = fizzBuzz.play(number);
        assertEquals(expectedResult, actualResult);

    }

    private static Stream<Integer> dataProvider() {
        return Stream.of(5, 20, 110, 205, 10000);
    }

    @DisplayName("Should return expected value")
    @ParameterizedTest(name = "{index} - for {0} should return {1}")
    @MethodSource("argumentsProvider")
    public void shouldReturnExpectedValue(int number, String expectedResult) {
//        String expectedResult = "Buzz!";
        String actualResult = fizzBuzz.play(number);
        assertEquals(expectedResult, actualResult);

    }

    private static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.arguments(1, "1"),
                Arguments.arguments(3, "Fizz!"),
                Arguments.arguments(5, "Buzz!"),
                Arguments.arguments(15, "FizzBuzz!")
        );
    }

    @DisplayName("Should return expected value from CSV")
    @ParameterizedTest(name = "{index} - for {0} should return {1}")
    @CsvFileSource(resources = "/test_data.csv",numLinesToSkip = 1)
    public void shouldReturnExpectedValueFormCSV(int number, String expectedResult) {
        String actualResult = fizzBuzz.play(number);
        assertEquals(expectedResult, actualResult);

    }

}
