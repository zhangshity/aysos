package com.zcy.spring.jsr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

//@Service
@Named
public class JsrService {

    //    @Resource
//    @Inject
    private JsrDAO jsrDAO;

    @Resource
//    @Inject
    public void setJsrDAO(JsrDAO jsrDAO) {
        this.jsrDAO = jsrDAO;
    }

//    @Inject
//    public void setJsrDAO(@Named("jsrDAO") JsrDAO jsrDAO) {
//        this.jsrDAO = jsrDAO;
//    }

//    @Autowired
//    public JsrService(JsrDAO jsrDAO) {
//        this.jsrDAO = jsrDAO;
//    }

    @PostConstruct
    public void init() {
        System.out.println("jsr init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jsr destory");
    }


    public void save() {
        jsrDAO.save();
    }


}
