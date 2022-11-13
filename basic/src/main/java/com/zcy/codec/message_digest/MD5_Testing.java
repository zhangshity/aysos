package com.zcy.codec.message_digest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_Testing {

    // 测试数据
    private static final String RAW_DATA = "Little Daddy,123";


    public static void main(String[] args) throws NoSuchAlgorithmException {
        // jdk
        MessageDigest md5 = MessageDigest.getInstance("md5");
        md5.digest();// TODO

        // apache codec
        String md5Hex = DigestUtils.md5Hex(RAW_DATA);
        System.out.println(md5Hex); //1f6a0cec9647364586661813d5ca056f

    }
}
