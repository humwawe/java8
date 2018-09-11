package stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * @author hum
 */
public class NumericStream {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Integer result = stream.filter(i -> i > 3).reduce(0, Integer::sum);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        IntStream intStream = stream.mapToInt(Integer::intValue);
        int result2 = intStream.filter(i -> i > 3).sum();
        System.out.println(result2);

        int a = 9;
        //1..1000
        //result int[a,b,c];
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));
        System.out.println("=======================");

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));
    }
}
