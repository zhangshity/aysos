package com.zcy.inner_class;

/**
 * 《匿名类的构造函数》
 *
 *
 */
public class AnonymousClassConstructorTest {
    public static void main(String[] args) {
        // 匿名调用
        Calculator c1 = new Calculator(1,2) {
            {
                setOperator(Ops.ADD);
            }
        };
        System.out.println(c1.getResult()); //3

        // 显示继承调用
        Calculator c2 = new Add(1, 2);
        System.out.println(c2.getResult()); // 0
        


        // 显示继承调用2
        Calculator c3 = new realAdd(1, 2);
        System.out.println(c3.getResult()); // 有参构造函数Add
                                            // 3
    }
}


enum Ops {ADD, SUB}
//-----------------------------------------------------------------------
class Calculator {
    private int i, j, result;

    //无参构造
    public Calculator() {
    }

    //有参构造
    public Calculator(int _i, int _j) {
        i = _i;
        j = _j;
    }

    //设置符号，是加法运算还是减法运算
    protected void setOperator(Ops _op) {
        result = _op.equals(Ops.ADD) ? i + j : i - j;
    }

    //取得运算结果
    public int getResult() {
        return result;
    }
}

//-----------------------------------------------------------------------
class Add extends Calculator {
    {
        setOperator(Ops.ADD);
    }

    //覆写父类的构造方法
    public Add(int _i, int _j) {
    }
}


//-----------------------------------------------------------------------
class realAdd extends Calculator {
    {
        setOperator(Ops.ADD);
    }

    //覆写父类的构造方法
    public realAdd(int _i, int _j) {
        // 一般类（也就是具有显式名字的类）的所有构造函数默认都是调用父类的无参构造的
        super(_i, _j);   // 调父类有参构造函数
        System.out.println("有参构造函数Add");
    }
}
