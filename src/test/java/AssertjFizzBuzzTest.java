import org.junit.jupiter.api.Test;
import test2.FizzBuzz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AssertjFizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void shouldReturnFizzWhen3() {
        assertThat(fizzBuzz.play(3))
                .overridingErrorMessage("Something went wrong!")
                .isEqualTo("Fizz!")
                .isNotEmpty()
                .isNotBlank()
                .isNotEmpty();
    }

    @Test
    public void shouldReturnBuzzWhen5() {

        assertThat(fizzBuzz.play(5)).isEqualTo("Buzz!");
    }

    @Test
    public void shouldReturnFizzBuzzWhen15() {

        assertThat(fizzBuzz.play(15)).isEqualTo("FizzBuzz!");
    }

    @Test
    public void shouldReturnStringNumberWhen1() {

        assertThat(fizzBuzz.play(1)).isEqualTo("1");
    }

    @Test
    public void shouldThrowExceptionForNegative(){
        int number=-1;
        assertThatThrownBy(()->fizzBuzz.play(number))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Number cannot be equal 0 or negative");
    }

}
