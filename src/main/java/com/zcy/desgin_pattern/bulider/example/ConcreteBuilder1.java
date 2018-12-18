package com.zcy.desgin_pattern.bulider.example;

import com.zcy.desgin_pattern.bulider.example.Builder;

/**
 * 此处实现了建造纯文本文档的具体建造者。
 * 可以考虑再实现一个建造HTML文档、XML文档，或者其它什么文档的具体建造者。
 * 这样，就可以使得同样的构建过程可以创建不同的表示
 */
public class ConcreteBuilder1 extends Builder {

    private StringBuffer buffer = new StringBuffer();//假设 buffer.toString() 就是最终生成的产品

    @Override
    public void buildPart1() {//实现构建最终实例需要的所有方法
        buffer.append("Builder1 : Part1\n");
    }

    @Override
    public void buildPart2() {
        buffer.append("Builder1 : Part2\n");
    }

    @Override
    public void buildPart3() {
        buffer.append("Builder1 : Part3\n");
    }

    public String getResult() {//定义获取最终生成实例的方法
        return buffer.toString();
    }
}
