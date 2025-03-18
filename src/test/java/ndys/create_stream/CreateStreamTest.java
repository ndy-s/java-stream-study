package ndys.create_stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    void testCreateEmptyOrSingleStream() {
        Stream<String> emptyStream = Stream.empty();

        Stream<String> singleStream = Stream.of("one");

        String data = null;
        Stream<String> emptyOrNotStream = Stream.ofNullable(data);
    }

    @Test
    void testCreateStreamFromArray() {
        // Variadic parameter
        Stream<String> streamString = Stream.of("one", "two", "three");
        Stream<Integer> streamInteger = Stream.of(1, 2, 3);

        Stream<String> streamArray = Arrays.stream(new String[]{"one", "two", "three"});

        // Stream can only consume once
        streamArray.forEach(System.out::println);
    }

    @Test
    void testCreateStreamFromCollection() {
        Collection<String> collection = List.of("Hendy", "Saputra");
        Stream<String> streamString = collection.stream();
        streamString.forEach(System.out::println);
    }

    @Test
    void testCreateInfiniteStream() {
        Stream<String> stream = Stream.generate(() -> "Ndy");
//        stream.forEach(System.out::println);

        // Add cumulative from previous return
        Stream<Integer> iterate = Stream.iterate(1, value -> value + 1);
        iterate.forEach(System.out::println);
    }
}
