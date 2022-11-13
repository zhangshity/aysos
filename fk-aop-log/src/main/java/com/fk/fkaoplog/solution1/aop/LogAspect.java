package com.fk.fkaoplog.solution1.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Aspect
@Component
public class LogAspect {


    @Around("execution(* com.fk.fkaoplog.controller..*.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) {
        Object result = null;

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();


        try {
            log.info(">>>> 切面日志：req param: {}", Arrays.toString(joinPoint.getArgs()));

            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.info("执行错误:", e);
        }

        log.info(">>>> 切面日志：resp result: {}", result);

        return result;
    }
}
