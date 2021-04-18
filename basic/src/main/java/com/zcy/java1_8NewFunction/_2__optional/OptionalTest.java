package com.zcy.java1_8NewFunction._2__optional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * 关于Java1.8新功能Optional的测试
 */
public class OptionalTest {

    /**
     * 自定义静态方法控制台打印参数值,并返回参数值
     * @param s
     * @return
     */
    private static String fetch(String s) {
        System.out.println("SupplierTest()内部实现方法: 参数:" + s + "   ：~~已执行~~");
        return s;
    }



    public static void main(String[] args) {

        /**
         * 定义:
         * Optional 为Java1.8提供的一个包装类,结构很简单,就一个<T>泛型成员变量value存储值。
         * private构造函数,常用初始化静态方法: of() ofNullable() empty() ,顾名思义为赋值(),赋可为空的值(),赋空值()
         */
        Integer i = 10;

        Integer i1 = Optional.of(i).get();
        System.out.println(i1);

        Integer i2 = Optional.ofNullable(i).get();
        System.out.println(i2);

        //Object o3 = Optional.empty().get();  //Exception in thread "main" java.util.NoSuchElementException: No value present
        //System.out.println(o3);              //	at java.util.Optional.get(Optional.java:135)
        //	at com.com.zcy.java1_8NewFunction.optional.OptionalTest.main(OptionalTest.java:18)



        //================= 常用方法 orElse() 和 orElseGet() 测试 =================
        /**
         * 附区别帖子
         * https://stackoverflow.com/questions/33170109/difference-between-optional-orelse-and-optional-orelseget#
         *
         * orElse(T other)无论前面Optional容器是null还是non-null，都会执行orElse里的方法，
         * orElseGet(SupplierTest<? extends T> other)并不会，只有Optional容器是null才会执行orElseGet中的方法
         *
         * 如果service无异常抛出的情况下，Optional使用orElse或者orElseGet的返回结果都是一样的
         *
         *
         * 差异的主要原因就在于参数里的Supplier接口,
         * ！！## (只有消费了才会调用, 消费动作对应源码里的三目运算符最后一项,即Optional为空,才去消费,不为空不消费故不会调用)
         */
        System.out.println("================= 常用方法 orElse() 和 orElseGet() 测试 =================");
        String s = "nonNull value";
        //String s = null;

        String s1 = Optional.ofNullable(s).orElse(OptionalTest.fetch("other value"));
        System.out.println(s1);

        String s2 = Optional.ofNullable(s).orElseGet(() -> OptionalTest.fetch("other value lambda")); //@FunctionalInterface lambda表达式写法
        System.out.println(s2);

        String s3 = Optional.ofNullable(s).orElseGet(new Supplier<String>() { //1.8前旧式接口重写写法(与上面的lambda无区别，参考理解)
            @Override
            public String get() {
                //return "other value override";
                return OptionalTest.fetch("other value override");
            }
        });
        System.out.println(s3);





        // Optional.xx.orElseGet()结合lambda表达式理解
        System.out.println("============== Optional.xx.orElseGet()结合lambda表达式理解 ==============");
        Map<String, String> map = new HashMap() {{
            put("aa", "aainfo");
            put("bb", "puxxy?");
        }};
        String ss1 = Optional.ofNullable(map.get("cc")).orElseGet(() -> map.get("bb")); //@FunctionalInterface lambda表达式写法
        System.out.println(ss1);

        String ss2 = Optional.ofNullable(map.get("cc")).orElseGet(new Supplier<String>() { //1.8前旧式接口重写写法(与上面的lambda无区别，参考理解)
            @Override
            public String get() {
                return map.get("bb");
            }
        });
        System.out.println(ss2);







        //================================== map 显示三目运算符 ==================================
        System.out.println("================================== map 显示三目运算符 ==================================");

        //String amount = "12.98";
        String amount = null;
        BigDecimal amountDecimal = Optional.ofNullable(amount).map(BigDecimal::new).orElse(null);

        System.out.println(amountDecimal);












        //================================== filter 运算 ==================================
        System.out.println("================================== filter 运算 ==================================");
        //int affectedRows = 0;
        int affectedRows = 1;
        int result = Optional.ofNullable(affectedRows).filter(row -> row == 1).orElseThrow(() -> new RuntimeException("filter 运算"));
        System.out.println(result);


        String str = " t,e,s,t      ";
        //String str = null;
        String result2 = Optional.ofNullable(str).map(String::trim).get();
        System.out.println(result2);

        BigDecimal condition = new BigDecimal("0");
        String resultFilter = Optional.ofNullable(condition).filter(x -> !x.equals(BigDecimal.ZERO)).map(Object::toString).orElse("");
        System.out.println(resultFilter);

    }
}
