package ndys;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CreateStreamBuilderTest {

    @Test
    void testCreateStreamBuilder() {
        Stream.Builder<String> builder = Stream.builder();

        // Add data return void
        builder.accept("Hi");

        // Add data with chaining, return stream builder
        builder.add("Hello").add("World");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }

    @Test
    void testCreateStreamBuilderSimplify() {
        Stream<Object> stream = Stream.builder()
                .add("Hello")
                .add("World")
                .build();

        stream.forEach(System.out::println);
    }
}
