package com.zcy.desgin_pattern.prototype;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:08 2018/12/11
 * @ Modified: By:
 */

public class ShapeCache {


    private static Hashtable<String, Shape> shapeMap
            = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {

        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
    }


}
