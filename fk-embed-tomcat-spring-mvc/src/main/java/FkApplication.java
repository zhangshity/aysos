import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

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



//        ctx.setPath("/");
//
//        // 禁止重新载入
//        ctx.setReloadable(false);
//        // class文件读取地址
//        File additionWebInfClasses = new File("gfloan-paycenter-api/target/classes");
//        // 创建WebRoot
//        WebResourceRoot resources = new StandardRoot(ctx);
//        // tomcat内部读取Class执行
//        resources.addPreResources(
//                new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));


        tomcatServer.start();
        // 异步等待请求执行
        tomcatServer.getServer().await();



    }
}
