package com.zcy.codec_crypto_cipher;


import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Base64TestMain {
    public static void main(String[] args) {

        String str = "Hello, World! 中文~!@#$%^&*()_+/*-+{}|123";
        byte[] strByteArr_default = str.getBytes();
        byte[] strByteArr_utf8 = str.getBytes(StandardCharsets.UTF_8);
        byte[] strByteArr_iso88591 = str.getBytes(StandardCharsets.ISO_8859_1);
        byte[] strByteArr_ascii = str.getBytes(StandardCharsets.US_ASCII);
        byte[] strByteArr_utf16 = str.getBytes(StandardCharsets.UTF_16);
        System.out.println("Charset.defaultCharset() = " + Charset.defaultCharset()); // UTF-8 环境不同会变化
        System.out.println("============");
        System.out.println("strByteArr_default: " + Arrays.toString(strByteArr_default)); //二进制数组 -> 实际打印：二进制转为十进制的数组
        System.out.println("strByteArr_utf8: " + Arrays.toString(strByteArr_utf8)); //二进制数组 -> 实际打印：二进制转为十进制的数组
        System.out.println("strByteArr_iso88591: " + Arrays.toString(strByteArr_iso88591)); //二进制数组 -> 实际打印：二进制转为十进制的数组
        System.out.println("strByteArr_ascii: " + Arrays.toString(strByteArr_ascii)); //二进制数组 -> 实际打印：二进制转为十进制的数组
        System.out.println("strByteArr_utf16: " + Arrays.toString(strByteArr_utf16)); //二进制数组 -> 实际打印：二进制转为十进制的数组
        System.out.println("============");
        System.out.println("(Arrays.equals(strByteArr_default, strByteArr_utf8)) = " + (Arrays.equals(strByteArr_default, strByteArr_utf8))); // true
        System.out.println("Arrays.equals( strByteArr_default, strByteArr_iso88591) = " + Arrays.equals(strByteArr_default, strByteArr_iso88591)); // false
        System.out.println("Arrays.equals( strByteArr_default, strByteArr_ascii) = " + Arrays.equals(strByteArr_default, strByteArr_ascii)); // false
        System.out.println("Arrays.equals( strByteArr_default, strByteArr_utf16) = " + Arrays.equals(strByteArr_default, strByteArr_utf16)); // false






        // Base64本质就是对一段2进制数组进行编码，编码后的结果同样也是一个2进制数组





        byte[] byteArr = {0b0000_0001,0b0000_0011};


        java.util.Base64.getEncoder().encode();


        String encoded2 = java.util
                .Base64.getEncoder().encodeToString(strByteArr_default);


        // Base64 编码
        String encoded1 = org.apache.commons.codec.binary
                .Base64.encodeBase64String(strByteArr_default);
        byte[] bytes = Base64.decodeBase64(encoded1);

        String encoded2 = java.util
                .Base64.getEncoder().encodeToString(strByteArr_default);


        System.out.println("encoded1: " + encoded1);
        System.out.println("encoded2: " + encoded2);

    }
}
