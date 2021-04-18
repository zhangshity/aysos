package com.zcy.enumeration;

public enum ChannelTypeEnum {
    //请求通道类型（1：交易，2：3D，3：预授权，4：退款，5：3D推送，6：交易推送, 7:预授权撤销, 8:预授权完成, 9:交易撤销, 10:交易查询）

    TRANSACTION(1, "交易"),

    TRANSACTION_3D(2, "3D交易"),

    PRE_AUTHORIZATION(3, "预授权"),

    REFUND(4, "退款"),

    NOTIFICATION_3D_TX(5, "3D推送"),

    NOTIFICATION_TX(6, "交易推送"),

    PRE_AUTH_VOID(7, "预授权撤销"),

    PRE_AUTH_CAPTURE(8, "预授权完成"),

    TX_CANCELLATION(9, "交易撤销"),

    RECONCILIATION(10, "交易查询");

    private Integer code;

    private String message;

    private ChannelTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
