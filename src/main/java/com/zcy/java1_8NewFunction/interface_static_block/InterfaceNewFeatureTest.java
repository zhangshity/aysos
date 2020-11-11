package com.zcy.java1_8NewFunction.interface_static_block;

import java.util.HashMap;
import java.util.Map;

public interface InterfaceNewFeatureTest {

    Map<String, String> CREDIT_CARD_RESPONSE_CODE_MAP = new HashMap<>();

//    static {
//        CREDIT_CARD_RESPONSE_CODE_MAP.put("00", "Approved or completed successfully");
//        CREDIT_CARD_RESPONSE_CODE_MAP.put("01", "Refer to card issuer");
//    }
}
