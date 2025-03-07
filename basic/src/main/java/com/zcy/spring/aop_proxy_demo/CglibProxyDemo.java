package com.zcy.spring.aop_proxy_demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// ---------------------- Main使用示例 ----------------------
// 使用示例
public class CglibProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderService.class);
        enhancer.setCallback(new CglibProxyHandler());
        OrderService proxy = (OrderService) enhancer.create();
        proxy.create();  // 调用代理方法

        // 输出:
        //  [CGLIB代理] 方法执行前
        //  创建订单
        //  [CGLIB代理] 方法执行后
    }
}


// ---------------------- CGLIB动态代理处理器 ----------------------
// CGLIB动态代理处理器
class CglibProxyHandler implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("[CGLIB代理] 方法执行前");
        Object result = proxy.invokeSuper(obj, args);  // 调用父类方法
        System.out.println("[CGLIB代理] 方法执行后");
        return result;
    }
}


// ---------------------- 类 定义 ----------------------
// 目标类（无接口）
class OrderService {
    public void create() {
        System.out.println("创建订单");
    }
}
