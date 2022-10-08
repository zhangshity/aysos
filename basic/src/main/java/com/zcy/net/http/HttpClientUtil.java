package com.zcy.net.http;

import cn.hutool.http.HttpUtil;

import java.util.concurrent.CompletableFuture;

public class HttpClientUtil {
    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {


            CompletableFuture.runAsync(() -> {
                String response = HttpUtil.get("localhost:8088/camel/jinnuo_repayment_plan_job");
                System.out.println("第" + "-" + "次执行! 【1111】响应" + response);
            });

            CompletableFuture.runAsync(() -> {
                String response = HttpUtil.get("localhost:8088/camel/jinnuo_repayment_job");
                System.out.println("第" + "-" + "次执行! 【2222】响应" + response);
            });
        }



        String response = HttpUtil.get("localhost:8088/camel/jinnuo_repayment_plan_job");
        System.out.println("结果" + response);








    }
}
