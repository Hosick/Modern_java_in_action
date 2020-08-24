package part2;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStreamExample {
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

        /** mapToInt 메서드를 이용해서 int형 특화 스트림으로 매핑 **/
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        /** boxed 메서드를 이용해서 숫자 스트림을 객체 스트림으로 복원 **/
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        /** OptionalInt 클래스와 max을 이용해서 최대값 요소를 찾기 **/
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1); // orElse 를 이용해 명시적으로 other 값을 정해줄 수도 있다.

        /** range, rangeClosed로 범위 내 숫자 생성하고 짝수의 개수세기 **/
        IntStream evanNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evanNumbers.count());

        /** 숫자 스트림 활용 : 피타고라스 수 **/
        Stream<double[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, (int) Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                        );
        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}