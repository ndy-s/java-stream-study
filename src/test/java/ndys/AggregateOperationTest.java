package ndys;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AggregateOperationTest {

    @Test
    void testMax() {
        List<String> names = List.of("Hendy", "Saputra", "Program", "Java");

        Optional<String> max = names.stream().max(Comparator.naturalOrder());

        max.ifPresent(System.out::println);
    }

    @Test
    void testMin() {
        List<String> names = List.of("Hendy", "Saputra", "Program", "Java");

        Optional<String> min = names.stream().min(Comparator.naturalOrder());

        min.ifPresent(System.out::println);
    }

    @Test
    void testCount() {
        List<String> names = List.of("Hendy", "Saputra", "Program", "Java");

        long count = names.stream().count();
        System.out.println(count);
    }

    @Test
    void testSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Reduce to aggregate manually
        Integer sum = numbers.stream().reduce(0, (result, item) -> result + item);

        System.out.println(sum);
    }

    @Test
    void testFactorial() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Integer factorial = numbers.stream().reduce(1, (result, item) -> result * item);

        System.out.println(factorial);
    }
}
