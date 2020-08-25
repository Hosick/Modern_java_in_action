package part2;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class PartitioningExample {
    public static void main(String[] args) {
        List<Dish> menu = asList(
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

        /** partitioningBy 메서드를 이용해서 분할하기 **/
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        List<Dish> vegetatianDishes = partitionedMenu.get(true);

        /** partitioningBy 메서드에 두 번째 인수로 컬렉터를 전달해서 분할하기 **/
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::getType)));

        /** partitioning 메서드에 두 번째 인수로 CollectingAndThen 으로 감싼 maxBy 전달해서 분할하기 **/
        Map<Boolean, Dish> mostCaloricPartitioninedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparing(Dish::getCalories)),
                                        Optional::get)));
    }
}
