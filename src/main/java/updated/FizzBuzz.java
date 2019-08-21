package updated;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FizzBuzz {
    private static void fizzBuzzStage1(int num1, int num2) {
        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> i % num1 == 0 ? (i % num2 == 0 ? "FizzBuzz" : "Fizz") : (i % num2 == 0 ? "Buzz" : i))
                .forEach(System.out::println);
        System.out.println("--------------------------stage1---------------------");
    }

    private static void fizzBuzzStage2(int num1, int num2) {
        IntPredicate fizzPredicate = i -> (i % num1 == 0 || String.valueOf(i).chars().anyMatch(j -> j == (char) num1 + '0'));
        IntPredicate buzzPredicate = i -> (i % num2 == 0 || String.valueOf(i).chars().anyMatch(j -> j == (char) num2 + '0'));

        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> fizzPredicate.test(i) ? (buzzPredicate.test(i) ? "FizzBuzz" : "Fizz") : (buzzPredicate.test(i) ? "Buzz" : i))
                .forEach(System.out::println);
        System.out.println("--------------------------stage2---------------------");
    }

    public static void main(String[] args) {
        fizzBuzzStage1(3, 5);
        fizzBuzzStage2(3, 5);
    }
}
