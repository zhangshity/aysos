package com.zcy.spring.aop_proxy_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Proxy_Demo {

    // 被代理接口（JDK动态代理需要）
    interface UserService {
        void addUser(String name);
    }

    // 被代理类（实现接口，用于JDK动态代理）
    static class UserServiceImpl implements UserService {
        @Override
        public void addUser(String name) {
            System.out.println("添加用户: " + name);
        }
    }

    // 被代理类（无接口，用于CGLib代理）
    static class OrderService {
        public void createOrder() {
            System.out.println("创建订单");
        }
    }




    // ============================== Main ==============================

    public static void main(String[] args) {
        System.out.println("-------------------- JDK动态代理 --------------------");
        // -------------------- JDK动态代理 --------------------
        UserService target = new UserServiceImpl();

        UserService jdkProxy = (UserService) Proxy.newProxyInstance(
                Proxy_Demo.class.getClassLoader(),
                new Class[]{UserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("[JDK代理] 前置处理");
                        Object result = method.invoke(target, args);
                        System.out.println("[JDK代理] 后置处理");
                        return result;
                    }
                });

        jdkProxy.addUser("张三");


        System.out.println("-------------------- CGLib代理 --------------------");
        // -------------------- CGLib代理 --------------------
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args,
                                    MethodProxy proxy) throws Throwable {
                System.out.println("[CGLib代理] 前置处理");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("[CGLib代理] 后置处理");
                return result;
            }
        });

        OrderService cglibProxy = (OrderService) enhancer.create();
        cglibProxy.createOrder();
    }
}