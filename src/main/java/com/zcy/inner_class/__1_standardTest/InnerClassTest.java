package com.zcy.inner_class.__1_standardTest;

public class InnerClassTest {

    private Integer i;

    public InnerClassTest() {
        System.out.println("Outer Class created successfully!");
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }


    // 普通内部类
    class Inner {
        private String message;

        public Inner() {
            System.out.println("Inner Class created successfully!");;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void invokeOuterClass() {
            System.out.println("内部类调用外部类的变量 i" + i);
        }
    }
}
