package com.zcy.file_io.readwrite.entity;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 17:28 2018-12-21
 * @ Modified: By:
 */

public class Student {

    public int sno;

    public String name;

    public String major;

    public String describe;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
