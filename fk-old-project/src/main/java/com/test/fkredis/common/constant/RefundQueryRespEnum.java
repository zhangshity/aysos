package com.test.fkredis.common.constant;

/**
 * 退款信息查询API响应信息枚举
 * <p>Title: </p>
 * <p>Description: 响应信息枚举</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-02 11:25:45
 */
public enum RefundQueryRespEnum {

    /**
     * 已退款
     */
    REFUNDED("00", "Refunded"),

    /**
     * 审核成功未处理
     */
    AUDIT_SUCCESSFUL_NOT_PROCESSED("01", "Audit Success untreated"),

    /**
     * 待审核
     */
    TO_BE_AUDITED("02", "Pending"),

    /**
     * 审核失败
     */
    AUDIT_FAILURE("03", "Audit failure"),

    /**
     * 退款记录不存在
     */
    REFUND_RECORD_DOES_NOT_EXIST("04", "Refund ID does not exist"),

    /**
     * 签名不匹配
     */
    SIGNATURE_MISMATCH("05", "Error signature information"),

    /**
     * IP未登记
     */
    IP_NOT_REGISTERED("06", "Incorrect registered IP address, Your ip address is %s"),

    /**
     * 没有交易记录
     */
    NO_TRANSACTION_RECORD("92", "No transaction record on file"),

    /**
     * 无效的退款编号
     */
    INVALID_REFUND_ID("93", "Invalid Refund ID"),

    /**
     * 无效账户
     */
    INVALID_ACCOUNT("94", "Invalid Account"),

    /**
     * 无效终端号
     */
    INVALID_TERMINAL("95", "Invalid Terminal"),

    /**
     * 传入参数不全或有误
     */
    INVALID_PARAMETER("96", "Parameter passing is insufficient, empty or error parameters"),

    /**
     * 无此交易
     */
    NO_PAYMENT_DATA("97", "No payment data"),

    /**
     * 传入对象为空
     */
    INCORRECT_PARAMETER_TRANSMISSION("98", "Incorrect parameter transmission"),

    /**
     * 查询退款发生异常
     */
    SYSTEM_ERROR("99", "System error"),

    /**
     * 空账户号
     */
    EMPTY_ACCOUNT("100", "Account cannot be empty"),

    /**
     * 空终端号
     */
    EMPTY_TERMINAL("101", "Terminal cannot be empty"),

    /**
     * 退款ID和商户退款ID均为空
     */
    BOTH_REFUND_ID_AND_MERCHANT_REFUND_ID_ARE_EMPTY("102", "Refund ID cannot be empty"),

    /**
     * 无效商户退款号
     */
    INVALID_MERCHANT_REFUND_ID("103", "Incorrect refund_number");
    ;

    private final String code;

    private final String description;

    RefundQueryRespEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
