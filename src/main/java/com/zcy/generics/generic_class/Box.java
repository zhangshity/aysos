package com.zcy.generics.generic_class;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>泛型类测试</>
 * @ Date: Created in 14:06 2019/8/29
 * @ Modified: By:
 */
public class Box<T> {

    private T t;

    public void put(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }


    public static void main(String[] args) {
        Box box = new Box();
        Box<String> stringBox = new Box<>();
        Box<Integer> integerBox = new Box<>();

        box.put("asasd" + 123);
        stringBox.put("StringBox");
        integerBox.put(123);

        System.out.println("box: " + box.get());
        System.out.println("stringBox " + stringBox.get());
        System.out.println("integerBox " + integerBox.get());

    }

}
