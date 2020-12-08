package com.zcy.collection.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShitCodeTest {
    public static void main(String[] args) {

        Map<String, String> postMap = new HashMap<String, String>();
        // 构造Map集合
//        postMap.put("sign_type", "sign_type1231231asdasdasdasdasd23213");
//        postMap.put("partner", "partner2343242343242asdasdasdasd34");
//        postMap.put("service", "service12342134asda134342");
//        postMap.put("partner_trans_id", "partner_trans_id123123213");

        postMap.put("service", "-----");
        postMap.put("partner", "-----");
        postMap.put("out_trade_no", "-----");
        postMap.put("sign_type", "-----");

//        postMap.put("service", "-----");
//        postMap.put("partner", "-----");
//        postMap.put("_input_charset", "UTF-8");
//        postMap.put("partner_trans_id", "-----");
//        postMap.put("sign_type", "-----");


        StringBuffer content = new StringBuffer();

        // 按照key做排序
        List<String> keys = new ArrayList<String>(postMap.keySet());
        Collections.sort(keys);

        for (int i = 0, j = keys.size(); i < j; i++) {
            String key = (String) keys.get(i);

            if ("sign".equals(key) || "sign_type".equals(key)) {
                continue;
            }
            String value = (String) postMap.get(key);
            if (value != null && !"".equals(value)) {
                content.append((i == 0 ? "" : "&") + key + "=" + value);
            } else {
                // content.append((i == 0 ? "" : "&") + key + "=");
            }
        }


        System.out.println(content.toString());



    }
}
