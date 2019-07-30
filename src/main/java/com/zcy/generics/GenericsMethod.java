package com.zcy.generics;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《泛型方法测试》
 * @ Date: Created in 10:22 2019-07-23
 * @ Modified: By:
 */
public class GenericsMethod {

    /**
     * 泛型方法
     *
     * @param array
     * @param <E>
     */
    //【1】所有'泛型方法声明'都有一个<类型参数声明部分>(由尖括号分隔),
    // 该<类型参数声明部分>在方法'返回类型'之前（在下面例子中的<E>）。
    private static <E> void printArray(E[] array) {
        //foreach遍历数组
        for (E e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    //【2】每一个<类型参数声明部分>包含一个或多个类型参数，参数间用逗号隔开。
    // 一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。

    //【3】<类型参数>能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。


    /**
     * 测试主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        //创建不同类型数组

        //【4】泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）
//        int[] intArray = {1, 2, 3, 4, 5};
//        double[] doubleArray = {1.1, 1.2, 3.3, 5.7};
//        char[] charArray = {'H', 'E', 'l', 'L', 'O'};
//        printArray(intArray); //编译不过
//        printArray(doubleArray); //编译不过
//        printArray(charArray); //编译不过

        Integer[] integersArray = {1, 2, 3, 4, 5};
        Double[] doublesArray = {1.1, 1.2, 3.3, 5.7};
        Character[] charactersArray = {'H', 'E', 'l', 'L', 'O'};
        printArray(integersArray);
        printArray(doublesArray);
        printArray(charactersArray);
    }








}
