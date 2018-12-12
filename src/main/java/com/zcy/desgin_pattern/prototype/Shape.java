package com.zcy.desgin_pattern.prototype;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 11:14 2018/12/11
 * @ Modified: By:
 */

public abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone (){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }



}

