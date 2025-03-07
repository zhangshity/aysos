package org.cy.xj.enhance;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static com.xxl.job.core.biz.model.ReturnT.FAIL_CODE;

/**
 * XXL-JOB代理工厂（支持JDK动态代理和CGLib代理）
 */
public class XxlJobProxyFactory {
    private static final Logger log = LoggerFactory.getLogger(XxlJobProxyFactory.class);

    /**
     * 创建代理对象（自动选择代理方式）
     * @param target 被代理对象
     * @return 代理后的对象
     */
    public static Object createProxy(Object target) {
        if (target.getClass().getInterfaces().length > 0) {
            return createJdkProxy(target);
        }
        return createCglibProxy(target);
    }

    /**
     * JDK动态代理
     */
    public static <T> T createJdkProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new XxlJobInvocationHandler(target));
    }

    /**
     * CGLib动态代理
     */
    public static <T> T createCglibProxy(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new XxlJobMethodInterceptor(target));
        return (T) enhancer.create();
    }

    /**
     * JDK代理处理逻辑
     */
    private static class XxlJobInvocationHandler implements InvocationHandler {
        private final Object target;

        public XxlJobInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return process(method, args);
        }

        private Object process(Method method, Object[] args) throws Throwable {
            // 仅处理带有@XxlJob注解的方法
            if (!method.isAnnotationPresent(XxlJob.class)) {
                return method.invoke(target, args);
            }

            XxlJob annotation = method.getAnnotation(XxlJob.class);
            String jobHandler = annotation.value();
            String argsStr = args != null && args.length > 0 ? args[0].toString() : "";
            
            try {
                MDCUtils.init();
                long start = System.currentTimeMillis();
                log.info(">>>>>>>>>>> {} 调度开始,参数:\n{}", jobHandler, argsStr);

                ReturnT<Object> result = (ReturnT<Object>) method.invoke(target, args);
                
                log.info(">>>>>>>>>>> {} 调度结束,耗时:{}ms,结果:\n{}", 
                        jobHandler, System.currentTimeMillis() - start, result);
                XxlJobHelper.handleResult(result.getCode(), result.getMsg());
                return result;
            } catch (Throwable e) {
                log.error(">>>>>>>>>>> {} 调度异常:{}", jobHandler, ExceptionUtils.getFullMessage(e), e);
                XxlJobHelper.handleFail("异常：" + e.getMessage());
                return new ReturnT<>(FAIL_CODE, "异常:\n" + ExceptionUtils.getStackTrace(e));
            } finally {
                MDCUtils.clear();
            }
        }
    }

    /**
     * CGLib代理处理逻辑
     */
    private static class XxlJobMethodInterceptor implements MethodInterceptor {
        private final Object target;

        public XxlJobMethodInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            // 仅处理带有@XxlJob注解的方法
            if (!method.isAnnotationPresent(XxlJob.class)) {
                return proxy.invokeSuper(obj, args);
            }

            XxlJob annotation = method.getAnnotation(XxlJob.class);
            String jobHandler = annotation.value();
            String argsStr = args != null && args.length > 0 ? args[0].toString() : "";

            try {
                MDCUtils.init();
                long start = System.currentTimeMillis();
                log.info(">>>>>>>>>>> {} 调度开始,参数:\n{}", jobHandler, argsStr);

                ReturnT<Object> result = (ReturnT<Object>) proxy.invokeSuper(obj, args);
                
                log.info(">>>>>>>>>>> {} 调度结束,耗时:{}ms,结果:\n{}", 
                        jobHandler, System.currentTimeMillis() - start, result);
                XxlJobHelper.handleResult(result.getCode(), result.getMsg());
                return result;
            } catch (Throwable e) {
                log.error(">>>>>>>>>>> {} 调度异常:{}", jobHandler, ExceptionUtils.getFullMessage(e), e);
                XxlJobHelper.handleFail("异常：" + e.getMessage());
                return new ReturnT<>(FAIL_CODE, "异常:\n" + ExceptionUtils.getStackTrace(e));
            } finally {
                MDCUtils.clear();
            }
        }
    }
}