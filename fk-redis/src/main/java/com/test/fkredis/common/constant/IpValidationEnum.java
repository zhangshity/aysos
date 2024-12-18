package com.test.fkredis.common.constant;

/**
 * 状态枚举
 * <p>Title: </p>
 * <p>Description: 零散的状态和标志整合</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-02 09:25:45
 */
public enum IpValidationEnum {

    /**
     * 终端号-开启IP校验
     */
    ENABLE(1),

    /**
     * 终端号-关闭IP校验
     */
    DISABLE(0),
    ;

    private final Integer flag;

    IpValidationEnum(Integer flag) {
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }
}
