package com.zcy.tools.codec;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlDecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

        // URL 编码测试
        String url = "www.baidu.com/search?aaa=<hhhh>&name=张三&demo=aas7s7-115niosa-115ghh-1 1-12315adf";

        System.out.println(URLEncoder.encode(url)); //默认UTF-8
        System.out.println(URLEncoder.encode(url, StandardCharsets.UTF_8.name()));
        System.out.println(URLEncoder.encode(url, StandardCharsets.ISO_8859_1.name()));

        System.out.println(URLDecoder.decode(url)); //默认UTF-8
        System.out.println(URLDecoder.decode(url, StandardCharsets.UTF_8.name()));
        System.out.println(URLDecoder.decode(url, StandardCharsets.ISO_8859_1.name()));
    }
}
