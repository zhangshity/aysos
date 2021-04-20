package com.test.fkredis.common.config.datasource.switcher;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切换数据源注解
 * <p>Title: SwitchDataSource </p>
 * <p>Description: 指定方法使用指定数据源,逻辑: {@link SwitchDataSourceAnnotationParser}</p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-04 18:18:10
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SwitchDataSource {

    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";
}
