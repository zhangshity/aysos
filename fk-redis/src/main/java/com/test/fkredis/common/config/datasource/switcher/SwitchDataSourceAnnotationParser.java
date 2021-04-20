package com.test.fkredis.common.config.datasource.switcher;

import com.oceanpayment.opgateway.common.config.datasource.DynamicDataSourceConfiguration;
import com.oceanpayment.opgateway.common.config.datasource.framework.DataSourceContext;
import com.oceanpayment.opgateway.common.config.datasource.framework.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切换数据源注解解析器
 * <p>Title: SwitchDataSourceAnnotationParser </p>
 * <p>Description: 注解{@link SwitchDataSource}切换数据源解析器 </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-04 18:23:39
 */
@Order(-1)
@Aspect
@Component
public class SwitchDataSourceAnnotationParser {

    private final Logger logger = LoggerFactory.getLogger(SwitchDataSourceAnnotationParser.class);

    /**
     * 切换数据源注解环绕通知
     * @param point 连接点
     * @return {@link ProceedingJoinPoint#proceed()}
     * @throws Throwable pointcut执行异常
     * @see DataSourceContext
     * @see DynamicDataSource#determineCurrentLookupKey()
     * @see DynamicDataSourceConfiguration#dynamicDataSource()
     */
    @Around("@annotation(com.oceanpayment.opgateway.common.config.datasource.switcher.SwitchDataSource)")
    public Object switcher(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        SwitchDataSource annotation = signature.getMethod().getAnnotation(SwitchDataSource.class);
        if (annotation != null) {
            // 配置数据源bean名称
            DataSourceContext.setDataSource(annotation.value());
            logger.debug("@SwitchDataSource switches the data source of the {}() method to '{}'", signature.getMethod().getName(), annotation.value());
        } else {
            logger.warn("@SwitchDataSource parameter of the {} method is null", signature.getMethod().getName());
        }

        try {
            return point.proceed();
        } finally {
            // 清空数据源bean名称
            DataSourceContext.clearDataSource();
        }
    }
}
