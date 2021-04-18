package com.zcy.java1_8NewFunction._1__functional_interface;

import java.util.function.Consumer;

/**
 *  @param <T> the type of the input to the operation
 *
 * @FunctionalInterface
 * public interface Consumer<T> {
 */
public class ConsumerTest {
    public static void main(String[] args) {

        /**
         * Performs this operation on the given argument.
         *
         * @param t the input argument
         *
         * void accept(T t);
         */


        // 1.================================================
        Consumer<String> consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("Consumer interface: accept() - @Override " + o);
            }
        };

        // 2.================================================
        Consumer<String> consumer_l = (o) -> {
            System.out.println("Consumer interface: accept() - lambda " + o);
        };


        consumer.accept("123");
        consumer_l.accept("456");
    }
}
