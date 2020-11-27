package lamda.functional;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        PredicateExample sample = new PredicateExample();

        Predicate<String> predicateLength5 = (a -> a.length() > 5);
        Predicate<String> predicateContains = (a -> a.contains("God"));
        Predicate<String> predicateStart = (a -> a.startsWith("God"));

        String godofjava = "GodOfJava";
        String goodJava = "GoodJava";

        sample.predicateTest(predicateLength5, godofjava);
        sample.predicateTest(predicateLength5, goodJava);

        sample.predicateNegate(predicateLength5, godofjava);
        sample.predicateNegate(predicateLength5, goodJava);

        sample.predicateAnd(predicateLength5, predicateContains, godofjava);
        sample.predicateAnd(predicateLength5, predicateContains, goodJava);

        sample.predicateOr(predicateLength5, predicateContains, godofjava);
        sample.predicateOr(predicateLength5, predicateContains, goodJava);
    }

    private void predicateTest(Predicate<String> p, String data) {
        System.out.println(p.test(data));
    }

    private void predicateAnd(Predicate<String> p1, Predicate<String> p2, String data) {
        System.out.println(p1.and(p2).test(data));
    }

    private void predicateOr(Predicate<String> p1, Predicate<String> p2, String data) {
        System.out.println(p1.or(p2).test(data));
    }

    private void predicateNegate(Predicate<String> p, String data) {
        System.out.println(p.negate().test(data));
    }
}