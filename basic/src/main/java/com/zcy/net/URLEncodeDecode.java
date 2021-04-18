package com.zcy.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>URL编码</>
 * @ Date: Created in 10:47 2019-08-16
 * @ Modified: By:
 */
public class URLEncodeDecode {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //定义原始字符串
        String originalString = "编码Test123!";
        //URL编码
        String encodeResult = URLEncoder.encode(originalString, "UTF-8");
        //URL接吗
        String decodeResult = URLDecoder.decode(encodeResult, "UTF-8");


        System.out.println("Original String(原始字符串) >>> " + originalString);
        System.out.println("URL Encode Result(URL编码结果) >>> " + encodeResult);
        System.out.println("URL Decode Result(URL解码结构) >>> " + decodeResult);
    }
}
