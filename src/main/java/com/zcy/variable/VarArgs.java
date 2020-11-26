package com.zcy.variable;

/**
 * <p>Title: VarArgs</p >
 * <p>Description: </p >
 *
 * ① 可变参数本质就是一个数组，arr就是一个数组的引用地址（反编译工具查看源代码）
 * ②一个方法 可以有可变参数和普通参数，但是可变参数必须放到参数列表末尾；
 * ③ 一个方法 有且只能有一个可变参数;
 *
 * @author Allen Zhang
 * @version V1.0
 * @date 2020-07-24 18:08:07
 */
public class VarArgs {

    public String test(final String... strings) { //参数加final是为了防止内部对参数修改(避免了String的+=)
        StringBuilder sb = new StringBuilder("");
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public void test2(String... strings) { //参数加final是为了防止内部对参数修改
        System.out.println("Variable args>>> " + strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }

        System.out.println("\n不加final,方法内部修改 ====================== ");
        strings = new String[]{"123", "456", "7", "8", "9", "10", "11", "12", "13", "14"};
        System.out.println("Variable args>>> " + strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
    }

    public static void main(String[] args) {
        VarArgs varArgs = new VarArgs();
        String result1 = varArgs.test("123", "456", "7", "8", "9", "10", "11", "12", "13", "14");
        String result2 = varArgs.test("1", "2", "3");
        String result3 = varArgs.test(new String[]{"A", "r", "r", "a", "y"});
        System.out.println(result1 + "\n" + result2 + "\n" + result3);

        System.out.println("=========================");
        varArgs.test2("1", "2", "3");
    }
}