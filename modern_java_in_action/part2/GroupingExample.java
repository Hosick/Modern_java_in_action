package part2;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class GroupingExample {
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

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));


        /** grupingBy 팩토리 메서드를 이용해서 이름별로 그룹화 **/
        Map<Dish.Type, List<Dish>> dishByType =
                menu.stream().collect(groupingBy(Dish::getType));

        /** 메서드 참조 대신 람다 표현식을 이용하여 분류 기준이 복잡한 상황에서의 그룹화 **/
        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }));

        /** filtering 함수를 이용해서 필터를 groupingBy 인자로 받기 **/
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));

        /** mapping 함수를 이용해서 groupingBy 안에서 매핑하기 **/
        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        mapping(Dish::getName, toList())));

        /** flatMapping 함수를 이용해서 groupingBy 안에서 평면화해서 중복태그 제거하기 **/
        Map<Dish.Type, Set<String>> dishNamesByType2 =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));

        /** groupingBy 함수 내에 컬렉터를 groupingBy로 받아서 2수준 그룹화 구현하기 **/
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400)
                                        return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700)
                                        return Dish.CaloricLevel.NORMAL;
                                    else
                                        return Dish.CaloricLevel.FAT;
                                })
                        )
                );

        /** groupingBy에 컬렉터로 counting 을 전달해서 음식의 종류별로 요리 수를 계산하기 **/
        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));

        /** groupingBy에 컬렉터로 maxBy 를 전달해서 음식의 종료별 가장 높은 칼로리의 음식을 찾기 **/
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =  //  요리가 없는 Key는 맵에 추가되지 않으므로 굳이 Optional 래퍼를 사용 할 필요는 없음
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));

        /** collctingAndThen 팩토리 메서드로 변환 함수를 감싸서 Optional 값을 String으로 변환 **/
        Map<Dish.Type, Dish> mostCaloricByType2 =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get
                                )));

    }
}
