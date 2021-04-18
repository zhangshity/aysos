package com.zcy.java1_8NewFunction._1__functional_interface;

import java.util.function.Supplier;

/**
 * @param <T> the type of results supplied by this supplier
 *
 * @FunctionalInterface
 * public interface Supplier<T> {
 */
public class SupplierTest {
    public static void main(String[] args) {

        /**
         * Gets a result.
         *
         * @return a result
         *
         * T get();
         */

        // 1.================================================
        Supplier<String> supplier = new Supplier() {
            @Override
            public Object get() {
                return "Supplier interface: get() - @Override";
            }
        };


        // 2.================================================
        Supplier<String> supplier_l = () -> "Supplier interface: get() - lambda";


        System.out.println(supplier.get());
        System.out.println(supplier_l.get());
    }
}
