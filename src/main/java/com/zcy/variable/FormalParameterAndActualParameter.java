package com.zcy.variable;

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
 */
public class FormalParameterAndActualParameter {

    String str = "good";
    char[] ch = {'a', 'b', 'c' };

    public void exchange(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        FormalParameterAndActualParameter v = new FormalParameterAndActualParameter();
        
        v.exchange(v.str,v.ch);

        System.out.print(v.str + " and ");
        System.out.println(v.ch);
    }


}
