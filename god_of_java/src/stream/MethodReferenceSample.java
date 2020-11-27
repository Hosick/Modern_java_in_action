package stream;

import java.util.Arrays;

public class MethodReferenceSample {
    public static void main(String[] args) {
        MethodReferenceSample sample = new MethodReferenceSample();
        String[] stringArray = new String[]{"요다", "만두", "건빵"};
        sample.staticReference(stringArray);
    }

    private static void printResult(String value) {
        System.out.println(value);
    }

    public void staticReference(String[] stringArray) {
        Arrays.stream(stringArray)
                .forEach(MethodReferenceSample::printResult);
    }
}
