package ndys;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamPipelineTest {

    @Test
    void testCreateStreamPipeline() {
        List.of("Hendy", "Saputra").stream()
                .map(String::toUpperCase)
                .map(value -> "Mr. " + value)
                .forEach(System.out::println);
    }
}
