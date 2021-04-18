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

    //Id的getter
    public String getId() {
        return id;
    }

    //Id的setter
    public void setId(String id) {
        this.id = id;
    }

    //Type的getter
    public String getType() {
        return type;
    }

    //重写继承的clone方法(通过克隆创建新的对象实例)
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

