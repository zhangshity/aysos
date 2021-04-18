package com.zcy._extends;

public class ClassInitializationSequence {
    /**
     * [static] parent code block { } | 静态父类代码块
     * [static] sub code block { } | 静态子类代码块
     * parent code block { } | 父类代码块
     * public ParentClass() | 父类构造函数
     * sub code block { } | 子类代码块
     * public SubClass() | 子类构造函数
     *
     * <p>
     * <p> 对象实例化加载顺序：
     * <p> |优先级:
     * <p> |高  ------------------------------------>  低
     * <p> |静态父类代码块 -> 静态子类代码块 -> 父类代码块 —> 父类构造函数 —> 子类代码块—> 子类构造函数
     */
    public static void main(String[] args) {
        new SubClass(); // 初始化子类
    }
}

//-------------------------------- 父类 -----------------------------------
class ParentClass {

    // >>>>>>>>>> static >>>>>>>>>>
    private static int staticField = 10; //静态成员变量

    static {
        System.out.println("[static] parent code block { } | 静态父类代码块"); //静态代码段
    }

    // >>>>>>>>>> non-static >>>>>>>>>>
    private int field = 5; //成员变量

    {
        System.out.println("parent code block { } | 父类代码块"); //初始化代码段
    }

    // >>>>>>>>>> constructor >>>>>>>>>>
    public ParentClass() {
        System.out.println("public ParentClass() | 父类构造函数"); //构造函数
    }
}

//-------------------------------- 子类 -----------------------------------
class SubClass extends ParentClass {

    // >>>>>>>>>> static >>>>>>>>>>
    private static int staticField = 50; //子类静态成员变量

    static {
        System.out.println("[static] sub code block { } | 静态子类代码块"); //子类静态代码段
    }

    // >>>>>>>>>> non-static >>>>>>>>>>
    private int field = 25; //子类成员变量

    {
        System.out.println("sub code block { } | 子类代码块"); //子类初始化代码段
    }

    // >>>>>>>>>> constructor >>>>>>>>>>
    public SubClass() {
        System.out.println("public SubClass() | 子类构造函数"); //子类构造函数
    }
}
