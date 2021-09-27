package com.shit.springboottestcontroller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @Autowired
    private void InitialHttpServletInfo(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
