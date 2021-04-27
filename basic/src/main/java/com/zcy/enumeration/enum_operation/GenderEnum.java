package com.zcy.enumeration.enum_operation;

import java.util.HashMap;
import java.util.Map;


public enum GenderEnum {

    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(0, "女")
    ;

    private final Integer code;

    private final String description;

    GenderEnum(Integer code, String description) {
        this.code = code;
        this.description = description;

    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }




    // -----------------------------------------------------------------------
    // code description 映射获取
    private final static Map<Integer, String> code_description_map = new HashMap<>(32);
    static {
        for (GenderEnum e : GenderEnum.values()) {
            code_description_map.put(e.code, e.description);
        }
    }

    public static String parse(Integer code) {
        return code_description_map.getOrDefault(code, null);
    }





    // -----------------------------------------------------------------------
    // 枚举Enum 和 description获取
    private final static Map<GenderEnum, String> enum_map = new HashMap<>(32);
    static {
        for (GenderEnum e : GenderEnum.values()) {
            enum_map.put(e, e.description);
        }
    }

    public static String parse(GenderEnum genderEnum) {
        return enum_map.getOrDefault(genderEnum, null);
    }
}

