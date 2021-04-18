package com.zcy._extends.mthd_in_fathr_cls;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        XiaoMing xiaoMing = new XiaoMing();
        Class clazz = xiaoMing.loadClass("main");
        System.out.println(clazz.getClassLoader()); //模拟ClassLoader没有继承，其类加载器是AppClassLoader
        System.out.println(clazz.getClassLoader().getParent());
        Object object = clazz.newInstance();
        System.out.println(object);


    }

}
