package part2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ActualPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /** 2011년에 일어난 모든 트랜잭션을 찾아 값을 오른차순으로 정리하시오. **/
        List<Transaction> trade11 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(trade11.toString());

        /** 거래자가 근무하는 모든 도시를 중복없이 나열하시오. **/
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(cities.toString());

        /** 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오. **/
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);

        /** 모든 거래자의 이름을 알파벳으로 정렬해서 변환하시오. **/
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println(traderStr);

        /** 밀라노에 거래자가 있는가? **/
        boolean millanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Millan"));
        System.out.println(millanBased);

        /** 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오. **/
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        /** 전체 트랜잭션 중 최대값은 얼마인가? **/
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue);

        /** 전체 트랜잭션 중 최솟값은 얼마인가? **/
        Optional<Transaction> smallestTransaction = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println(smallestTransaction);
    }
}