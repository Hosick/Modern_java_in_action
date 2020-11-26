package part2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilteringExample {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        /** 프레디케이트(boolean을 반환하는 함수)로 필터링 **/
        List<Dish> vegatarianMenu =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());

        /** 고유 요소로 이루어진 스트림을 반환하는 distinct 메서드를 이용해서 필터링 **/
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
