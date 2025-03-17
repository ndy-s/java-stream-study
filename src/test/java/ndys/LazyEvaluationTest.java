package ndys;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationTest {

    @Test
    void testIntermediateOperations() {
        Stream<String> names = List.of("Hendy", "Saputra").stream();

        // Intermediate operation (cold start/lazy)
        Stream<String> upperNames = names.map(name -> {
            System.out.println("Change " + name + " to UPPERCASE");
            return name.toUpperCase();
        });

        // Terminal operations (eager)
        upperNames.forEach(upperName -> {
            System.out.println("Print Name: " + upperName);
        });
    }
}
