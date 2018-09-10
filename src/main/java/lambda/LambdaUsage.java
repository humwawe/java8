package lambda;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * @author hum
 */
public class LambdaUsage {

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a)) {
                result.add(a);
            }
        }
        return result;

    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a.getWeight())) {
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a.getColor(), a.getWeight())) {
                result.add(a);
            }
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple a : source) {
            consumer.accept(a);
        }
    }

    private static void simpleBiConsumer(String c, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple a : source) {
            consumer.accept(a, c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> fun) {
        return fun.apply(apple);
    }

    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> fun) {
        return fun.apply(color, weight);
    }

    private static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 150));

        List<Apple> greenList = filter(list, (apple) -> "green".equals(apple.getColor()));
        System.out.println(greenList);

        List<Apple> result = filterByWeight(list, w -> w > 100);
        System.out.println(result);

        List<Apple> result2 = filterByBiPredicate(list, (s, w) -> "green".equals(s) && w > 100);
        System.out.println(result2);

        System.out.println("================");
        simpleTestConsumer(list, a -> System.out.println(a));

        System.out.println("================");
        simpleBiConsumer("XXX: ", list, (a, s) -> System.out.println(s + a.getColor() + ":Weight=>" + a.getWeight()));

        System.out.println("================");
        String result3 = testFunction(new Apple("yellow", 100), (a) -> a.toString());
        System.out.println(result3);

        IntFunction<Double> f = i -> i * 100.0d;
        double result4 = f.apply(10);
        System.out.println("================");
        System.out.println(result4);

        System.out.println("================");
        Apple a = testBiFunction("Blue", 130, (s, w) -> new Apple(s, w));
        System.out.println(a);

        System.out.println("================");
        Apple a2 = createApple(() -> new Apple("Green", 100));
        System.out.println(a2);


    }


}
