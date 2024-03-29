package java8new;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("java", "scala", "python", "shelll");
//        String a = "dsdfjs";
//        a.startsWith("d");
//        long num = list.parallelStream().filter(x -> x.length() < 5).count();
//        System.out.println(num);
//        Stream<Integer> sortedStream = Stream.of(1, 2, 23, 3, 4, 2, 55, 32, 12, 3).sorted();
////        sortedStream.forEach(x->System.out.print_rectangle(x+" "));
//        sortedStream.forEach(System.out::print);

        Predicate<Integer> p1 = (i) -> i > 5;
        Predicate<Integer> p2 = (i) -> i < 5;
        Predicate p = p1.or(p2);
        System.out.println(p.test(3));
    }
}
