package chapter2.exercises.e2_12;

import common.Function;

public class Exercise2_12 {

    static int factorialMethod(int n){
        return n == 0 ? 1 : n * factorialMethod(n-1);
    }

    static Function<Integer, Integer> factorial;
    static {
        factorial = x -> x == 0 ? 1 : x * factorial.apply(x - 1);
    }
}
