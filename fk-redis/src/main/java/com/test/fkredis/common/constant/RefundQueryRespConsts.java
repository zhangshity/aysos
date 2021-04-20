package com.test.fkredis.common.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 退款信息查询API响应信息
 * <p>Title: RefundQueryRespConsts
 * <p>Description: 响应码码和响应信息映射
 * <p>Copyright: Copyright (c) 2021 版权
 * <p>Company: Oceanpayment
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-04-07 15:48:59
 */
public class RefundQueryRespConsts {

    /**
     * 已退款
     */
    public static final String REFUNDED = "00";

    /**
     * 审核成功未处理
     */
    public static final String AUDIT_SUCCESSFUL_NOT_PROCESSED = "01";

    /**
     * 待审核
     */
    public static final String TO_BE_AUDITED = "02";

    /**
     * 审核失败
     */
    public static final String AUDIT_FAILURE = "03";

    /**
     * 退款记录不存在
     */
    public static final String REFUND_RECORD_DOES_NOT_EXIST = "04";

    /**
     * 签名不匹配
     */
    public static final String SIGNATURE_MISMATCH = "05";

    /**
     * IP未登记
     */
    public static final String IP_NOT_REGISTERED = "06";

    /**
     * 没有交易记录
     */
    public static final String NO_TRANSACTION_RECORD = "92";

    /**
     * 无效的退款编号
     */
    public static final String INVALID_REFUND_ID = "93";

    /**
     * 无效账户
     */
    public static final String INVALID_ACCOUNT = "94";

    /**
     * 无效终端号
     */
    public static final String INVALID_TERMINAL = "95";

    /**
     * 传入参数不全或有误
     */
    public static final String INVALID_PARAMETER = "96";

    /**
     * 无此交易
     */
    public static final String NO_PAYMENT_DATA = "97";

    /**
     * 传入对象为空
     */
    public static final String INCORRECT_PARAMETER_TRANSMISSION = "98";

    /**
     * 查询退款发生异常
     */
    public static final String SYSTEM_ERROR = "99";

    /**
     * 空账户号
     */
    public static final String EMPTY_ACCOUNT = "100";

    /**
     * 空终端号
     */
    public static final String EMPTY_TERMINAL = "101";

    /**
     * 退款ID和商户退款ID均为空
     */
    public static final String BOTH_REFUND_ID_AND_MERCHANT_REFUND_ID_ARE_EMPTY = "102";

    /**
     * 无效商户退款号
     */
    public static final String INVALID_MERCHANT_REFUND_ID = "103";

    /**
     * 退款错误码映射表
     */
    public static final Map<String, String> REFUND_ERROR_MAP;
    static {
        Map<String, String> map = new HashMap<>(32);
        map.put("00", "Refunded");
        map.put("01", "Audit Success untreated");
        map.put("02", "Pending");
        map.put("03", "Audit failure");
        map.put("04", "Refund ID does not exist");
        map.put("05", "Error signature information");
        map.put("06", "Incorrect registered IP address, Your ip address is %s");
        map.put("92", "No transaction record on file");
        map.put("93", "Invalid Refund ID");
        map.put("94", "Invalid Account");
        map.put("95", "Invalid Terminal");
        map.put("96", "Parameter passing is insufficient, empty or error parameters");
        map.put("97", "No payment data");
        map.put("98", "Incorrect parameter transmission");
        map.put("99", "System error");
        map.put("100", "Account cannot be empty");
        map.put("101", "Terminal cannot be empty");
        map.put("102", "Refund ID cannot be empty");
        map.put("103", "Incorrect refund_number");
        REFUND_ERROR_MAP = Collections.unmodifiableMap(map);
    }
}
