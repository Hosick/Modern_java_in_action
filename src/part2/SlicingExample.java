package part2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SlicingExample {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        /** takeWhile 을 이용해서 스트림을 슬라이싱 (320 칼로리보다 적은 dish 까지만 선택) **/
        List<Dish> sliceMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());

        /** dropWhile 을 이용해서 스트림을 슬라이싱 (320 칼로리보다 적지 않은 dish 까지 버림) **/
        List<Dish> sliceMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());

        /** limit 를 이용한 스트림 축소 **/
        List<Dish> sliceMenu3 = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

        /** skip 을 이용한 요소 건너뛰기 **/
        List<Dish> sliceMenu4 = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }
}
