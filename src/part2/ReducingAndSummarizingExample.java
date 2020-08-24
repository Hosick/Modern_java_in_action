package part2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ReducingAndSummarizingExample {
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

        /** counting 팩토리 메서드를 이용해서 개수를 계산 **/
        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes2 = menu.stream().count();    //  count 로 간단하게 표현이 가능하다.

        /** maxBy를 이용해서 최댓값 검색 **/
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));

        /** summing, averaging 을 이용해서 스트림에서 추출된 값의 합계, 평균 구하기 **/
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        double avgCalories = menu.stream().collect(averagingDouble(Dish::getCalories));

        /** summarizing 메서드를 이용해서 요약 연산 한번에 구하기 **/
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        /** joining 팩토리 메서드를 이용해서 문자열 합치기 **/
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);

        /** reducing 팩토리 메서드를 이용해서 범용 리듀싱 요약 연산 **/
        int totalCalories2 = menu.stream()
                .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        int totalCalories3 = menu.stream()  //  sum 메소드 참조를 이용해서 단순화
                .collect(reducing(0, Dish::getCalories, Integer::sum));

        /** 한 개의 인수를 갖는 reducing 함수 사용 **/
        Optional<Dish> mostCalorieDish2 = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        /** 컬렉터 대신 IntStream의 sum 메서드를 호출하는게 가장 편함 **/
        int totalCalories4 = menu.stream().mapToInt(Dish::getCalories).sum();
    }
}
