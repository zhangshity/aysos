package com.zcy.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 11:40 2019-07-09
 * @ Modified: By:
 * <p>
 * <<<================ 日期和时间的格式化编码 =================>>>
 * <p>
 * 时间模式字符串用来指定时间格式。在此模式中，所有的 ASCII 字母被保留为模式字母，定义如下：
 * <p>
 * 字母	   描述	                      示例
 * G	    纪元标记	                   AD
 * y	    四位年份	                   2001
 * M	    月份	                       July or 07
 * d	    一个月的日期	               10
 * h	     A.M./P.M. (1~12)格式小时	   12
 * H	    一天中的小时 (0~23)	       22
 * m	    分钟数	                   30
 * s	    秒数	                       55
 * S	    毫秒数	                   234
 * E	    星期几	                   Tuesday
 * D	    一年中的日子	               360
 * F	    一个月中第几周的周几	       2 (second Wed. in July)
 * w	    一年中第几周	               40
 * W	    一个月中第几周	               1
 * a	    A.M./P.M. 标记	           PM
 * k	    一天中的小时(1~24)	       24
 * K	     A.M./P.M. (0~11)格式小时	   10
 * z	    时区	                       Eastern Standard Time
 * '	    文字定界符	               Delimiter
 * "	    单引号	                   `
 */
public class TimeTest {

    /**
     * Java SimpleDateFormat()方法
     */
    public void simpleDataFormat() {
        String time = new SimpleDateFormat("G-yyyy-M-dd HH:mm:ss a").format(new Date());
        System.out.println(time);
    }


    public static void main(String[] args) {
        //================================2020-06-06 20:42:?? Sat.
        System.out.println("//================================2020-06-06 20:42:?? Sat.");
        //系统当前时间
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
}
