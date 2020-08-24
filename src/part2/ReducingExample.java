package part2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReducingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

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

        /** reduce 메서드를 이용해서 요소의 합 구하기 **/
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        sum = numbers.stream().reduce(0, Integer::sum); //  메서드 참조를 이용해서 간결하게 표현
        Optional<Integer> optionalSum = numbers.stream().reduce(Integer::sum);  //  초깃값을 받지 않고 Optinal 객체 반환도 가능

        /** reduce 메서드를 이용해서 최대값과 최소값 구하기 **/
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        /** map, reduce 메서드를 이용해서 스트림의 요리 개수 계산하기 **/
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        long count2 = menu.stream().count();    //  count로 스트림 요소 세기
    }
}
