package com.zcy.net.header;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;

public class HeaderTest {
    /**
     * 1、同名Header可以有多个 ，Header[] getHeaders(String name)。
     * 2、运行时使用的是第一个， Header getFirstHeader(String name)。
     * 3、addHeader，如果同名header已存在，则追加至原同名header后面。
     * 4、setHeader，如果同名header已存在，则覆盖一个同名header。
     */
    public static void main(String[] args) {

        HttpGet httpGet = new HttpGet("");


        httpGet.addHeader("Cookie", "aa");
        System.out.println("------------1---getFirstHeader----------");
        Header header_first = httpGet.getFirstHeader("Cookie");
        System.out.println(header_first.getName()+"  "+header_first.getValue());
        System.out.println("-----------2---getAllHeaders-----------");
        Header headers[] = httpGet.getAllHeaders();
        for(Header header:headers){
            System.out.println(header.getName()+"  "+header.getValue());
        }


        httpGet.addHeader("Cookie", "bb");
        System.out.println("-----------3----getFirstHeader----------");
        header_first = httpGet.getFirstHeader("Cookie");
        System.out.println(header_first.getName()+"  "+header_first.getValue());
        System.out.println("-----------4----getAllHeaders----------");
        headers = httpGet.getAllHeaders();
        for(Header header:headers){
            System.out.println(header.getName()+"  "+header.getValue());
        }


        httpGet.setHeader("Cookie", "cc");
        System.out.println("-----------5----getFirstHeader----------");
        header_first = httpGet.getFirstHeader("Cookie");
        System.out.println(header_first.getName()+"  "+header_first.getValue());
        System.out.println("-----------6----getAllHeaders----------");
        headers = httpGet.getAllHeaders();
        for(Header header:headers){
            System.out.println(header.getName()+"  "+header.getValue());
        }


        httpGet.setHeader("Cookie", "dd");
        System.out.println("-----------7----getFirstHeader----------");
        header_first = httpGet.getFirstHeader("Cookie");
        System.out.println(header_first.getName()+"  "+header_first.getValue());
        System.out.println("-----------8----getAllHeaders----------");
        headers = httpGet.getAllHeaders();
        for(Header header:headers){
            System.out.println(header.getName()+"  "+header.getValue());
        }
    }
}
