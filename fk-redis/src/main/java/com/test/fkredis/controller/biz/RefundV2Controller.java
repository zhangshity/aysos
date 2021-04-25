//package com.test.fkredis.controller.biz;
//
//import com.oceanpayment.common.util.IpUtils;
//import com.oceanpayment.opgateway.common.constant.RefundQueryRespConsts;
//import com.oceanpayment.opgateway.controller.AbstractController;
//import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoDTO;
//import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoQueryConditionDTO;
//import com.oceanpayment.opgateway.pojo.param.InquiryRefundParams;
//import com.oceanpayment.opgateway.pojo.vo.refundv2.RefundInfoVO;
//import com.oceanpayment.opgateway.service.RefundService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.text.StringEscapeUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.List;
//
///**
// * 退款Controller
// * <p>Title: </p>
// * <p>Description: </p>
// * @author Allen.C.Y.Zhang
// * @version V2.0
// * @date 2021-04-01 15:20
// */
//@Api(value = "退款Controller-v2")
//@RequestMapping(path = "/v2")
//@RestController
//public class RefundV2Controller extends AbstractController {
//
//    private final RefundService refundService;
//
//    @Autowired
//    public RefundV2Controller(RefundService refundService) {
//        this.refundService = refundService;
//    }
//
//    /**
//     * 退款信息查询API -v2
//     *
//     * @param params        请求参数
//     * @param bindingResult 绑定结果
//     * @return {@link RefundInfoVO} 退款信息
//     * @author Allen.C.Y.Zhang
//     * @date 2021-04-02 16:11
//     */
//    @ApiOperation(value = "退款信息查询API")
//    @ResponseBody
//    @PostMapping(path = "/service/queryRefund")
//    public RefundInfoVO RefundQuery(@RequestBody @Valid InquiryRefundParams params, BindingResult bindingResult) {
//        logger.info("--------- Start退款信息查询 [RefundId:{},MerchantRefundId:{}] ---------",params.getRefundId(),params.getMerchantRefundId());
//
//        // 1.请求参数处理
//        // 1.(1) 失败校验处理
//        if (bindingResult.hasErrors()) {
//            RefundInfoVO refundInfo = new RefundInfoVO();
//            refundInfo.setAccount(params.getMerchantNo());
//            refundInfo.setTerminal(params.getGatewayNo());
//            refundInfo.setSignature(params.getSignature());
//            refundInfo.setRefundId(params.getRefundId());
//            refundInfo.setMerchantRefundId(params.getMerchantRefundId());
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            fieldErrors.forEach(fieldError -> {
//                String invalidField = fieldError.getField();
//                String code = fieldError.getDefaultMessage();
//                String message = RefundQueryRespConsts.REFUND_ERROR_MAP.get(code);
//                logger.warn("{} field error, default message: {}|{}", invalidField, code, message);
//                refundInfo.setResultCode(code);
//                refundInfo.setResultMessage(message);
//            });
//            return refundInfo;
//        }
//        // 1.(2) 补充参数获取
//        String clientIp = StringEscapeUtils.unescapeXml(IpUtils.getIpAddress(request));
//        logger.debug("退款信息查询请求参数: {}, Client-IP={}]", params, clientIp);
//        // 1.(3) 补充参数校验
//        // 退款ID和商户退款ID (二选一)
//        if (params.getRefundId() == null && StringUtils.isBlank(params.getMerchantRefundId())) {
//            RefundInfoVO refundInfo = new RefundInfoVO();
//            String code = RefundQueryRespConsts.BOTH_REFUND_ID_AND_MERCHANT_REFUND_ID_ARE_EMPTY;
//            String message = RefundQueryRespConsts.REFUND_ERROR_MAP.get(code);
//            refundInfo.setResultCode(code);
//            refundInfo.setResultMessage(message);
//            return refundInfo;
//        }
//
//
//        // 2.组合条件并查询
//        RefundInfoQueryConditionDTO condition = new RefundInfoQueryConditionDTO();
//        condition.setMerchantNo(Long.valueOf(params.getMerchantNo()));
//        condition.setGatewayNo(Long.valueOf(params.getGatewayNo()));
//        condition.setSignature(params.getSignature());
//        condition.setRefundId(Long.valueOf(params.getRefundId()));
//        condition.setMerchantRefundId(params.getMerchantRefundId());
//        condition.setClientIp(clientIp);
//        RefundInfoDTO refundInfo = refundService.findRefundInfo(condition);
//
//
//        // 3.封装数据并返回
//        RefundInfoVO vo = new RefundInfoVO();
//        vo.setAccount(params.getMerchantNo());
//        vo.setTerminal(params.getGatewayNo());
//        vo.setSignature(params.getSignature());
//        vo.setRefundId(params.getRefundId());
//        vo.setMerchantRefundId(params.getMerchantRefundId());
//        vo.setBankRefundId(refundInfo.getBankRefundId());
//        vo.setResultCode(refundInfo.getCode());
//        vo.setResultMessage(refundInfo.getDescription());
//
//        logger.info("--------- End退款信息查询 [RefundId:{},MerchantRefundId:{}] ---------",params.getRefundId(),params.getMerchantRefundId());
//        return vo;
//    }
//}
