package com.zcy.java1_8NewFunction._1__functional_interface;

import java.util.function.Function;


/**
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 *
 * @FunctionalInterface
 * public interface Function<T, R> {
 */
public class FunctionTest {
    public static void main(String[] args) {

        /**
         * Applies this function to the given argument.
         *
         * @param t the function argument
         * @return the function result
         *
         * R apply(T t);
         */

        // 1.================================================
        Function<String, String> function = new Function() {
            @Override
            public Object apply(Object o) {
                return "Function interface: apply() - @Override " + o;
            }
        };

        // 2.================================================
        Function<String, String> function_l = (o) -> {
            return "Function interface: apply() - lambda " + o;
        };


        System.out.println(function.apply("123"));
        System.out.println(function_l.apply("456"));
    }
}

