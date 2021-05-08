package com.zcy.string_test.stringbuilder_buffer;

public class AppendTest {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();


        final char[] tmp = new char[1024];
        tmp[0] = 'c';

        stringBuilder.append(tmp, 0, 3);
        stringBuilder.append(tmp, 0, 1);

        System.out.println(stringBuilder.toString());


//        int l;
//        while ((l = reader.read(tmp)) != -1) {
//            buffer.append(tmp, 0, l);
//        }


    }
}
