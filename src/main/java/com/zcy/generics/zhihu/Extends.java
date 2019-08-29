package com.zcy.generics.zhihu;

import java.util.List;

public class Extends {

    /**
     * 泛型 无通配符
     *
     * @param animals
     * @return
     */
    static int countLegs(List<Animal> animals) {

        int counter = 0;
        for (Animal animal : animals) {
            counter = animal.hashCode();
        }
        return counter;
    }

    /**
     * 泛型 <? extends Animal>
     *
     * @param animals
     * @return
     */
    static int countLegs2(List<? extends Animal> animals) {
        int counter = 0;
        for (Animal animal : animals) {
            counter = animal.hashCode();
        }
        return counter;
    }


    public static void main(String[] args) {

    }
}
