package com.zcy;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletException;
import java.io.File;

public class FkApplication {

    public static void main(String[] args) throws ServletException, LifecycleException {

        // 创建Tomcat容器
        Tomcat tomcatServer = new Tomcat();
        // 端口号设置
        tomcatServer.setPort(9090);
        // 读取项目路径
        StandardContext ctx = (StandardContext) tomcatServer.addWebapp("/", new File("fk-embed-tomcat-spring-mvc/src/main").getAbsolutePath());


        tomcatServer.start();
        // 异步等待请求执行
        tomcatServer.getServer().await();



    }
}
