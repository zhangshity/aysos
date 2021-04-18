package com.zcy.tools.codec;

import org.apache.commons.text.StringEscapeUtils;

public class XmlEscapeTest {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<alipay>\n" +
                "    <is_success>T</is_success>\n" +
                "    <request>\n" +
                "        <param name=\"partner_trans_id\">210119130014206010598</param>\n" +
                "        <param name=\"partner\">2088331370005945</param>\n" +
                "        <param name=\"service\">alipay.acquire.overseas.query</param>\n" +
                "        <param name=\"_input_charset\">UTF-8</param>\n" +
                "        <param name=\"sign\">f68805e1a13d60429ae3cee14f39b784</param>\n" +
                "        <param name=\"sign_type\">MD5</param>\n" +
                "    </request>\n" +
                "    <response>\n" +
                "        <alipay>\n" +
                "            <alipay_buyer_login_id>852-****0654</alipay_buyer_login_id>\n" +
                "            <alipay_buyer_user_id>2088042172056571</alipay_buyer_user_id>\n" +
                "            <alipay_pay_time>20210119130016</alipay_pay_time>\n" +
                "            <alipay_trans_id>2021011922001456571412147507</alipay_trans_id>\n" +
                "            <alipay_trans_status>TRADE_CLOSED</alipay_trans_status>\n" +
                "            <currency>HKD</currency>\n" +
                "            <out_trade_no>210119130014206010598</out_trade_no>\n" +
                "            <partner_trans_id>210119130014206010598</partner_trans_id>\n" +
                "            <payment_inst>ALIPAYHK</payment_inst>\n" +
                "            <result_code>SUCCESS</result_code>\n" +
                "            <trans_amount>0.10</trans_amount>\n" +
                "        </alipay>\n" +
                "    </response>\n" +
                "    <sign>c8c8a6ed1e95c998a4a7748edfc0f509</sign>\n" +
                "    <sign_type>MD5</sign_type>\n" +
                "</alipay>";

        // 转义
        String escapedXml = StringEscapeUtils.escapeXml10(xml);

        System.out.println(escapedXml);
        System.out.println(StringEscapeUtils.unescapeXml(escapedXml));



    }
}
