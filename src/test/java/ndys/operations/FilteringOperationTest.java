package ndys.operations;

import org.junit.jupiter.api.Test;

import java.util.List;

public class FilteringOperationTest {

    @Test
    void testFilter() {
        List<String> names = List.of("Hendy", "Saputra", "Saputra", "Ly");
        names.stream().filter(name -> name.length() > 3).forEach(System.out::println);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
    }

    @Test
    void testDistinct() {
        List<String> names = List.of("Hendy", "Saputra", "Saputra", "Ly");

        names.stream().distinct().forEach(System.out::println);
    }
}
