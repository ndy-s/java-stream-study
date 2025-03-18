package ndys;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationTest {

    @Test
    void testAnyMatch() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Terminal operation (eager)
        boolean match = numbers.stream().anyMatch(number -> number > 20);

        System.out.println(match);
    }

    @Test
    void testAllMatch() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        boolean match = numbers.stream().allMatch(number -> number < 20);

        System.out.println(match);
    }

    @Test
    void testNoneMatch() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        boolean match = numbers.stream().noneMatch(number -> number > 10);

        System.out.println(match);
    }
}
