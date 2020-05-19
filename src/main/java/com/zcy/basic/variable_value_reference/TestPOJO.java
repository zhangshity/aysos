package com.zcy.basic.variable_value_reference;

import java.util.ArrayList;

public class TestPOJO {
    int i = 1;
    char c = 'a';
    String s = "hello";
    int[] in = {1, 2, 3};
    char[] ch = {'a', 'b', 'c' };
    Object o = new ArrayList<>();

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int[] getIn() {
        return in;
    }

    public void setIn(int[] in) {
        this.in = in;
    }

    public char[] getCh() {
        return ch;
    }

    public void setCh(char[] ch) {
        ch[1] = 'a';
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
}
