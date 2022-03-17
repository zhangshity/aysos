package com.zcy.spring.transaction;

import com.zcy.spring.transaction.dao.Mapper;
import com.zcy.spring.transaction.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class ServiceA {

    public static final Logger logger = LoggerFactory.getLogger(ServiceA.class);

    @Autowired
    private ServiceB serviceB;

    @Autowired
    private Mapper mapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateMain() {

        //循环调用Service其他方法
        for (int i = 0; i <= 4; i++) {
            logger.info("-------------- ServiceA 第{}次 调用开始 Begin --------------",i);

            // ====================== 测试1:  service调用 ======================
            //                                          ✔ServiceB内REQUIRE_NEW独立事务回滚,且抛出异常。被serviceA捕获,serviceA不受影响
//            try {
//                serviceB.updateSomething(i);
//            } catch (Exception e) {
//                logger.error("测试1:  serviceB调用失败", e);
//            }


            // ====================== 测试2:  this调用内部方法 ======================
            // 测试2.(1) this调用内部方法                  ✘ServiceB内REQUIRE_NEW独立事务,第3次执行中断,且抛出异常,回滚失败,未开启事务。被serviceA捕获,serviceA不受影响
//            try {
//                this.updateSomething(i);
//            } catch (Exception e) {
//                logger.error("测试2.(2):  serviceB调用失败", e);
//            }
            // 测试2.(2) AOP代理自我调用                  ✔ServiceB内REQUIRE_NEW独立事务回滚,且抛出异常。被serviceA捕获,serviceA不受影响 (AOP自我调用成功)
//            try {
//                ((ServiceA) AopContext.currentProxy()).updateSomething(i);
//            } catch (Exception e) {
//                logger.error("测试2.(2):  serviceB调用失败", e);
//                //throw new RuntimeException("测试2.(2):  serviceB调用失败", e);
//            }
            // 测试2.(3) AOP代理内嵌调用                  ✔ServiceB内REQUIRE_NEW独立事务回滚,且抛出异常。被内嵌方法捕获并上抛给serviceA,serviceA不受影响 (AOP内嵌调用成功,不受代码位置影响)
            try {
                this.nestedMethod(i);
            } catch (Exception e) {
                logger.error("测试2.(3):  serviceB调用失败", e);
            }

            mapper.insert(new Student("外部事务域 ServiceA 第[" + i + "]次调用完成!" + " --------------------!!!!!!-------------------", 15));
            logger.info("-------------- ServiceA 第{}次 调用完成 End --------------", i);
        }




        // 测试3 手动回滚
//        try {
//            mapper.insert(new Student("Main手动回滚测试", 0));
//            throw new RuntimeException("Service A,更新 Main 失败！！");
//        } catch (Exception e) {
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //配置 @Transactional注解 手动回滚
//            logger.error("Service A,更新失败！！", e);
//        }
    }


    // 嵌套事务
    private void nestedMethod(int i) {
        ((ServiceA) AopContext.currentProxy()).updateSomething(i);
    }



    // 内部方法调用不走代理,Transactional会失效
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void updateSomething(int cycleIndex) {
        // 更新伪代码1
        mapper.insert(new Student("Allen1-" + cycleIndex, 15));
        logger.info("更新 1 成功");
        // 更新伪代码2
        mapper.insert(new Student("Allen2-" + cycleIndex, 25));
        logger.info("更新 2 成功");
        // 更新伪代码3
        mapper.insert(new Student("Allen3-" + cycleIndex, 16));
        if (cycleIndex == 3) {
            // 伪代码抛出异常
            throw new RuntimeException("Service B,更新 3 失败, for" + cycleIndex + "次");
        }
        logger.info("更新 3 成功");
        // 更新伪代码4
        mapper.insert(new Student("Allen4-" + cycleIndex, 55));
        logger.info("更新 4 成功");
        // 更新伪代码5
        mapper.insert(new Student("Allen5-" + cycleIndex, 24));
        logger.info("更新 5 成功");
        // 更新伪代码6
        mapper.insert(new Student("Allen6-" + cycleIndex, 21));
        logger.info("更新 6 表成功");
    }


}
