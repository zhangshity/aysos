package com.zcy.inner_class.anoymousInner.anonymousInnerConstructor;

/**
 * 《匿名类的构造函数》
 *
 *  结论：匿名内部类加载和普通继承父子类的初始化时一样的，只不过匿名内部类开发者无法定义，是编译器帮忙定义 (xxx$1.class)的类，
 *  ！！！匿名内部类，同样有构造器，且默认指定外部类声明的父类构造器
 *  <p> 父类声明构造器:   public ParentClass(int xxx, float yyy)
 *  <p> 匿名内部类构造器:  public ParentClass$1 {   super(int xxx, float yyy);  }
 */
public class AnonymousClassConstructorTest {
    public static void main(String[] args) {

        System.out.println("------------------------ 场景一: 匿名调用 ------------------------");
        // 场景一: 匿名内部类创建对象
        Calculator c1 = new Calculator(1, 2) {
            {
                setOperator(Ops.ADD);
                System.out.println("anonymous sub class  { } | 匿名子类代码块");
            }
        };
        System.out.println(c1.getResult());
        /**
         * 结果:
         * parent class (Calculator) { } | 父类代码块
         * public Calculator(int _i, int _j) | 父类有参构造器
         * anonymous sub class  { } | 匿名子类代码块
         * 3
         * --------------
         * 结论:
         * 调用了外部类(父类)的代码块，然后调用(父类)有参构造器[匿名内部类根据父类声明,隐式调用了父类super(_i,_j)]，最后匿名内部类(子类)的代码块生效
         * --------------
         * 过程:
         * 外部类(父类)代码块 -> 外部类(父类)有参构造器(匿名内部类隐式super(_i,_j)指定) -> 匿名内部类(子类)代码块(调用父类计算方法,得到结果)
         * 父类代码块 -> 父类无参构造器(匿名内部类隐式super(_i,_j)指定) -> 子类代码块(调用父类计算方法,得到结果) -> 子类构造器($1构造器)
         */


        System.out.println("------------------------ 场景二: 显示继承创建对象(子类有参构造器，未调用父类有参构造器) ------------------------");
        // 场景二: 显示继承创建对象(子类有参构造器，未调用父类有参构造器)
        Calculator c2 = new Add(1, 2);
        System.out.println(c2.getResult()); // 0
        /**
         * 结果:
         * parent class (Calculator) { } | 父类代码块
         * public Calculator() | 父类无参构造器
         * sub class (Add) { } | 子类代码块
         * public Add(int _i, int _j) | 子类构造器
         * 350
         * --------------
         * 结论:
         * 调用了外部类(父类)的代码块，然后调用(父类)无参构造器[子类构造器隐式super()指定]，最后调用(子类)的代码块,此时结果已定。最终调用子类构造器
         * --------------
         * 过程:
         * 父类代码块 -> 父类无参构造器(子类隐式super()指定) -> 子类代码块(调用父类计算方法,得到结果) -> 子类构造器
         */


        System.out.println("------------------------ 场景三: 显示继承创建对象(子类有参构造器,调用父类有参构造器) ------------------------");
        // 场景三: 显示继承创建对象(子类有参构造器,调用父类有参构造器)
        Calculator c3 = new RealAdd(1, 2);
        System.out.println(c3.getResult()); // 3
        /**
         * 结果:
         * parent class (Calculator) { } | 父类代码块
         * public Calculator(int _i, int _j) | 父类有参构造器
         * sub class (RealAdd) { } | 子类代码块
         * public RealAdd(int _i, int _j)  | 子类构造器
         * 3
         * --------------
         * 结论:
         * 调用了外部类(父类)的代码块，然后调用(父类)有参构造器[子类构造器super指定加载次构造器]，最后调用(子类)的代码块,此时结果已定。最终调用子类构造器
         * --------------
         * 过程:
         * 父类代码块 -> 父类有参构造器(子类super(_i, _j)指定) -> 子类代码块(调用父类计算方法,得到结果) -> 子类构造器
         */
    }
}


//-----------------------------------------------------------------------
enum Ops {ADD, SUB}
//-----------------------------------------------------------------------
class Calculator {
    private int i = 100, j = 250, result = 666;

    //代码块
    {
        System.out.println("parent class (Calculator) { } | 父类代码块");
    }

    //无参构造
    public Calculator() {
        System.out.println("public Calculator() | 父类无参构造器");
    }

    //有参构造
    public Calculator(int _i, int _j) {
        i = _i;
        j = _j;
        System.out.println("public Calculator(int _i, int _j) | 父类有参构造器");
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
        System.out.println("sub class (Add) { } | 子类代码块");
    }

    //覆写父类的构造方法
    public Add(int _i, int _j) {
        System.out.println("public Add(int _i, int _j) | 子类构造器");
    }
}


//-----------------------------------------------------------------------
class RealAdd extends Calculator {
    {
        setOperator(Ops.ADD);
        System.out.println("sub class (RealAdd) { } | 子类代码块");
    }

    //覆写父类的构造方法
    public RealAdd(int _i, int _j) {
        super(_i, _j);
        System.out.println("public RealAdd(int _i, int _j)  | 子类构造器");
    }
}
