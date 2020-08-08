package part2;

import java.util.stream.Stream;

public class ParallelExample {
    //1부터 n까지의 모든 숫자의 합계를 반환하는 전통적인 반복문 방식의 함수
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++)
            result += i;
        return result;
    }

    // 1부터 n까지의 모든 숫자의 합계를 반환하는 스트림을 이용한 순차 리듀싱 방식의 함수
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)   //  iterate(초기값, 값을 변경시킬 람다 함수)
                .limit(n)
                .reduce(0L, Long::sum);       //  reduce(초기값, 각 요소의 계산 로직)
    }

    // 순차 스트림에 parallel 메서드를 호출해서 병렬 처리한 병렬 리듀싱 방식의 함수
    public long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(iterativeSum(10));
        System.out.println(sequentialSum(10));
    }
}
