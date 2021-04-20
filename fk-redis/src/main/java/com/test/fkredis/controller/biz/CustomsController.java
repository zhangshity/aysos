package com.test.fkredis.controller.biz;

import com.oceanpayment.common.util.IpUtils;
import com.oceanpayment.opgateway.controller.AbstractController;
import com.oceanpayment.opgateway.pojo.dto.customs.CustomsQueryConditionDTO;
import com.oceanpayment.opgateway.pojo.dto.customs.CustomsQueryResultDTO;
import com.oceanpayment.opgateway.pojo.param.CustomsQueryParams;
import com.oceanpayment.opgateway.pojo.vo.CustomsInfoVO;
import com.oceanpayment.opgateway.service.CustomsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 海关信息Controller
 * <p>Title: </p>
 * <p>Description: ACI迁移 - CustomsQueryServlet. author:Armey</p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-02-23 18:17:41
 */
@Api(value = "海关上送查询Controller")
@RestController
public class CustomsController extends AbstractController {

    private final CustomsService customsService;

    @Autowired
    public CustomsController(CustomsService customsService) {
        this.customsService = customsService;
    }


    /**
     * 海关上送查询API
     * @title customsQuery
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-02-23 18:17:41
     * @param request 请求信息
     * @param response 响应信息
     * @return
     */
    @ApiOperation(value = "海关上送查询API")
    @PostMapping(path = "/service/check/customsQuery", produces = {MediaType.APPLICATION_XML_VALUE})
    public String customsQuery(CustomsQueryParams requestParam) throws UnsupportedEncodingException {
        logger.info("------------------ 商户海关上送查询开始 ------------------");

        // 1.获取请求参数并处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String merNo = StringEscapeUtils.unescapeXml(request.getParameter("account")); // 商户号
        String gatewayNo = StringEscapeUtils.unescapeXml(request.getParameter("terminal")); // 网关接入号
        String signInfo = StringEscapeUtils.unescapeXml(request.getParameter("signValue")); // 加密信息
        String tradeNo = StringEscapeUtils.unescapeXml(request.getParameter("payment_id")); // 退款商户号
        String remoteIp = StringEscapeUtils.unescapeXml(IpUtils.getIpAddress(request));

        // 2.组合条件并查询
        CustomsQueryConditionDTO condition = new CustomsQueryConditionDTO();
        BeanUtils.copyProperties(requestParam, condition);
        condition.setAccount(merNo);
        condition.setTerminal(gatewayNo);
        condition.setSignValue(signInfo);
        condition.setPaymentId(tradeNo);
        condition.setRemoteIp(remoteIp);
        List<CustomsQueryResultDTO> CustomsInfoList = customsService.findCustomsInfo(condition);

        // 3.封装数据并返回
        CustomsInfoVO vo = new CustomsInfoVO();


        int i = 5 / 0;

//
//        // 组装返回数据
//        Document document = DocumentHelper.createDocument();
//        Element data = document.addElement("response");
//        for (CustomsOutBean out : outList) {
//            Element data2 = data.addElement("paymentInfo");
//            data2.addElement("account").addText(out.getMerNo());
//            data2.addElement("terminal").addText(out.getGatewayNo());
//            data2.addElement("signValue").addText(out.getSignInfo());
//            data2.addElement("order_number").addText(out.getOrderNumber());
//            data2.addElement("order_currency").addText(out.getCurrency());
//            data2.addElement("order_amount").addText(out.getAmount());
//            data2.addElement("payment_id").addText(out.getTradeNo());
//            data2.addElement("results").addText(out.getResults());
//            data2.addElement("details").addText(out.getDetails());
//            data2.addElement("date").addText(out.getData());
//        }
//        logger.info(" 商户海关上送查询返回：" + document.asXML());
//
//        PrintWriter write = response.getWriter();
//        write.print(document.asXML());
//        write.flush();
//        write.close();

        logger.info("------------------ 商户海关上送查询结束 ------------------");
        return null;
    }
}
