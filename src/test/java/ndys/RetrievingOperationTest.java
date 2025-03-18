package ndys;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RetrievingOperationTest {

    @Test
    void testLimit() {
        List<String> names = List.of("Hendy", "Saputra", "Hendy", "Joko");

        names.stream().limit(2).forEach(System.out::println);
    }

    @Test
    void testSkip() {
        List<String> names = List.of("Hendy", "Saputra", "Hendy", "Joko");

        names.stream().skip(2).forEach(System.out::println);
    }

    @Test
    void takeWhile() {
        List<String> names = List.of("Tono", "Saputra", "Hendy", "Joko");

        // Find and print while repeated true condition exist
        names.stream().takeWhile(name -> name.length() <= 4).forEach(System.out::println);
    }


    @Test
    void dropWhile() {
        List<String> names = List.of("Tono", "Saputra", "Hendy", "Joko");

        // Drop if repeated true condition exist
        names.stream().dropWhile(name -> name.length() <= 4).forEach(System.out::println);
    }

    @Test
    void testFindAny() {
        // Random select value
        List<String> names = List.of("Tono", "Saputra", "Hendy", "Joko");

        // Terminal operation (eager)
        Optional<String> optional = names.stream().findAny();
        optional.ifPresent(System.out::println);
    }

    @Test
    void testFindFirst() {
        List<String> names = List.of("Tono", "Saputra", "Hendy", "Joko");

        // Terminal operation (eager)
        Optional<String> optional = names.stream().findFirst();
        optional.ifPresent(System.out::println);
    }
}
