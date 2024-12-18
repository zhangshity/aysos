package com.test.fkredis.common.constant;

/**
 * 退款申请API响应信息枚举
 * <p>Title: </p>
 * <p>Description: 响应信息枚举</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-02 11:33:45
 */
public enum RefundApplicationErrorEnum {

    /**
     * 退款申请成功
     */
    REFUNDED("00", "Refunded"),

    /**
     * 传入对象为空
     */
    INCORRECT_PARAMETER_TRANSMISSION("01", "Incorrect parameter transmission"),

    /**
     * 访问ip错误
     */
    INCORRECT_REGISTERED_IP("03", "Incorrect registered IP address"),

    /**
     * 传入参数不全
     */
    INSUFFICIENT_PARAMETER_TRANSMISSION("04", "Insufficient parameter transmission"),

    /**
     * 账户号错误
     */
    INVALID_ACCOUNT("05", "Invalid Account"),

    /**
     * 终端号错误
     */
    INVALID_TERMINAL("06", "Invalid Terminal"),

    /**
     * 支付ID格式错误
     */
    INCORRECT_PAYMENT_ID_FORMAT("08", "Incorrect format of payment_id"),

    /**
     * 退款金额大于交易金额
     */
    REFUND_AMOUNT_OVER_ORDER_AMOUNT("09", "Refund amount over order amount"),


    /**
     * 退款类型设置错误
     */
    INCORRECT_REFUND_TYPE("10", "Incorrect refund type"),

    /**
     * 退款信息参数错误
     */
    INCORRECT_REFUND_PARAMETER("11", "Incorrect refund parameter"),

    /**
     * 签名信息错误
     */
    WRONG_SIGNATURE("12", "Incorrect SHA256"),

    /**
     * 订单状态非成功，不可申请退款
     */
    FAILED_TX_ARE_NONREFUNDABLE("13", "Failed transaction,can not apply for refund"),

    /**
     * 订单已冻结，不可申请退款
     */
    FROZEN_TX_ARE_NONREFUNDABLE("14", "Transaction suspended,can not apply for refund"),

    /**
     * 交易金额不正确
     */
    WRONG_AMOUNT("15", "Incorrect order amount"),

    /**
     * 币种不正确
     */
    WRONG_CURRENCY("16", "Incorrect order currency"),

    /**
     * 保证金已制表，不可申请退款
     */
    SETTLED_ROLLING_RESERVE_TX_ARE_NONREFUNDABLE("17", "Rolling reserve is being settled, can not apply for refund"),

    /**
     * 退款金额格式不正确
     */
    WRONG_REFUND_AMOUNT_FORMAT("18", "Incorrect refund_amount format"),

    /**
     * 退款金额和退款类型不符
     */
    REFUND_AMOUNT_AND_TYPE_DO_NOT_MATCH("19", "Incorrect refund amount and refund type"),

    /**
     * 该通道不支持部分退款
     */
    PARTIAL_REFUND_IS_NOT_SUPPORTED("20", "Partial refund is not supported"),

    /**
     * 划款已处理，不能退款
     */
    SETTLED_PAYMENT_TX_ARE_NONREFUNDABLE("21", "payment is being settled, can not apply for refund"),

    /**
     * 交易金额格式不正确
     */
    WRONG_ORDER_AMOUNT_FORMAT("22", "Incorrect order amount format"),

    /**
     * 退款原因长度过长
     */
    REFUND_DESCRIPTION_OVER_LENGTH("23", "refund description over length"),

    /**
     * 交易未对账,不可申请退款
     */
    WAITING_FOR_PAYMENT_STATUS_CHECKED("24", "waiting for payment status checked"),

    /**
     * 退款金额大于可退金额，不可申请退款
     */
    REFUND_AMOUNT_OVER_REFUNDABLE_AMOUNT("25", "refund_amount over refundable amount"),

    /**
     *
     */
    ACCOUNT_CANNOT_BE_EMPTY("26", "Account cannot be empty	账户不能为空"),

    /**
     * 终端号不能为空
     */
    TERMINAL_CANNOT_BE_EMPTY("27", "Terminal cannot be empty"),

    /**
     * 支付ID不能为空
     */
    PAYMENT_ID_CANNOT_BE_EMPTY("28", "Payment_id cannot be empty"),

    /**
     * 退款原因说明不能为空
     */
    REFUND_DESCRIPTION_CANNOT_BE_EMPTY("29", "Refund_description cannot be empty"),

    /**
     * 退款金额不能为空
     */
    REFUND_AMOUNT_CANNOT_BE_EMPTY("30", "Refund_amount cannot be empty"),

    /**
     * 无此交易
     */
    NO_PAYMENT_DATA("98", "No payment data"),

    /**
     * 申请退款发生异常
     */
    SYSTEM_ERROR("99", "No payment data"),
    ;

    private final String code;

    private final String description;

    RefundApplicationErrorEnum(String code, String description) {
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
