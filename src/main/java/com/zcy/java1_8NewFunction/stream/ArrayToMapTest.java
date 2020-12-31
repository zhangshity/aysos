package com.zcy.java1_8NewFunction.stream;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayToMapTest {
    public static void main(String[] args) throws UnsupportedEncodingException {


        String bankResponse = "K=08c30b1976142106e8db35db5da91cd7&\n" +
                "M=10018949&\n" +
                "O=101&\n" +
                "T=11%2F24%2F2020+08%3A50%3A13&\n" +
                "_M=10018949&\n" +
                "_O=1&\n" +
                "_a1=201124161441175128882&\n" +
                "_a2=2&\n" +
                "_a4=17745&\n" +
                "_a5=USD&\n" +
                "_a9=6&\n" +
                "_b1=DF1773...4465&\n" +
                "_b2=1&_b3=09&\n" +
                "_b4=24&\n" +
                "_i2=gtracing*OnlinShop&\n" +
                "_z1=XZZ66f16a87173b2001GS4EWJN5YJHGR&\n" +
                "_z13=032946765145&\n" +
                "_z2=0&\n" +
                "_z3=Transaction+has+been+executed+successfully.&\n" +
                "_z4=111475&\n" +
                "_z55=XZZ66f16a87173b2001DCZFZXEC6JGPP&\n" +
                "_z6=00&\n" +
                "a1=1606207812839&\n" +
                "g4=201128888441175122602&\n" +
                "z1=XZZ68caee536c749612JEHYXMATBFDL5&\n" +
                "z2=0&\n" +
                "z3=Transaction+has+been+executed+successfully.";


        Map<String, String> bankResponseFieldMap = new HashMap<>(64);

        Arrays.stream(URLDecoder.decode(bankResponse, StandardCharsets.UTF_8.name()).split("&"))
                .parallel()
                .forEach(x -> {
                    String[] kvArr = x.split("=");
                    bankResponseFieldMap.put(kvArr[0].trim(), kvArr[1].trim());
                });


//                .map(x -> x.split("="))
//                .collect(Collectors.toMap(k -> k[0], v -> v[1]));

        System.out.println(bankResponseFieldMap);
        System.out.println(bankResponseFieldMap.get("z1"));
    }
}
