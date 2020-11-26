package part2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MappingExample {
    public static void main(String[] args) {

        /** map 메서드를 이용해서 단어 길이로 매핑 **/
        List<String> words = Arrays.asList("Moder", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        /** 문자열 리스트를 고유 문자로 이루어진 리스트로 반환하기 **/
        words.stream()
                .map(word -> word.split(""))    //  Stream<String[]>으로 반환하기 때문에 의도와 다르다.
                .distinct()
                .collect(toList());

        /** flatMap 메서드를 이용하여 해결 (스트림 평면화) **/
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        /** 숫자 리스트의 각 숫자의 제곱 값으로 이루어진 리스트를 반환하는 스트림 연산 **/
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(toList());

        /** 두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하는 스트림 연산  **/
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());

        /** 위 예제의 숫자 쌍 중 합이 3으로 나누어 떨어지는 쌍만 반환하는 스트림 연산 **/
        List<int[]> correctPairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
    }
}
