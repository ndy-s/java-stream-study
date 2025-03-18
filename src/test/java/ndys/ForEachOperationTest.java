package ndys;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class ForEachOperationTest {

    @Test
    void testPeek() {
        List<String> names = List.of("Hendy", "Saputra");

        // Peek return stream (lazy)
        Stream<String> stream = names.stream()
                .map(name -> name.toUpperCase())
                .peek(upper -> System.out.println("Upper Name: " + upper));

        stream.forEach(System.out::println);
    }
}
