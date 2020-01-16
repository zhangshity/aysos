package com.zcy._classloader.zcy_classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String path;
    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String pathName = path + name + ".class"; //自定义path和传入的类名name 的字符串组合(用于文件流读取)
        InputStream in = null;
        ByteArrayOutputStream out = null;
        byte[] b = null;
        try {
            in = new FileInputStream(new File(pathName));
            out = new ByteArrayOutputStream();
            int i;
            while ((i = in.read()) != -1) { //文件输入流转换为 字节数组输出流
                out.write(i);
            }
            b = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return defineClass(name, b, 0, b.length); //创建Class对象
    }
}
