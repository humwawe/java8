package collector;

import lambda.Apple;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


/**
 * @author hum
 */
public class CollectorIntroduce {
    private static Map<String, List<Apple>> groupByNormal(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple a : apples) {
            List<Apple> list = map.get(a.getColor());
            if (null == list) {
                list = new ArrayList<>();
                map.put(a.getColor(), list);
            }
            list.add(a);
        }
        return map;
    }

    private static Map<String, List<Apple>> groupByNormal1(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple a : apples) {
            List<Apple> list = map.computeIfAbsent(a.getColor(), k -> new ArrayList<>());
            list.add(a);
        }
        return map;
    }

    private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        // parallelStream 每次执行结果不一致
        apples.parallelStream().forEach(a -> {
            List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                map.put(a.getColor(), list);
                return list;
            });
            colorList.add(a);
        });
        return map;
    }

    private static Map<String, List<Apple>> groupByCollector(List<Apple> apples) {
        return apples.parallelStream().collect(groupingBy(Apple::getColor));
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 1)
                , new Apple("yellow", 2)
                , new Apple("green", 3)
                , new Apple("green", 4)
                , new Apple("yellow", 5)
                , new Apple("green", 6));

        List<Apple> greenList = list.stream().filter(a -> "green".equals(a.getColor())).collect(Collectors.toList());
        Optional.ofNullable(greenList).ifPresent(System.out::println);

        System.out.println("===================================================");
        Optional.ofNullable(groupByNormal(list)).ifPresent(System.out::println);
        Optional.ofNullable(groupByNormal1(list)).ifPresent(System.out::println);

        System.out.println("===================================================");
        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);

        System.out.println("===================================================");
        Optional.ofNullable(groupByCollector(list)).ifPresent(System.out::println);
    }


}