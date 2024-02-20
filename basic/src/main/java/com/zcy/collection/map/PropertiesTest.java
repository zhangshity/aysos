package com.zcy.collection.map;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        // 配置文件的特点是，它的Key-Value一般都是String-String类型的，因此我们完全可以用Map<String, String>来表示它。
        // 因为配置文件非常常用，所以Java集合库提供了一个Properties来表示一组“配置”。由于历史遗留原因，Properties内部本质上是一个Hashtable，但我们只需要用到Properties自身关于读写配置的接口。
        // 读取配置文件
        // 用Properties读取配置文件非常简单。Java默认配置文件以.properties为扩展名，每行以key=value表示，以#课开头的是注释。以下是一个典型的配置文件：
        try {

            Properties properties = new Properties();
            //properties.load(PropertiesTest.class.getClassLoader().getResourceAsStream("db.properties"));

            //早期版本的Java规定.properties文件编码是ASCII编码（ISO8859-1），如果涉及到中文就必须用name=\u4e2d\u6587来表示，非常别扭。
            // 从JDK9开始，Java的.properties文件可以使用UTF-8编码了。
            //不过，需要注意的是，由于load(InputStream)默认总是以ASCII编码读取字节流，所以会导致读到乱码。我们需要用另一个重载方法load(Reader)读取：
            String file = PropertiesTest.class.getClassLoader().getResource("db.properties").getFile(); // /D:/GitHub/aysos/basic/target/classes/db.properties
            properties.load(new FileReader(file));
            //properties.loadFromXML(new FileInputStream(""));
            System.out.println(properties);
            System.out.println(properties.getProperty("jdbc.driver")); //com.mysql.jdbc.Driver
            System.out.println(properties.getProperty("jdbc.url")); //jdbc:mysql://localhost:3306/demo_springboot?useUnicode=true&characterEncoding=utf8&useSSL=false
            System.out.println(properties.getProperty("jdbc.shit")); //null
            System.out.println(properties.getProperty("jdbc.shit", "defaultValue")); //defaultValue




            Properties props = new Properties();
            props.setProperty("name", "fatheryang");
            props.setProperty("size", "huge");
            props.store(new FileWriter("D:\\setting.properties"), "这是写入的properties注释");
            props.storeToXML(new FileOutputStream("D:\\setting2.properties"), "这是写入的properties注释");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
