package com.zcy.inner_class.__1_standardTest;

public class StaticNestedClassTest {
    private Integer i;

    public StaticNestedClassTest() {
        System.out.println("Outer Class created successfully!");
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }


    // 普通内部类
    static class Inner {
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
            StaticNestedClassTest staticNestedClassTest = new StaticNestedClassTest();
            System.out.println("静态内部类调用外部类的变量 i " + staticNestedClassTest.i);
        }
    }
}
