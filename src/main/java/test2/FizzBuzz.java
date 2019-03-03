package test2;

public class FizzBuzz {

    public static String play(int number) {

        if (number <= 0) {
            throw new ArithmeticException("Number cannot be equal 0 or negative");
        }

        String result = Integer.toString(number);

        if (number % 3 == 0) {
            result = "Fizz!";
        }

        if (number % 5 == 0) {
            result = "Buzz!";
        }

        if (number % 3 == 0 && number % 5 == 0) {
            result = "FizzBuzz!";
        }

        return result;
    }

}
