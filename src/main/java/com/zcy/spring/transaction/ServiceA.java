package com.zcy.spring.transaction;

import com.zcy.spring.transaction.dao.Mapper;
import com.zcy.spring.transaction.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableAspectJAutoProxy(exposeProxy = true)  //允许代码中获取proxy类  // 暴露当前代理对象到当前线程绑定
public class ServiceA {

    public static final Logger logger = LoggerFactory.getLogger(ServiceA.class);

    @Autowired
    private ServiceB serviceB;

    @Autowired
    private Mapper mapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateMain() {
        for (int i = 0; i <= 5; i++) {
            serviceB.updateSomething(i);
            // 调用内部方法
            ((ServiceA) AopContext.currentProxy()).updateMain();
            logger.info("ServiceA 第{}次 调用完成", i);
        }
    }


    // 内部方法调用不走代理,Transactional会失效
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void updateSomething(int cycleIndex) {
        // 更新伪代码1
        mapper.insert(new Student("Allen1", 15));
        logger.info("更新 1 成功");
        // 更新伪代码2
        mapper.insert(new Student("Allen2", 25));
        logger.info("更新 2 成功");
        // 更新伪代码3
        mapper.insert(new Student("Allen3", 16));
        logger.info("更新 3 成功");
        // 更新伪代码4
        mapper.insert(new Student("Allen4", 55));
        logger.info("更新 4 成功");
        // 更新伪代码5
        mapper.insert(new Student("Allen5", 24));
        logger.info("更新 5 成功");
        if (cycleIndex == 4) {
            // 伪代码抛出异常
            throw new RuntimeException("Service B,更新 5 失败");
        }
        // 更新伪代码6
        mapper.insert(new Student("Allen6", 21));
        logger.info("更新 6 表成功");
    }
}
