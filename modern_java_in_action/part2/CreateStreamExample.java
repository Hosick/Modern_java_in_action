package part2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamExample {
    public static void main(String[] args) {

        /** 값으로 스트림 만들기 **/
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        Stream<String> emptyStream = Stream.empty();

        /** null이 될 수 있는 객체로 스트림 만들기 **/
        Stream<String> homeValueStream
                = Stream.ofNullable(System.getProperty("home"));
        Stream<String> values =
                Stream.of("config", "home", "user")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        /** 배열로 스트림 만들기 **/
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        /** 파일로 스트림 만들기 **/
        long unisqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            unisqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
        }

        /** 함수로 무한 스트림 만들기 **/
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})  //  피보나치 수열 출력
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        IntStream.iterate(0, n -> n < 100, n -> n + 4)  //  iterate 에 프레디케이트를 사용해서 중단
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
