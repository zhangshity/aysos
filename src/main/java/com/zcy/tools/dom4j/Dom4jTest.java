package com.zcy.tools.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Dom4jTest {
    public static void main(String[] args) throws DocumentException {
        String xml = "<xml>\n" +
                "    <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "    <return_msg><![CDATA[OK]]></return_msg>\n" +
                "    <appid><![CDATA[wx0dd3d8d451dd4907]]></appid>\n" +
                "    <mch_id><![CDATA[1499429942]]></mch_id>\n" +
                "    <sub_mch_id><![CDATA[321085262]]></sub_mch_id>\n" +
                "    <nonce_str><![CDATA[LYfJ5VzdagQ4sMJ7]]></nonce_str>\n" +
                "    <sign><![CDATA[36DBDB6892C462AA09B70FF984DF2663]]></sign>\n" +
                "    <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "    <openid><![CDATA[oM0WUwnlI7SzBDbznWQkfToFt59s]]></openid>\n" +
                "    <is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "    <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "    <bank_type><![CDATA[CITIC_DEBIT]]></bank_type>\n" +
                "    <total_fee>90000</total_fee>\n" +
                "    <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "    <transaction_id><![CDATA[4200000696202009208833664595]]></transaction_id>\n" +
                "    <out_trade_no><![CDATA[200920225106457168933]]></out_trade_no>\n" +
                "    <attach><![CDATA[200920225106457168933]]></attach>\n" +
                "    <time_end><![CDATA[20200920225115]]></time_end>\n" +
                "    <trade_state><![CDATA[SUCCESS]]></trade_state>\n" +
                "    <cash_fee>90000</cash_fee>\n" +
                "    <trade_state_desc><![CDATA[支付成功]]></trade_state_desc>\n" +
                "    <cash_fee_type><![CDATA[CNY]]></cash_fee_type>\n" +
                "    <rate><![CDATA[87520000]]></rate>\n" +
                "</xml>";
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        String totalFee = root.element("total_fee").getText();
        String feeType = root.elementText("fee_type");
        String feeType1 = root.elementText("fee_type1");

        String returnCode = root.attributeValue("return_code");
        String returnMsg = root.attributeValue("return_code");

        System.out.println(totalFee);
        System.out.println(feeType);
        System.out.println(feeType1);

        System.out.println(returnCode);
        System.out.println(returnMsg);



        //=========================================================测试2===============================
        String xml2 = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <SOAP-ENV:Header/>\n" +
                "    <SOAP-ENV:Body>\n" +
                "        <ipgapi:IPGApiActionResponse xmlns:a1=\"http://ipg-online.com/ipgapi/schemas/a1\"\n" +
                "            xmlns:ipgapi=\"http://ipg-online.com/ipgapi/schemas/ipgapi\"\n" +
                "            xmlns:v1=\"http://ipg-online.com/ipgapi/schemas/v1\">\n" +
                "            <ipgapi:successfully>true</ipgapi:successfully>\n" +
                "            <ipgapi:OrderId>201126165957910285014</ipgapi:OrderId>\n" +
                "            <v1:Billing>\n" +
                "                <v1:Name>Poyi Liao</v1:Name>\n" +
                "                <v1:MobilePhone>NULL</v1:MobilePhone>\n" +
                "            </v1:Billing>\n" +
                "            <v1:Shipping/>\n" +
                "            <a1:TransactionValues>\n" +
                "                <v1:CreditCardTxType>\n" +
                "                    <v1:Type>payer auth</v1:Type>\n" +
                "                </v1:CreditCardTxType>\n" +
                "                <v1:CreditCardData>\n" +
                "                    <v1:CardNumber>528946...0546</v1:CardNumber>\n" +
                "                    <v1:ExpMonth>09</v1:ExpMonth>\n" +
                "                    <v1:ExpYear>25</v1:ExpYear>\n" +
                "                    <v1:Brand>MASTERCARD</v1:Brand>\n" +
                "                </v1:CreditCardData>\n" +
                "                <v1:Payment>\n" +
                "                    <v1:ChargeTotal>1864</v1:ChargeTotal>\n" +
                "                    <v1:Currency>344</v1:Currency>\n" +
                "                </v1:Payment>\n" +
                "                <v1:TransactionDetails>\n" +
                "                    <v1:OrderId>201126165957910285014</v1:OrderId>\n" +
                "                    <v1:MerchantTransactionId>201126165957910285014</v1:MerchantTransactionId>\n" +
                "                    <v1:TDate>1606381219</v1:TDate>\n" +
                "                    <v1:TransactionOrigin>ECI</v1:TransactionOrigin>\n" +
                "                </v1:TransactionDetails>\n" +
                "                <ipgapi:IPGApiOrderResponse>\n" +
                "                    <ipgapi:ApprovalCode>?:waiting 3dsecure</ipgapi:ApprovalCode>\n" +
                "                    <ipgapi:Brand>MASTERCARD</ipgapi:Brand>\n" +
                "                    <ipgapi:Country>HKG</ipgapi:Country>\n" +
                "                    <ipgapi:OrderId>201126165957910285014</ipgapi:OrderId>\n" +
                "                    <ipgapi:IpgTransactionId>69819415276</ipgapi:IpgTransactionId>\n" +
                "                    <ipgapi:PaymentType>CREDITCARD</ipgapi:PaymentType>\n" +
                "                    <ipgapi:ReferencedTDate>1606381219</ipgapi:ReferencedTDate>\n" +
                "                    <ipgapi:TDate>1606381219</ipgapi:TDate>\n" +
                "                    <ipgapi:TDateFormatted>2020.11.26 14:30:19 (IST)</ipgapi:TDateFormatted>\n" +
                "                </ipgapi:IPGApiOrderResponse>\n" +
                "                <a1:Brand>MASTERCARD</a1:Brand>\n" +
                "                <a1:TransactionType>PAYER_AUTH</a1:TransactionType>\n" +
                "                <a1:TransactionState>WAITING_3D_SECURE</a1:TransactionState>\n" +
                "                <a1:UserID>1</a1:UserID>\n" +
                "                <a1:SubmissionComponent>API</a1:SubmissionComponent>\n" +
                "            </a1:TransactionValues>\n" +
                "        </ipgapi:IPGApiActionResponse>\n" +
                "    </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";


        String bankResponseCode = null;
        String bankTxStatus = null;
        String bankTxAmount = null;
        String bankTxCurrencyCode = null;
        String tranReturnCode = null;
        String tranInfo = null;
        //==================
        Document document2 = DocumentHelper.parseText(xml2);
        Element root2 = document2.getRootElement();
        Element ipgApiActionResponse = Optional.ofNullable(root2.element("Body")).map(x -> x.element("IPGApiActionResponse")).orElse(null);
        // 银行响应码
        bankResponseCode = Optional.ofNullable(ipgApiActionResponse).map(x -> x.elementText("successfully")).orElse(null);
        if ("true".equals(bankResponseCode)) {
            List<Element> transactionValuesList = ipgApiActionResponse.elements("TransactionValues");
            // 判断报文TransactionValues节点,是否有多条数据,如为多条取最后一条的数据
            if (transactionValuesList != null && transactionValuesList.size() > 1) {
                bankTxStatus = transactionValuesList.get(transactionValuesList.size() - 1).elementText("TransactionState");
                bankTxAmount = Optional.ofNullable(transactionValuesList.get(transactionValuesList.size() - 1).element("Payment")).map(x -> x.elementText("ChargeTotal")).orElse(null);
                bankTxCurrencyCode = Optional.ofNullable(transactionValuesList.get(transactionValuesList.size() - 1).element("Payment")).map(x -> x.elementText("Currency")).orElse(null);
                // ApprovalCode':'分隔,数组长度>=3,tranReturnCode取前两个,tranInfo取剩余的,数组长度<3直接tranReturnCode/info均取原始值
                List<String> approvalCodeList = Optional.ofNullable(transactionValuesList.get(transactionValuesList.size() - 1).element("IPGApiOrderResponse")).map(x -> x.elementText("ApprovalCode")).map(x -> Arrays.asList(x.split(":"))).orElse(null);
                tranReturnCode = approvalCodeList != null && approvalCodeList.size() >= 3 ? approvalCodeList.get(0) + ":" + approvalCodeList.get(1) : approvalCodeList != null ? String.join(":", approvalCodeList) : null;
                tranInfo = approvalCodeList != null && approvalCodeList.size() >= 3 ? String.join(":", approvalCodeList.subList(2, approvalCodeList.size())) : approvalCodeList != null ? String.join(":", approvalCodeList) : null;
            } else if (transactionValuesList != null && transactionValuesList.size() == 1) {
                bankTxStatus = transactionValuesList.get(0).elementText("TransactionState");
                bankTxAmount = Optional.ofNullable(transactionValuesList.get(0).element("Payment")).map(x -> x.elementText("ChargeTotal")).orElse(null);
                bankTxCurrencyCode = Optional.ofNullable(transactionValuesList.get(0).element("Payment")).map(x -> x.elementText("Currency")).orElse(null);
                // ApprovalCode':'分隔,数组长度>=3,tranReturnCode取前两个,tranInfo取剩余的,数组长度<3直接tranReturnCode/info均取原始值
                List<String> approvalCodeList = Optional.ofNullable(transactionValuesList.get(0).element("IPGApiOrderResponse")).map(x -> x.elementText("ApprovalCode")).map(x -> Arrays.asList(x.split(":"))).orElse(null);
                tranReturnCode = approvalCodeList != null && approvalCodeList.size() >= 3 ? approvalCodeList.get(0) + ":" + approvalCodeList.get(1) : approvalCodeList != null ? String.join(":", approvalCodeList) : null;
                tranInfo = approvalCodeList != null && approvalCodeList.size() >= 3 ? String.join(":", approvalCodeList.subList(2, approvalCodeList.size())) : approvalCodeList != null ? String.join(":", approvalCodeList) : null;
            }
        }

        System.out.println("========================================");
        System.out.println(bankResponseCode);
        System.out.println(bankTxStatus);
        System.out.println(bankTxAmount);
        System.out.println(bankTxCurrencyCode);
        System.out.println(tranReturnCode);
        System.out.println(tranInfo);





    }
}
