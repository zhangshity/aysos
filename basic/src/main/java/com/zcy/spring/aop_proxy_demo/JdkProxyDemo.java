package com.zcy.spring.aop_proxy_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


// ---------------------- Main使用示例 ----------------------
// 使用示例
public class JdkProxyDemo {
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JdkProxyHandler(target)
        );
        proxy.save();  // 调用代理方法

        // 输出：
        //    [JDK代理] 方法执行前
        //   保存用户
        //   [JDK代理] 方法执行后
    }
}

// ---------------------- JDK动态代理处理 ----------------------
// JDK动态代理处理器
class JdkProxyHandler implements InvocationHandler {
    private final Object target;  // 目标对象

    public JdkProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[JDK代理] 方法执行前");
        Object result = method.invoke(target, args);
        System.out.println("[JDK代理] 方法执行后");
        return result;
    }
}


// ---------------------- 接口、类 定义 ----------------------
// 定义接口
interface UserService {
    void save();
}

// 实现类（目标对象）
class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存用户");
    }
}
