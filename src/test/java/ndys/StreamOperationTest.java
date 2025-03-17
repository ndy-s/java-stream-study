package ndys;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationTest {

    @Test
    void testMapStream() {
        // Recommended using stream pipeline
        List<String> names = List.of("Hendy", "Saputra");

        // Names is immutable, stream create new transformed data
        Stream<String> streamNames = names.stream();
        Stream<String> streamUpper = streamNames.map(String::toUpperCase);

        streamUpper.forEach(System.out::println);
        names.forEach(System.out::println);
    }
}
