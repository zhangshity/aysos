package com.test.fkredis.common.constant;

/**
 * 异常交易处理状态常量
 * <p>Title: AbnormalTrxnProcessingStatusConsts
 * <p>Description: -1:失败  0:待审核  1:审核成功未处理  2:审核成功已处理
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-04-01 11:54
 */
public class AbnormalTrxnProcessingStatusConsts {

    /**
     * 失败
     */
    public static final int FAILURE = -1;

    /**
     * 待审核
     */
    public static final int TO_BE_AUDITED = 0;

    /**
     * 审核成功未处理
     */
    public static final int AUDIT_SUCCESSFUL_NOT_PROCESSED = 1;

    /**
     * 审核成功已处理
     */
    public static final int AUDIT_SUCCESSFUL_ALREADY_PROCESSED = 2;
}
