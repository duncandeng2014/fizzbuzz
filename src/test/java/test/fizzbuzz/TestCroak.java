package test.fizzbuzz;

import fizzbuzz.Constants;
import fizzbuzz.model.Croak;
import fizzbuzz.model.ICroak;
import fizzbuzz.model.PredicateFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;


public class TestCroak {
    @Test
    public void testSay() {
        ICroak croak = new Croak();

        Predicate<Integer> fizzPredicate1 = PredicateFactory.instance.multipleOf(3);
        Predicate<Integer> buzzPredicate1 = PredicateFactory.instance.multipleOf(5);
        for (int i = 1; i <= 100; i ++) {
            System.out.println(croak.say(i, fizzPredicate1, buzzPredicate1));
        }
        System.out.println("--------------stage 1----------------\n");

        Predicate<Integer> fizzPredicate2 = PredicateFactory.instance.mutipleOfOrHasChar(3, '3');
        Predicate<Integer> buzzPredicate2 = PredicateFactory.instance.mutipleOfOrHasChar(5, '5');
        for (int i = 1; i <= 100; i ++) {
            System.out.println(croak.say(i, fizzPredicate2, buzzPredicate2));
        }
        System.out.println("--------------stage 2----------------\n");

        int i = 3;
        String result = croak.say(i, fizzPredicate1, buzzPredicate1);
        Assert.assertEquals(Constants.FIZZ, result);
        i = 50;
        result = croak.say(i, fizzPredicate1, buzzPredicate1);
        Assert.assertEquals(Constants.BUZZ, result);
        i = 15;
        result = croak.say(i, fizzPredicate1, buzzPredicate1);
        Assert.assertEquals(Constants.FIZZ_BUZZ, result);
        i = 37;
        result = croak.say(i, fizzPredicate1, buzzPredicate1);
        Assert.assertEquals(String.valueOf(i), result);
        System.out.println("--------------stage 1 test----------------\n");

        i = 23;
        result = croak.say(i, fizzPredicate2, buzzPredicate2);
        Assert.assertEquals(Constants.FIZZ, result);
        i = 5;
        result = croak.say(i, fizzPredicate2, buzzPredicate2);
        Assert.assertEquals(Constants.BUZZ, result);
        i = 90;
        result = croak.say(i, fizzPredicate2, buzzPredicate2);
        Assert.assertEquals(Constants.FIZZ_BUZZ, result);
        i = 71;
        result = croak.say(i, fizzPredicate2, buzzPredicate2);
        Assert.assertEquals(String.valueOf(i), result);
        System.out.println("--------------stage 2 test----------------\n");


    }
}
