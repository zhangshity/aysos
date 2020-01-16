package com.zcy._classloader.ClassLoaderDIY;

public class ClassLoaderMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/zhangchunyang/Desktop/", "myClassLoader");
        Class c = myClassLoader.loadClass("Student");
        System.out.println(c.getClassLoader());
        Object instance = c.newInstance();
    }
}
