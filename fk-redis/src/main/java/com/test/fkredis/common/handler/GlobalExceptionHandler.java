package com.test.fkredis.common.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 全局统一异常处理
 * <p>Title: GlobalExceptionHandler</p>
 * <p>Description:  //TODO 业务确定是否都是 rest风格返回，可改成@RestControllerAdvice替换 [Allen.C.Y.Zhang,20210225,2个月内]</p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-02-25 10:36:26
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> exceptionHandler(Exception e) {
        Map<String, String> responseMap = new LinkedHashMap<>(4);
        responseMap.put("code", "fail");
        responseMap.put("msg", "system error");
        logger.error("系统错误:", e);
        return responseMap;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> runtimeExceptionHandler(RuntimeException e) {
        Map<String, String> responseMap = new LinkedHashMap<>(4);
        responseMap.put("code", "fail");
        responseMap.put("msg", "unknown exception");
        logger.error("系统异常:", e);
        return responseMap;
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> testExceptionHandler(ArithmeticException e) {
        Map<String, String> responseMap = new LinkedHashMap<>(4);
        responseMap.put("code", "fail");
        responseMap.put("msg", "test");
        logger.error("系统异常测试 -/ by zero :", e);
        return responseMap;
    }

}
