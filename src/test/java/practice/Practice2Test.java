package practice;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice2Test {

    /**
     * Grouping words by their first letter using Collectors.groupingBy.
     *
     * Task:
     * Given a list of words, group them into a Map where:
     * - The key is the first character of each word.
     * - The value is a list of words that start with that character.
     *
     * Example:
     * Input:  ["apple", "banana", "apricot", "cherry", "blueberry"]
     * Output: {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
     */
    @Test
    void groupingOperation() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "blueberry");

        Map<String, List<String>> group = words.stream()
                .collect(Collectors.groupingBy(word -> {
                    return String.valueOf(word.charAt(0));
                }));

        System.out.println(group);
    }

    /**
     * Custom collector to calculate the average of a list of integers.
     *
     * Task:
     * Given a list of numbers, use a custom collector to compute the average.
     * Hint: Use Collectors.averagingDouble() for simplicity.
     *
     * Example:
     * Input:  [1, 2, 3, 4, 5]
     * Output: 3.0
     */
    @Test
    void customCollectors() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Double average = numbers.stream()
                .collect(Collectors.averagingDouble(Double::valueOf));

        System.out.println(average);
    }

    /**
     * Flattening a nested list structure using flatMap and finding the maximum value.
     *
     * Task:
     * Given a list of lists, flatten it into a single list of integers and find the maximum.
     *
     * Example:
     * Input:  [[1, 2], [3, 4], [5, 6]]
     * Output: 6
     */
    @Test
    void nestedFlatMap() {
        List<List<Integer>> nested = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        Optional<Integer> max = nested.stream()
                .flatMap(Collection::stream)
                .max(Integer::compareTo);

        System.out.println(max);
    }

    /**
     * Comparing performance of sequential and parallel streams for summing even numbers.
     *
     * Task:
     * Given a large list of numbers from 1 to 1,000,000, use:
     * - A sequential stream to compute the sum of even numbers.
     * - A parallel stream to compute the sum of even numbers.
     * Compare execution times.
     *
     * Expected Output:
     * - Same sum for both methods.
     * - Parallel stream should (generally) be faster for large datasets.
     */
    @Test
    void parallelStream() {
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .toList();

        long startTime = System.nanoTime();
        int sequentialSum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        long endTime = System.nanoTime();
        long sequentialTime = endTime - startTime;

        startTime = System.nanoTime();
        int parallelSum = numbers.stream().parallel()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        endTime = System.nanoTime();
        long parallelTime = endTime - startTime;

        System.out.println("Sequential Sum: " + sequentialSum);
        System.out.println("Parallel Sum: " + parallelSum);
        System.out.println("Sequential Time: " + sequentialTime / 1_000_000.0 + " ms");
        System.out.println("Parallel Time: " + parallelTime / 1_000_000.0 + " ms");
    }

    /**
     * Parsing strings to integers and summing them using Stream and Optional.
     *
     * Task:
     * Given a list of strings, parse them to integers if possible.
     * Sum valid integers and return the result wrapped in an Optional.
     * If no valid integers exist, return Optional.empty().
     *
     * Example:
     * Input:  ["123", "abc", "456", "def"]
     * Output: Optional[579] (123 + 456)
     */
    @Test
    void streamWithOptional() {
        List<String> words = Arrays.asList("123", "abc", "456", "def");

        Optional<Integer> sum = words.stream()
                .map(str -> {
                    try {
                        return Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .reduce(Integer::sum);

        System.out.println(sum);
    }

    /**
     * Infinite Streams - Fibonacci Sequence
     *
     * Task:
     * - Use `Stream.iterate` to generate an infinite Fibonacci sequence.
     * - Limit the sequence to the first 10 numbers.
     * - Collect the results into a list.
     *
     * Expected Output:
     * [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
     */
    @Test
    void infiniteStreams() {
        List<Integer> fibonacciNumbers = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(10)
                .map(f -> f[0])
                .collect(Collectors.toList());

        System.out.println(fibonacciNumbers);
    }

    /**
     * Partitioning numbers into even and odd groups using Collectors.partitioningBy.
     *
     * Task:
     * Given a list of integers, partition them into:
     * - `true`: Even numbers
     * - `false`: Odd numbers
     *
     * Example:
     * Input:  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * Output: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
     */
    @Test
    void partitionWithPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> map = numbers.stream()
                .collect(Collectors.partitioningBy(n -> {
                    return n % 2 == 0;
                }));

        System.out.println(map);
    }

    /**
     * Complex Reduction with Multiple Conditions
     *
     * Task:
     * - Given a list of strings in the format `"name-quantity"`, compute the total quantity for each name.
     * - Return the result as a `Map<String, Integer>`.
     *
     * Example:
     * Input:  ["apple-2", "banana-5", "apple-3", "cherry-1"]
     * Output: {apple=5, banana=5, cherry=1}
     */
    @Test
    void reductionWithMultipleCondition() {
        List<String> items = Arrays.asList("apple-2", "banana-5", "apple-3", "cherry-1");

        Map<String, Integer> result = items.stream()
                .map(str -> str.split("-"))
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> Integer.parseInt(arr[1]),
                        Integer::sum
                ));

        System.out.println(result);
    }
}
