package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class NumberProcessor {
    public static void main(String[] args) {
        // Assume we have a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        // Print even numbers
        System.out.println("Even numbers: " + evenNumbers);
    }
}
