package com.zcy.interface_test;

/**
 * 扫盲:
 * 接口定义整理
 */
public interface _1_InterfaceTest {

    // ============================== 变量 var ==============================
    // 接口中的变量默认添加修饰符(public static final),即为常量
    String var1 = "没有修饰符 变量";

    public String var2 = "public修饰 变量";

    static String var3 = "static 变量";

    final String var4 = "final 变量";

    public static String var5 = "public static 变量";

    public final String var6 = "public final 变量";

    public static final String var7 = "public static final 变量";

    // * (private、protected)修饰变量无法通过编译
    //  private String var8 = "private修饰 变量";
    //  protected String var9 = "protected修饰 变量";


    // ============================= 方法 method =============================
    // 接口中的变量默认添加修饰符(public abstract),即为抽象方法

    // 未写默认修饰的接口方法(默认自动添加)
    String method1();

    // 写了修饰符(public)的接口方法
    public String method2();

    // 写了修饰符(abstract)的接口方法
    abstract String method3();

    // 写了修饰符(public abstract)的接口方法
    public abstract String method4();

    // * (final、private、protected)修饰方法无法通过编译
    //  final String method5();
    //  private String method6();
    //  protected String method7();




    // ============================ [default] - 1.8 Feature ============================
    /**
     * <p>在接口中，增加default方法，是为了既有的成千上万的Java类库的类增加新的功能，且不必对这些类进行重新设计。
     *   因此它既被称为默认方法，又被称为拓展方法。
     * <p>比如说，只需要在Collection接口中增加default Stream stream()，相应的Set和List接口以及它们的子类都会包含此方法，
     *   不必再去为每个子类重新copy这个方法。
     * <p> default方法的出现，允许了我们在接口中添加非抽象的方法实现。
     */
    // --------------------------- default ---------------------------
    default String defaultMethod(){
        return "interface default method";
    }
    // ---------------------------------------------------------------
    // 写了修饰符(public)的default方法
    public default String defaultMethod2() {
        return "[public default] interface default method";
    }
    // * (private、protected、final、abstract)均不可与[default]修饰符一起使用,无法通过编译
    //  private default String defaultMethod3() {
    //      return "[private default] interface default method";
    //  }
    //
    //  protected default String defaultMethod3() {
    //      return "[protected default] interface default method";
    //  }
    //
    //  final default String defaultMethod4() {
    //      return "[final default] interface default method";
    //  }
    //
    //  abstract default String defaultMethod5() {
    //      return "[abstract default] interface default method";
    //  }



    // ============================ [static] - 1.8 Feature ============================
    /**
     * <p>定义用法和普通的static方法一样
     * <p>实现接口的类或者子接口不会继承接口中的静态方法
     */
    // --------------------------- static ---------------------------
    static String staticMethod(){
        return "interface static method";
    }
    // --------------------------------------------------------------
    // 写了修饰符(public)的default方法
    public static String staticMethod2(){
        return "[public static] interface static method";
    }
    // * (private、protected、final、abstract)均不可与[static]修饰符一起使用,无法通过编译
    //  private static String defaultMethod3() {
    //      return "[private static] interface default method";
    //  }
    //
    //  protected static String defaultMethod3() {
    //      return "[protected static] interface default method";
    //  }
    //
    //  final static String defaultMethod4() {
    //      return "[final static] interface default method";
    //  }
    //
    //  abstract static String defaultMethod5() {
    //      return "[abstract static] interface default method";
    //  }
}
