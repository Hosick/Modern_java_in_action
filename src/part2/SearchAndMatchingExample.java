package part2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchAndMatchingExample {
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

        /** anyMatch 메서드를 이용하여 요소가 하나라도 참인지 확인 **/
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        /** allMatch 메서드를 이용하여 요소가 모두 참인지 확인 **/
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        /** noneMatch 메서드를 이용하여 요소가 모두 거짓인지 확인 **/
        boolean isHealthy2 = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);

        /** findAny 메서드를 이용해서 스트림에서 임의의 요소를 반환 **/
        Optional<Dish> dish =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();

        /** findFirst 메서드를 이용해서 스트림에서 첫번째 요소를 반환 **/
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(n -> n * n)
                        .filter(n -> n % 3 == 0)
                        .findFirst();   //  9
    }
}