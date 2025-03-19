package practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1Test {

    @Test
    void creatingAStream() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> stream = names.stream();

        stream.forEach(System.out::println);
    }

    @Test
    void filterOperation() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 0);

        stream.forEach(System.out::println);
    }

    @Test
    void mapOperation() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4)
                .stream()
                .map(n -> (int) Math.pow(n, 2))
                .toList();

        numbers.forEach(System.out::println);
    }

    @Test
    void reduceOperation() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println(sum);
    }

    @Test
    void sortOperation() {
        List<String> words = Arrays.asList("cat", "apple", "banana");
        Stream<String> stream = words.stream().sorted(Comparator.naturalOrder());

        stream.forEach(System.out::println);
    }

    @Test
    void combiningOperation() {
        List<Integer> numbers = Arrays.asList(10, 5, 8, 20, 15, 3);
        List<Integer> combinedList = numbers.stream()
                .filter(n -> n > 10)
                .map(n -> n * 2)
                .toList();

        System.out.println(combinedList);
    }

    @Test
    void countOperation() {
        List<String> fruits = Arrays.asList("apple", "banana", "pear", "kiwi");
        long count = fruits.stream().filter(str -> str.length() > 4).count();

        System.out.println(count);
    }
}
