package com.zcy.string_test;

import java.util.Arrays;
import java.util.List;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 10:57 2020/6/1
 * @ Modified: By:
 */
public class Split {
    public static void main(String[] args) {
        String dateParam = "2020-05-26";
        System.out.println(System.currentTimeMillis());
        String[] date = dateParam.split("-");
        String year = date[0];
        String month = date[1];
        String day = date[2];
        System.out.println(year + " " + month + " " + day);
        System.out.println(System.currentTimeMillis());


        //================================2020-06-06 20:42:?? Sat.
        System.out.println("//================================2020-06-06 20:42:?? Sat.");
        String beginDateTime = "2020-05-26 13:25:35";
        String endDateTime = "2020-05-26 20:24:12";

        System.out.println(beginDateTime.split(" ")[0]);
        System.out.println(endDateTime.split(" ")[0]);
        System.out.println(beginDateTime.split(" ")[0].equals(endDateTime.split(" ")[0]));


        //================================2020-08-26 14:14:?? Wen.
        System.out.println("//===========边界测试=====================2020-08-26 14:14:?? Wen.");
        String dataString1 = "Alipay,Wechatpay,";              //[Alipay, Wechatpay]
        String dataString2 = "Alipay,Wechatpay,,";             //[Alipay, Wechatpay]
        String dataString3 = "Alipay,Wechatpay,,,";            //[Alipay, Wechatpay]
        String dataString4 = "Alipay,Wechatpay, ,";            //[Alipay, Wechatpay,  ]              //" "
        String dataString5 = "Alipay,Wechatpay, ,Unionpay";    //[Alipay, Wechatpay,  , Unionpay]    //" "
        String dataString6 = ",Alipay,Wechatpay";              //[, Alipay, Wechatpay]               //""
        String dataString7 = ",,Alipay,Wechatpay";             //[, , Alipay, Wechatpay]             //两个都是 ""
        String dataString8 = ",,,Alipay,Wechatpay";            //[, , , Alipay, Wechatpay]           //三个都是 ""
        String dataString9 = "AlipayWechatpay";                //[AlipayWechatpay]                   //没有分隔符就不分隔
        String dataString10 = "";                               //[]                                 //没有分隔符就不分隔

        String[] dataArray = dataString8.split(",");
        System.out.println("==" + dataArray[2] + "==");
        List<String> dataList = Arrays.asList(dataArray);
        System.out.println(dataList);
        /**
         *当分割符号(,)在字符串首时生效，会把分割符号前的默认解析成空字符串("" ,不是null)   (有几个分隔符解析几个空串"")
         *当分割符号(,)在字符串尾时失效，会把分割符号后的舍弃掉  (无论多少个分隔符)
         * */
        String empty = "";
        System.out.println("==" + empty + "==");



        //========================正则触发测试=========================================
        System.out.println("//========================正则触发测试=========================================");
        String exp = "Son&Father&God&Nobody";
        String[] expSplitArray = exp.split("[&]");
        System.out.println(Arrays.asList(expSplitArray));
    }
}
