
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int input = Integer.parseInt(scanner.nextLine());
            if (input < 0) {
                break;
            }
            if (input >= 1 && input <= 5) {
                numbers.add(input);
            }
        }

        numbers.forEach(System.out::println);
    }
}
