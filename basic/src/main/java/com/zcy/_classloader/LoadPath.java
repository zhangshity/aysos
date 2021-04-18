package com.zcy._classloader;

public class LoadPath {
    public static void main(String[] args) {
        //Bootstrap ClassLoader
        System.out.println(System.getProperty("sun.boot.class.path"));
        //Extendsion ClassLoader
        System.out.println(System.getProperty("java.ext.dirs"));
        //Application ClassLoader
        System.out.println(System.getProperty("java.class.path"));
    }
}
