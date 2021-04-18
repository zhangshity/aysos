package com.zcy.java1_8NewFunction._1__functional_interface;

import java.util.function.Predicate;

/**
 * @param <T> the type of the input to the predicate
 *
 * @FunctionalInterface
 * public interface Predicate<T> {
 */
public class PredicateTest {
    public static void main(String[] args) {
        /**
         * Evaluates this predicate on the given argument.
         *
         * @param t the input argument
         * @return {@code true} if the input argument matches the predicate,
         * otherwise {@code false}
         *
         * boolean test(T t);
         */

        // 1.================================================
        Predicate<String> predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                return o.equals("123");
            }
        };

        // 2.================================================
        Predicate<String> predicate_l = (o) -> {
            return o.equals("456");
        };


        System.out.println(predicate.test("123"));
        System.out.println(predicate_l.test("456"));
    }
}
