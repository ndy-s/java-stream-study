package ndys.collectors;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByTest {

    @Test
    void testPartitioningBy() {
        // Return boolean
        Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.partitioningBy(number -> {
                    return number > 5;
                }));

        System.out.println(collect);
    }

    @Test
    void testPartitioningBy2() {
        Map<Boolean, List<String>> map = Stream.of("Hendy", "Saputra", "Java")
                .collect(Collectors.partitioningBy(name -> {
                    return name.length() > 4;
                }));

        System.out.println(map);
    }
}
