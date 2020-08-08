package part2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;

public class ReducingExample {
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

        /** counting 컬렉터를 이용해서 menu의 요소 개수를 선택 **/
        long howManyDishes = menu.stream().count();
        System.out.println(howManyDishes);

        /** Comparator 를 인수로 받는 maxBy 컬렉터를 이용해서 칼로리가 가장 높은 dish 를 선택 **/
        Comparator<Dish> dishCaroriesComparator =
                Comparator.comparing(Dish::getCalories);
        Optional<Dish> mostCalorieDish =    //  menu가 비어있을 경우를 위해 Optional 로 처리
                menu.stream()
                        .collect(maxBy(dishCaroriesComparator));
        System.out.println(mostCalorieDish.get().getName());
    }
}
