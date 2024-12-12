package validating;

public class Calculator {

    public int factorial(int number) {

        if (number >= 0) {
            int result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            return result;

        } else {
            throw new IllegalArgumentException("Factorial input must be non-negative.");
        }
    }

    public int binomialCoefficent(int setSize, int subsetSize) {

        if (setSize >= 0 && subsetSize >= 0 && subsetSize <= setSize) {

            int numerator = factorial(setSize);
            int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

            return numerator / denominator;

        } else {
            throw new IllegalArgumentException("Subset size must be between 0 and total items.");
        }
    }
}