package com.zcy.test_interface;

public interface JieKouCeShi {

    //===========变量=====================
    //接口中的变量默认添加修饰符(public static final),即为常量

    //添加private修饰无法通过编译
    //private String bianling5 = "private修饰的变量5";

    String bianling4 = "没有修饰符的bianliang4";

    public static String bianliang1 = "变量1";

    public final static String bianliang2 = "final static 变量";

    public final String bianliang3 = "final变量";


    //===========方法=====================
    //接口中的变量默认添加修饰符(public abstract),即为抽象方法

    //写了默认修饰(public abstract)的接口方法
    public abstract String dayin();

    //未写默认修饰的接口方法(默认自动添加)
    String dayin2();


}
