package fizzbuzz.model;

import java.util.function.Predicate;

public enum PredicateFactory {
    instance;

    public Predicate<Integer> multipleOf(int multiplicand) {
        return i -> i % multiplicand == 0;
    }

    public Predicate<Integer> mutipleOfOrHasChar(int multiplicand, char hasChar) {
        Predicate<Integer> predicate = i -> {
            String str = i.toString();
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (hasChar == c)
                    return true;
            }
            return false;
        };

        return multipleOf(multiplicand).or(predicate);
    }
}
