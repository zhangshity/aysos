package com.zcy.java1_8NewFunction.stream;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToMapTest {
    public static void main(String[] args) throws UnsupportedEncodingException {


        String bankResponse = "K=08c30b1976142106e8db35db5da91cd7&" +
                "M=10018949&" +
                "O=101&" +
                "T=11%2F24%2F2020+08%3A50%3A13&" +
                "_M=10018949&" +
                "_O=1&" +
                "_a1=201124161441175128882&" +
                "_a2=2&" +
                "_a4=17745&" +
                "_a5=USD&" +
                "_a9=6&" +
                "_b1=DF1773...4465&" +
                "_b2=1&_b3=09&" +
                "_b4=24&" +
                "_i2=gtracing*OnlinShop&" +
                "_z1=XZZ66f16a87173b2001GS4EWJN5YJHGR&" +
                "_z13=032946765145&" +
                "_z2=0&" +
                "_z3=Transaction+has+been+executed+successfully.&" +
                "_z4=111475&" +
                "_z55=XZZ66f16a87173b2001DCZFZXEC6JGPP&" +
                "_z6=00&" +
                "a1=1606207812839&" +
                "g4=201128888441175122602&" +
                "z1=Father.Yang-XZZ68caee536c749612JEHYXMATBFDL5&" +
                "z2=0&" +
                "z3=Transaction+has+been+executed+successfully.";

        String failBankResponse = "K=08c30b1976142106e8db35db5da91cd7";


        System.out.println("========================= forEach遍历添加 =========================");
        Map<String, String> bankResponseFieldMap = new ConcurrentHashMap<>(64);

        Arrays.stream(URLDecoder.decode(bankResponse, StandardCharsets.UTF_8.name()).split("&"))
                .parallel()
                .forEach(x -> {
                    String[] kvArr = x.split("=");
                    bankResponseFieldMap.put(kvArr[0].trim(), kvArr[1].trim());
                });

        System.out.println(bankResponseFieldMap);
        System.out.println(bankResponseFieldMap.get("z1"));


        System.out.println("========================= 普通map映射 =========================");
        Map<String, String> bankResponseFieldMap1 = Arrays.stream(URLDecoder.decode(failBankResponse, StandardCharsets.UTF_8.name()).split("&"))
                .parallel()
//                .filter(x -> x.length() > 0)
                .map(s -> s.split("="))
                .collect(Collectors.toMap(k -> k[0].trim(), v -> v[1].trim()));
//                .forEach(x -> System.out.printf(Arrays.toString(x)));
        System.out.println(bankResponseFieldMap1);
        System.out.println(bankResponseFieldMap1.get("z1"));


        System.out.println("========================= flatMap =========================");
        List<String> list = Arrays.stream(URLDecoder.decode(bankResponse, StandardCharsets.UTF_8.name()).split("&"))
                .flatMap(s -> Arrays.stream(s.split("=")))
                .collect(Collectors.toList());
//                .forEach(System.out::println);
        System.out.println(list);




    }
}
