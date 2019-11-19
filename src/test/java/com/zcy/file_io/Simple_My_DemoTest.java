package com.zcy.file_io;

import org.junit.Test;

import static org.junit.Assert.*;

public class Simple_My_DemoTest {

    @Test
    public void readFile() {
        Simple_Demo simple_demo = new Simple_Demo();
        simple_demo.readFile("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/file_system/record.txt");
    }

    @Test
    public void writeFile() {
        Simple_Demo simple_demo = new Simple_Demo();
        simple_demo.writeFile("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/file_system/record.txt");
    }

    @Test
    public void readFileByReader() {
        Simple_Demo simple_demo = new Simple_Demo();
        simple_demo.readFileByReader("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/file_system/record.txt");
    }

    @Test
    public void writeFileByWriter() {
        Simple_Demo simple_demo = new Simple_Demo();
        simple_demo.writeFileByWriter("/Users/zhangchunyang/Documents/IdeaProjects/aysos/src/main/resources/file_system/record.txt");

    }
}