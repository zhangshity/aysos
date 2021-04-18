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
        System.out.println("=========================================================测试2===============================");
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



        //=========================================================测试3===============================
        System.out.println("=========================================================测试3===============================");
        String xml3 = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<alipay>\n" +
                "    <is_success>T</is_success>\n" +
                "    <request>\n" +
                "        <param name=\"partner_trans_id\">201207152001584151024</param>\n" +
                "        <param name=\"partner\">2088331370005945</param>\n" +
                "        <param name=\"service\">alipay.acquire.overseas.query</param>\n" +
                "        <param name=\"_input_charset\">UTF-8</param>\n" +
                "        <param name=\"sign\">45cc17a9e1491fc5126f492713aab03c</param>\n" +
                "        <param name=\"sign_type\">MD5</param>\n" +
                "    </request>\n" +
                "    <response>\n" +
                "        <alipay>\n" +
                "            <alipay_buyer_login_id>132****6685</alipay_buyer_login_id>\n" +
                "            <alipay_buyer_user_id>2088112549401700</alipay_buyer_user_id>\n" +
                "            <alipay_pay_time>20201207152003</alipay_pay_time>\n" +
                "            <alipay_trans_id>2020120722001401701436761112</alipay_trans_id>\n" +
                "            <alipay_trans_status>TRADE_SUCCESS</alipay_trans_status>\n" +
                "            <currency>HKD</currency>\n" +
                "            <out_trade_no>201207152001584151024</out_trade_no>\n" +
                "            <partner_trans_id>201207152001584151024</partner_trans_id>\n" +
                "            <payment_inst>ALIPAYCN</payment_inst>\n" +
                "            <result_code>SUCCESS</result_code>\n" +
                "            <trans_amount>3997.60</trans_amount>\n" +
                "        </alipay>\n" +
                "    </response>\n" +
                "    <sign>0caa280a9d93707d30059f551ca8c4bc</sign>\n" +
                "    <sign_type>MD5</sign_type>\n" +
                "</alipay>";

        Document document3 = DocumentHelper.parseText(xml3);
        Element root3 = document3.getRootElement();

        Element response = root3.element("response");
        System.out.println(response);

        Element testNotExist = root3.element("good");
        System.out.println(testNotExist);




        //=========================================================测试4===============================
        System.out.println("=========================================================测试4===============================");
        String xml4 = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <SOAP-ENV:Header/>\n" +
                "    <SOAP-ENV:Body>\n" +
                "        <ipgapi:IPGApiActionResponse xmlns:a1=\"http://ipg-online.com/ipgapi/schemas/a1\"\n" +
                "            xmlns:ipgapi=\"http://ipg-online.com/ipgapi/schemas/ipgapi\"\n" +
                "            xmlns:v1=\"http://ipg-online.com/ipgapi/schemas/v1\">\n" +
                "            <ipgapi:successfully>true</ipgapi:successfully>\n" +
                "            <ipgapi:OrderId>201112182608368082669</ipgapi:OrderId>\n" +
                "            <v1:Billing/>\n" +
                "            <v1:Shipping/>\n" +
                "            <a1:TransactionValues>\n" +
                "                <v1:CreditCardTxType>\n" +
                "                    <v1:Type>payer auth</v1:Type>\n" +
                "                </v1:CreditCardTxType>\n" +
                "                <v1:CreditCardData>\n" +
                "                    <v1:CardNumber>621486...0559</v1:CardNumber>\n" +
                "                    <v1:ExpMonth>03</v1:ExpMonth>\n" +
                "                    <v1:ExpYear>30</v1:ExpYear>\n" +
                "                    <v1:Brand>UNIONPAY</v1:Brand>\n" +
                "                </v1:CreditCardData>\n" +
                "                <v1:Payment>\n" +
                "                    <v1:ChargeTotal>1.65</v1:ChargeTotal>\n" +
                "                    <v1:Currency>344</v1:Currency>\n" +
                "                </v1:Payment>\n" +
                "                <v1:TransactionDetails>\n" +
                "                    <v1:OrderId>201112182608368082669</v1:OrderId>\n" +
                "                    <v1:MerchantTransactionId>201112182608368082669</v1:MerchantTransactionId>\n" +
                "                    <v1:TDate>1605176826</v1:TDate>\n" +
                "                    <v1:TransactionOrigin>ECI</v1:TransactionOrigin>\n" +
                "                </v1:TransactionDetails>\n" +
                "                <ipgapi:IPGApiOrderResponse>\n" +
                "                    <ipgapi:ApprovalCode>Y:ECI9:Authenticated</ipgapi:ApprovalCode>\n" +
                "                    <ipgapi:Brand>UNIONPAY</ipgapi:Brand>\n" +
                "                    <ipgapi:Country>CHN</ipgapi:Country>\n" +
                "                    <ipgapi:OrderId>201112182608368082669</ipgapi:OrderId>\n" +
                "                    <ipgapi:IpgTransactionId>69712239114</ipgapi:IpgTransactionId>\n" +
                "                    <ipgapi:PayerSecurityLevel>1</ipgapi:PayerSecurityLevel>\n" +
                "                    <ipgapi:PaymentType>CREDITCARD</ipgapi:PaymentType>\n" +
                "                    <ipgapi:ProcessorApprovalCode>ECI9</ipgapi:ProcessorApprovalCode>\n" +
                "                    <ipgapi:ReferencedTDate>1605176826</ipgapi:ReferencedTDate>\n" +
                "                    <ipgapi:TDate>1605176826</ipgapi:TDate>\n" +
                "                    <ipgapi:TDateFormatted>2020.11.12 15:57:06 (IST)</ipgapi:TDateFormatted>\n" +
                "                </ipgapi:IPGApiOrderResponse>\n" +
                "                <a1:Brand>CUP</a1:Brand>\n" +
                "                <a1:TransactionType>PAYER_AUTH</a1:TransactionType>\n" +
                "                <a1:TransactionState>TEMPLATE</a1:TransactionState>\n" +
                "                <a1:UserID>1</a1:UserID>\n" +
                "                <a1:SubmissionComponent>API</a1:SubmissionComponent>\n" +
                "            </a1:TransactionValues>\n" +
                "            <a1:TransactionValues>\n" +
                "                <v1:CreditCardTxType>\n" +
                "                    <v1:Type>sale</v1:Type>\n" +
                "                </v1:CreditCardTxType>\n" +
                "                <v1:CreditCardData>\n" +
                "                    <v1:CardNumber>621486...0559</v1:CardNumber>\n" +
                "                    <v1:ExpMonth>03</v1:ExpMonth>\n" +
                "                    <v1:ExpYear>30</v1:ExpYear>\n" +
                "                    <v1:Brand>UNIONPAY</v1:Brand>\n" +
                "                </v1:CreditCardData>\n" +
                "                <v1:Payment>\n" +
                "                    <v1:ChargeTotal>1.62</v1:ChargeTotal>\n" +
                "                    <v1:Currency>344</v1:Currency>\n" +
                "                </v1:Payment>\n" +
                "                <v1:TransactionDetails>\n" +
                "                    <v1:OrderId>201112182608368082669</v1:OrderId>\n" +
                "                    <v1:TDate>1605176842</v1:TDate>\n" +
                "                    <v1:TransactionOrigin>ECI</v1:TransactionOrigin>\n" +
                "                </v1:TransactionDetails>\n" +
                "                <ipgapi:IPGApiOrderResponse>\n" +
                "                    <ipgapi:ApprovalCode>Y:000000:9712240479:PPX :031710625390</ipgapi:ApprovalCode>\n" +
                "                    <ipgapi:AVSResponse>PPX</ipgapi:AVSResponse>\n" +
                "                    <ipgapi:Brand>UNIONPAY</ipgapi:Brand>\n" +
                "                    <ipgapi:Country>CHN</ipgapi:Country>\n" +
                "                    <ipgapi:OrderId>201112182608368082669</ipgapi:OrderId>\n" +
                "                    <ipgapi:IpgTransactionId>69712240479</ipgapi:IpgTransactionId>\n" +
                "                    <ipgapi:PayerSecurityLevel>1</ipgapi:PayerSecurityLevel>\n" +
                "                    <ipgapi:PaymentType>CREDITCARD</ipgapi:PaymentType>\n" +
                "                    <ipgapi:ProcessorApprovalCode>000000</ipgapi:ProcessorApprovalCode>\n" +
                "                    <ipgapi:ProcessorCCVResponse></ipgapi:ProcessorCCVResponse>\n" +
                "                    <ipgapi:ReferencedTDate>1605176842</ipgapi:ReferencedTDate>\n" +
                "                    <ipgapi:TDate>1605176842</ipgapi:TDate>\n" +
                "                    <ipgapi:TDateFormatted>2020.11.12 15:57:22 (IST)</ipgapi:TDateFormatted>\n" +
                "                    <ipgapi:TerminalID>51038670</ipgapi:TerminalID>\n" +
                "                </ipgapi:IPGApiOrderResponse>\n" +
                "                <a1:ReceiptNumber>6253</a1:ReceiptNumber>\n" +
                "                <a1:TraceNumber>031710</a1:TraceNumber>\n" +
                "                <a1:Brand>CUP</a1:Brand>\n" +
                "                <a1:TransactionType>SALE</a1:TransactionType>\n" +
                "                <a1:TransactionState>CAPTURED</a1:TransactionState>\n" +
                "                <a1:UserID>1</a1:UserID>\n" +
                "                <a1:SubmissionComponent>API</a1:SubmissionComponent>\n" +
                "            </a1:TransactionValues>\n" +
                "            <a1:TransactionValues>\n" +
                "                <v1:CreditCardTxType>\n" +
                "                    <v1:Type>return</v1:Type>\n" +
                "                </v1:CreditCardTxType>\n" +
                "                <v1:CreditCardData>\n" +
                "                    <v1:CardNumber>621486...0559</v1:CardNumber>\n" +
                "                    <v1:ExpMonth>03</v1:ExpMonth>\n" +
                "                    <v1:ExpYear>30</v1:ExpYear>\n" +
                "                    <v1:Brand>UNIONPAY</v1:Brand>\n" +
                "                </v1:CreditCardData>\n" +
                "                <v1:Payment>\n" +
                "                    <v1:ChargeTotal>1.1</v1:ChargeTotal>\n" +
                "                    <v1:Currency>344</v1:Currency>\n" +
                "                </v1:Payment>\n" +
                "                <v1:TransactionDetails>\n" +
                "                    <v1:OrderId>201112182608368082669</v1:OrderId>\n" +
                "                    <v1:TDate>1605177022</v1:TDate>\n" +
                "                    <v1:TransactionOrigin>ECI</v1:TransactionOrigin>\n" +
                "                </v1:TransactionDetails>\n" +
                "                <ipgapi:IPGApiOrderResponse>\n" +
                "                    <ipgapi:ApprovalCode>Y:000000:9712263913:PPX :031710625526</ipgapi:ApprovalCode>\n" +
                "                    <ipgapi:AVSResponse>PPX</ipgapi:AVSResponse>\n" +
                "                    <ipgapi:Brand>UNIONPAY</ipgapi:Brand>\n" +
                "                    <ipgapi:Country>CHN</ipgapi:Country>\n" +
                "                    <ipgapi:OrderId>201112182608368082669</ipgapi:OrderId>\n" +
                "                    <ipgapi:IpgTransactionId>69712263913</ipgapi:IpgTransactionId>\n" +
                "                    <ipgapi:PaymentType>CREDITCARD</ipgapi:PaymentType>\n" +
                "                    <ipgapi:ProcessorApprovalCode>000000</ipgapi:ProcessorApprovalCode>\n" +
                "                    <ipgapi:ProcessorCCVResponse></ipgapi:ProcessorCCVResponse>\n" +
                "                    <ipgapi:ReferencedTDate>1605177022</ipgapi:ReferencedTDate>\n" +
                "                    <ipgapi:TDate>1605177022</ipgapi:TDate>\n" +
                "                    <ipgapi:TDateFormatted>2020.11.12 16:00:22 (IST)</ipgapi:TDateFormatted>\n" +
                "                    <ipgapi:TerminalID>51038670</ipgapi:TerminalID>\n" +
                "                </ipgapi:IPGApiOrderResponse>\n" +
                "                <a1:ReceiptNumber>6255</a1:ReceiptNumber>\n" +
                "                <a1:TraceNumber>031710</a1:TraceNumber>\n" +
                "                <a1:Brand>CUP</a1:Brand>\n" +
                "                <a1:TransactionType>RETURN</a1:TransactionType>\n" +
                "                <a1:TransactionState>CAPTURED</a1:TransactionState>\n" +
                "                <a1:UserID>1</a1:UserID>\n" +
                "                <a1:SubmissionComponent>API</a1:SubmissionComponent>\n" +
                "            </a1:TransactionValues>\n" +
                "            <a1:TransactionValues>\n" +
                "                <v1:CreditCardTxType>\n" +
                "                    <v1:Type>return</v1:Type>\n" +
                "                </v1:CreditCardTxType>\n" +
                "                <v1:CreditCardData>\n" +
                "                    <v1:CardNumber>621486...0559</v1:CardNumber>\n" +
                "                    <v1:ExpMonth>03</v1:ExpMonth>\n" +
                "                    <v1:ExpYear>30</v1:ExpYear>\n" +
                "                    <v1:Brand>UNIONPAY</v1:Brand>\n" +
                "                </v1:CreditCardData>\n" +
                "                <v1:Payment>\n" +
                "                    <v1:ChargeTotal>0.55</v1:ChargeTotal>\n" +
                "                    <v1:Currency>344</v1:Currency>\n" +
                "                </v1:Payment>\n" +
                "                <v1:TransactionDetails>\n" +
                "                    <v1:OrderId>201112182608368082669</v1:OrderId>\n" +
                "                    <v1:TDate>1605177076</v1:TDate>\n" +
                "                    <v1:TransactionOrigin>ECI</v1:TransactionOrigin>\n" +
                "                </v1:TransactionDetails>\n" +
                "                <ipgapi:IPGApiOrderResponse>\n" +
                "                    <ipgapi:ApprovalCode>Y:000000:9712270716:PPX :031710625578</ipgapi:ApprovalCode>\n" +
                "                    <ipgapi:AVSResponse>PPX</ipgapi:AVSResponse>\n" +
                "                    <ipgapi:Brand>UNIONPAY</ipgapi:Brand>\n" +
                "                    <ipgapi:Country>CHN</ipgapi:Country>\n" +
                "                    <ipgapi:OrderId>201112182608368082669</ipgapi:OrderId>\n" +
                "                    <ipgapi:IpgTransactionId>69712270716</ipgapi:IpgTransactionId>\n" +
                "                    <ipgapi:PaymentType>CREDITCARD</ipgapi:PaymentType>\n" +
                "                    <ipgapi:ProcessorApprovalCode>000000</ipgapi:ProcessorApprovalCode>\n" +
                "                    <ipgapi:ProcessorCCVResponse></ipgapi:ProcessorCCVResponse>\n" +
                "                    <ipgapi:ReferencedTDate>1605177076</ipgapi:ReferencedTDate>\n" +
                "                    <ipgapi:TDate>1605177076</ipgapi:TDate>\n" +
                "                    <ipgapi:TDateFormatted>2020.11.12 16:01:16 (IST)</ipgapi:TDateFormatted>\n" +
                "                    <ipgapi:TerminalID>51038670</ipgapi:TerminalID>\n" +
                "                </ipgapi:IPGApiOrderResponse>\n" +
                "                <a1:ReceiptNumber>6255</a1:ReceiptNumber>\n" +
                "                <a1:TraceNumber>031710</a1:TraceNumber>\n" +
                "                <a1:Brand>CUP</a1:Brand>\n" +
                "                <a1:TransactionType>RETURN</a1:TransactionType>\n" +
                "                <a1:TransactionState>CAPTURED</a1:TransactionState>\n" +
                "                <a1:UserID>1</a1:UserID>\n" +
                "                <a1:SubmissionComponent>API</a1:SubmissionComponent>\n" +
                "            </a1:TransactionValues>\n" +
                "        </ipgapi:IPGApiActionResponse>\n" +
                "    </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";

        String bankResponseCode4 = null;
        String bankTxStatus4 = null;
        String bankTxAmount4 = null;
        String bankTxCurrencyCode4 = null;
        String tranReturnCode4 = null;
        String tranInfo4 = null;
        String bankTxType = null;

        Document document4 = DocumentHelper.parseText(xml4);
        Element root4 = document4.getRootElement();

        Element ipgApiActionResponse4 = Optional.ofNullable(root4.element("Body")).map(x -> x.element("IPGApiActionResponse")).orElse(null);
        // 银行响应码
        bankResponseCode4 = Optional.ofNullable(ipgApiActionResponse4).map(x -> x.elementText("successfully")).orElse(null);
        if ("true".equals(bankResponseCode4)) {
            List<Element> transactionValuesList = ipgApiActionResponse4.elements("TransactionValues");
            // 判断报文TransactionValues节点,是否有多条数据,如为多条取最后一条的数据
            if (transactionValuesList != null && transactionValuesList.size() > 1) {

                // =================================================================================================================================================
                // (!# 最后一条数据的<a1:TransactionType>为Return时向前取值,直到不为Return,取此条数据)
                for (int i = transactionValuesList.size() - 1; i >= 0; i--) {
                    bankTxType = transactionValuesList.get(i).elementText("TransactionType");
                    System.out.println(bankTxType);
                    if (!"RETURN".equals(bankTxType)) {
                        bankTxStatus4 = transactionValuesList.get(i).elementText("TransactionState");
                        bankTxAmount4 = Optional.ofNullable(transactionValuesList.get(i).element("Payment")).map(x -> x.elementText("ChargeTotal")).orElse(null);
                        bankTxCurrencyCode4 = Optional.ofNullable(transactionValuesList.get(i).element("Payment")).map(x -> x.elementText("Currency")).orElse(null);
                        // ApprovalCode':'分隔,数组长度>=3,tranReturnCode取前两个,tranInfo取剩余的,数组长度<3直接tranReturnCode/info均取原始值
                        List<String> approvalCodeList = Optional.ofNullable(transactionValuesList.get(i).element("IPGApiOrderResponse"))
                                .map(x -> x.elementText("ApprovalCode"))
                                .map(x -> Arrays.asList(x.split(":")))
                                .orElse(null);
                        tranReturnCode4 = getTranReturnCode(approvalCodeList);
                        tranInfo4 = getTranInfo(approvalCodeList);
                        break;
                    }
                }
                // =================================================================================================================================================


            } else if (transactionValuesList != null && transactionValuesList.size() == 1) {
                bankTxStatus4 = transactionValuesList.get(0).elementText("TransactionState");
                bankTxAmount4 = Optional.ofNullable(transactionValuesList.get(0).element("Payment")).map(x -> x.elementText("ChargeTotal")).orElse(null);
                bankTxCurrencyCode4 = Optional.ofNullable(transactionValuesList.get(0).element("Payment")).map(x -> x.elementText("Currency")).orElse(null);
                // ApprovalCode':'分隔,数组长度>=3,tranReturnCode取前两个,tranInfo取剩余的,数组长度<3直接tranReturnCode/info均取原始值
                List<String> approvalCodeList = Optional.ofNullable(transactionValuesList.get(0).element("IPGApiOrderResponse"))
                        .map(x -> x.elementText("ApprovalCode"))
                        .map(x -> Arrays.asList(x.split(":")))
                        .orElse(null);
                tranReturnCode4 = getTranReturnCode(approvalCodeList);
                tranInfo4 = getTranInfo(approvalCodeList);
            }
        }


        System.out.println("========================================");
        System.out.println(bankTxType);
        System.out.println(bankResponseCode4);
        System.out.println(bankTxStatus4);
        System.out.println(bankTxAmount4);
        System.out.println(bankTxCurrencyCode4);
        System.out.println(tranReturnCode4);
        System.out.println(tranInfo4);









    }













    private static String getTranReturnCode(List<String> approvalCodeList) {
        return approvalCodeList != null && approvalCodeList.size() >= 3 ?
                approvalCodeList.get(0) + ":" + approvalCodeList.get(1) :
                approvalCodeList != null ? String.join(":", approvalCodeList) : null;
    }

    private static String getTranInfo(List<String> approvalCodeList) {
        return approvalCodeList != null && approvalCodeList.size() >= 3 ?
                String.join(":", approvalCodeList.subList(2, approvalCodeList.size())) :
                approvalCodeList != null ? String.join(":", approvalCodeList) : null;
    }
}
