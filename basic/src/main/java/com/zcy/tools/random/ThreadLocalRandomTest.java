package com.zcy.tools.random;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    public static void main(String[] args) {

        int i = ThreadLocalRandom.current().nextInt(100);
        System.out.println(i);
    }
}
