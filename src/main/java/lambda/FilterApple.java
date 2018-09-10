package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class FilterApple {
    public static List<Apple> findApple(List<Apple> apples, AppleFilterI appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd160WeightFilterI implements AppleFilterI {
        @Override
        public boolean filter(Apple apple) {
            return ("green".equals(apple.getColor()) && apple.getWeight() >= 160);
        }
    }

    public static class YellowLess150WeightFilterI implements AppleFilterI {
        @Override
        public boolean filter(Apple apple) {
            return ("yellow".equals(apple.getColor()) && apple.getWeight() < 150);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));

        List<Apple> result = findApple(list, new GreenAnd160WeightFilterI());
        System.out.println(result);

        List<Apple> yellowList = findApple(list, new AppleFilterI() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });
        System.out.println(yellowList);

        List<Apple> lambdaResult = findApple(list, apple -> "green".equals(apple.getColor()));
        System.out.println(lambdaResult);

    }

}
