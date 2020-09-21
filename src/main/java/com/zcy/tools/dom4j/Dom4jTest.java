package com.zcy.tools.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

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
        String feeType = root.element("fee_type").getText();

        System.out.println(totalFee);
        System.out.println(feeType);









    }
}
