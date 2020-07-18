package com.zcy.basic.variable_value_reference;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 18:33 2020/5/14
 * @ Modified: By:
 * 例题：
 * 链接：https://www.nowcoder.com/questionTerminal/0280fb67cb444178acc9685e1b0df295?toCommentId=381722
 * 来源：牛客网
 * <p>
 * 指出以下程序运行的结果是
 * <p> public class Example{
 * <p>     String str=new String("good");
 * <p>     char[]ch={'a','b','c'};
 * <p>     public static void main(String args[]){
 * <p>         Example ex=new Example();
 * <p>         ex.change(ex.str,ex.ch);
 * <p>         System.out.print(ex.str+" and ");
 * <p>         System.out.print(ex.ch);
 * <p>     }
 * <p>     public void change(String str,char ch[]){
 * <p>         str="test ok";
 * <p>         ch[0]='g';
 * <p>     }
 * <p> }
 * A.good and abc
 * B.good and gbc      V
 * C.test ok and abc
 * D.test ok and gbc
 * <p>
 * @see com.zcy.variable.FormalParameterAndActualParameter#exchange(String, char[])
 */
public class VariableOperate {
    String str = "good";
    char[] ch = {'a', 'b', 'c'};
    int[] in = {1, 2, 3};
    int i = 123;
    Object o = new Student();
    StringBuilder sb = new StringBuilder("well");
    String s = new String("good2");

    public void exchange(String str1, char[] ch, int[] in, int i, Object o, StringBuilder sb, String s) {
        str = "test ok";
        ch[0] = 'g';
        in[1] = 9;
        i = 911;
        o = new Professor();
        sb.append("test ko");
        s = "test ok2";
    }


    public static void main(String[] args) {
        VariableOperate v = new VariableOperate();
        v.exchange(v.str, v.ch, v.in, v.i, v.o, v.sb,v.s);

        System.out.println("=======main()打印==========");
        System.out.print(v.str + " and ");
        System.out.println(v.ch);
        System.out.println(v.i);
        System.out.println(v.o);
        for (int i = 0; i < v.in.length; i++) {
            System.out.print(v.in[i]);
        }
        System.out.println("\n" + v.sb);
        System.out.println(v.s);
    }
}
