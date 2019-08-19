package fizzbuzz.model;

import fizzbuzz.Constants;

import java.util.function.Predicate;

public interface ICroak<T extends Number> {

    default String say(T number, Predicate<T> fizzPredicate, Predicate<T> buzzPredicate) {
        if (fizzPredicate.and(buzzPredicate).test(number))
            return Constants.FIZZ_BUZZ;
        else if (fizzPredicate.test(number))
            return Constants.FIZZ;
        else if (buzzPredicate.test(number))
            return Constants.BUZZ;
        else
            return String.valueOf(number);
    }
}
