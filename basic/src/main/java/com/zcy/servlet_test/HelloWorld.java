package com.zcy.servlet_test;//package com.com.zcy.test_servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class HelloWorld extends HttpServlet {
//
//    private String message;
//
//    public void init() throws ServletException {
//        //执行必须的初始化
//        message = "Hello,World";
//    }
//
//    public void doGet(HttpServletRequest request,
//                      HttpServletResponse response)
//            throws ServletException, IOException {
//
//        //设置响应内容类型
//        response.setContentType("text/html");
//
//        //实际逻辑在这里
//        PrintWriter out = response.getWriter();
//        out.println("<h1>"+message+"</h1>");
//    }
//
//    public void destroy() {
//        //什么也不做
//    }
//}
