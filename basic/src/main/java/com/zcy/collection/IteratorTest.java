package com.zcy.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IteratorTest {
    public static void main(String[] args) {
        //Java编译器并不知道如何遍历List。上述代码能够编译通过，只是因为编译器把for each循环通过Iterator改写为了普通的for循环：
        ReverseList<String> list = new ReverseList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String s : list) {
            System.out.println(s); // 3 2 1
        }

    }
}


class ReverseList<T> implements Iterable<T> {

    private final List<T> FINAL_LIST = new ArrayList<>();

    public void add(T t) {
        FINAL_LIST.add(t);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index = FINAL_LIST.size();

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public Object next() {
                index--;
                return FINAL_LIST.get(index);
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}

