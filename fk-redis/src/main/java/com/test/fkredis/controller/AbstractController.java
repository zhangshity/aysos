package com.test.fkredis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象父类Controller
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-03-01 09:28:35
 */
public abstract class AbstractController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Http请求信息
     */
    protected HttpServletRequest request;

    /**
     * Http响应信息
     */
    protected HttpServletResponse response;

    @Autowired
    private void InitialHttpServletInfo(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
