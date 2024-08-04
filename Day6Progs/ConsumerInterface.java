import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "this", "is", "aradhya");

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        strings.forEach(printUpperCase);
    }
}