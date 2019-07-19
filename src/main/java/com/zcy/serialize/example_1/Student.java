package com.zcy.serialize.example_1;

import java.io.Serializable;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>要序列化的实体类</>
 * @ Date: Created in 10:17 2019-07-19
 * @ Modified: By:
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1234567L;

    private int id;
    private String name;
    private String gender;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
