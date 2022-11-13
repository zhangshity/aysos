package com.zcy.exception.throw_inside_finally_block;

public class Test {

    public Integer div() {
        Throwable t = null;
        try {
            System.out.println("try执行...");
//            throw new RuntimeException("异常1");
        } catch (Exception e) {
            System.out.println("catch执行...");
            t = e;
            throw new RuntimeException("异常2", t);
        } finally {
            try {
                System.out.println("finally执行...");
                throw new RuntimeException("异常3");
            } catch (Exception e) {
                if (t != null) {
                    t.addSuppressed(e);
                }
//                throw new RuntimeException("异常4", e);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Test main = new Test();
        main.div();
    }
}
