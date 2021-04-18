package com.zcy.spring.transaction.pojo;

import java.time.LocalDateTime;

public class Student {
    int id;
    String name;
    int age;
    LocalDateTime createTime;
    int version;

    public Student() {
    }

    public Student(int id, String name, int age, LocalDateTime createTime, int version) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createTime = createTime;
        this.version = version;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", version=" + version +
                '}';
    }
}
