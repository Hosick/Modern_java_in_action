package part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LoopExample {
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

        /** 컬렉션: for-each 루프를 이용하는 외부 반복 **/
        List<String> names1 = new ArrayList<>();
        for (Dish dish : menu) {
            names1.add(dish.getName());
        }

        /** 컬렉션: 내부적으로 숨겨졌던 반복자를 사용한 외부 반복 **/
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()){
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }

        /** 스트림: 내부반복 **/
        List<String> names3 =
                menu.stream()
                        .map(Dish::getName)
                        .collect(toList());
    }
}
