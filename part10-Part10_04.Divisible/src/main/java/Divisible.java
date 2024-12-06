
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Divisible {
    
    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                result.add(num);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(-17);
        numbers.add(-5);
        numbers.add(7);

        ArrayList<Integer> divisible = divisible(numbers);

        divisible.stream()
                .forEach(luku -> System.out.println(luku));
    }

}
