package ndys;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TransformationOperationTest {

    @Test
    void testMap() {
        // Map Stream<T> to Stream<U>
        List.of("Hendy", "Saputra").stream()
                .map(name -> name.toUpperCase())
                .map(upper -> upper.length())
                .forEach(length -> System.out.println(length));
    }

    @Test
    void testFlatMap() {
        List.of("Hendy", "Saputra").stream()
                .map(name -> name.toUpperCase())
                .flatMap(upper -> Stream.of(upper, upper.length()))
                .forEach(
                        value -> System.out.println(value)
                );
    }
}
