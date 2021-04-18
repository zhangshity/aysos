package com.zcy.desgin_pattern.prototype;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:42 2018/12/12
 * @ Modified: By:
 */

public class MainDemo {

    public static void main(String[] args) {

        //加载缓存(把形状实例放入Hashtable)
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());

    }
}
