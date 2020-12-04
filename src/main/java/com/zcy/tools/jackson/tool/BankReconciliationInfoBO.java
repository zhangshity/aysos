package com.zcy.tools.jackson.tool;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class BankReconciliationInfoBO {

    /**
     * 银行方返回流水订单号
     */
    private String bankTradeNo;

    /**
     * 银行方此笔交易状态
     */
    private Integer bankTransactionStatus;

    /**
     * 银行方此笔交易币种
     */
    private String bankTransactionCurrency;

    /**
     * 银行方此笔交易金额
     */
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal bankTransactionAmount;

    /**
     * 银行返回码
     */
    private String bankReturnCode;

    /**
     * 银行返回信息
     */
    private String bankInfo;


    /**
     * 银行代码
     */
    private String bankCode;

    /**
     * 银行返回交易信息
     */
    private String bankMessage;

    /**
     * 请求返回代码
     */
    private String responseCode;

    /**
     * 返回银行查询号
     */
    private String responseQueryNo;

    /**
     * 银行返回的描述
     */
    private String errorInfo;

    /**
     * 返回银行交易时间
     */
    private String tradeDate;


    public String getBankTradeNo() {
        return bankTradeNo;
    }

//    public void setBankTradeNo(String bankTradeNo) {
//        this.bankTradeNo = bankTradeNo;
//    }

    public Integer getBankTransactionStatus() {
        return bankTransactionStatus;
    }

    public void setBankTransactionStatus(Integer bankTransactionStatus) {
        this.bankTransactionStatus = bankTransactionStatus;
    }

    public String getBankTransactionCurrency() {
        return bankTransactionCurrency;
    }

    public void setBankTransactionCurrency(String bankTransactionCurrency) {
        this.bankTransactionCurrency = bankTransactionCurrency;
    }

    public BigDecimal getBankTransactionAmount() {
        return bankTransactionAmount;
    }

//    public void setBankTransactionAmount(BigDecimal bankTransactionAmount) {
//        this.bankTransactionAmount = bankTransactionAmount;
//    }

    public String getBankReturnCode() {
        return bankReturnCode;
    }

    public void setBankReturnCode(String bankReturnCode) {
        this.bankReturnCode = bankReturnCode;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankMessage() {
        return bankMessage;
    }

    public void setBankMessage(String bankMessage) {
        this.bankMessage = bankMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseQueryNo() {
        return responseQueryNo;
    }

    public void setResponseQueryNo(String responseQueryNo) {
        this.responseQueryNo = responseQueryNo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Override
    public String toString() {
        return "BankReconciliationInfoBO{" +
                "bankTradeNo='" + bankTradeNo + '\'' +
                ", bankTransactionStatus=" + bankTransactionStatus +
                ", bankTransactionCurrency='" + bankTransactionCurrency + '\'' +
                ", bankTransactionAmount=" + bankTransactionAmount +
                ", bankReturnCode='" + bankReturnCode + '\'' +
                ", bankInfo='" + bankInfo + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankMessage='" + bankMessage + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", responseQueryNo='" + responseQueryNo + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                '}';
    }


    public BankReconciliationInfoBO setBankTradeNo(String bankTradeNo) {
        this.bankTradeNo = bankTradeNo;
        return this;
    }

    public BankReconciliationInfoBO setBankTransactionAmount(BigDecimal bankTransactionAmount) {
        this.bankTransactionAmount = bankTransactionAmount;
        return this;
    }
}
