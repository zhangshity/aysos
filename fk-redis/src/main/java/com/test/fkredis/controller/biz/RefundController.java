//package com.test.fkredis.controller.biz;
//
//import com.oceanpayment.common.util.IpUtils;
//import com.oceanpayment.opgateway.common.constant.RefundQueryRespConsts;
//import com.oceanpayment.opgateway.controller.AbstractController;
//import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoDTO;
//import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoQueryConditionDTO;
//import com.oceanpayment.opgateway.pojo.vo.RefundInfoVO;
//import com.oceanpayment.opgateway.service.RefundService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.text.StringEscapeUtils;
//import org.hibernate.validator.constraints.Range;
//import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
///**
// * 退款Controller
// * <p>Title: </p>
// * <p>Description: </p>
// * @author Allen.C.Y.Zhang
// * @version V1.0
// * @date 2021-02-26 14:17:17
// */
//@Api(value = "退款Controller")
//@Validated
//@RestController
//public class RefundController extends AbstractController {
//
//    private final RefundService refundService;
//
//    @Autowired
//    public RefundController(RefundService refundService) {
//        this.refundService = refundService;
//    }
//
//
//    /**
//     * 退款信息查询 -参数校验异常处理器
//     * @title refundInfoQueryConstraintViolationExceptionHandler
//     * @description
//     * @author Allen.C.Y.Zhang
//     * @date 2021-03-18 16:28
//     * @param e 违反约束异常
//     * @return {@link RefundInfoVO} 退款信息
//     */
//    @ExceptionHandler(value = ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public RefundInfoVO refundInfoQueryConstraintViolationExceptionHandler(ConstraintViolationException e) {
//        RefundInfoVO vo = new RefundInfoVO();
//        e.getConstraintViolations().forEach(x -> {
//            Object[] executableParameters = x.getExecutableParameters();
//            vo.setAccount(String.valueOf(executableParameters[0]));
//            vo.setTerminal(String.valueOf(executableParameters[1]));
//            vo.setSignValue(String.valueOf(executableParameters[2]));
//            vo.setRefundId(String.valueOf(executableParameters[3]));
//            vo.setRefundNumber(String.valueOf(executableParameters[4]));
//            vo.setRefundQueryNo(null);
//            vo.setRefundCheck(x.getMessage());
//            vo.setRefundDescription(RefundQueryRespConsts.REFUND_ERROR_MAP.get(x.getMessage()));
//        });
//        logger.debug("ExceptionHandler返回信息: {}", vo);
//        return vo;
//    }
//
//    /**
//     * 退款信息查询API
//     *
//     * @param merchantNo       商户号
//     * @param gatewayNo        终端号
//     * @param signature        签名
//     * @param refundId         退款ID
//     * @param merchantRefundId 商户退款ID
//     * @return {@link RefundInfoVO} 退款信息
//     * @title
//     * @description
//     * @author Allen.C.Y.Zhang
//     * @date 2021-02-26 14:17:17
//     */
//    @ApiOperation(value = "退款信息查询API")
//    @PostMapping(path = "/service/queryRefund", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE})
//    public RefundInfoVO RefundQuery(@RequestParam(name = "account", required = false)
//                                    @NotNull(message = RefundQueryRespConsts.EMPTY_ACCOUNT)
//                                    @Range(min = 10_0000L, max = 99_9999L, message = RefundQueryRespConsts.INVALID_ACCOUNT)
//                                    @ApiParam(value = "商户号", name = "account", allowableValues = "range[6,6]", type = "Long", required = true)
//                                            String merchantNo,
//
//                                    @RequestParam(name = "terminal", required = false)
//                                    @NotNull(message = RefundQueryRespConsts.EMPTY_TERMINAL)
//                                    @Range(min = 1000_0000L, max = 9999_9999L, message = RefundQueryRespConsts.INVALID_TERMINAL)
//                                    @ApiParam(value = "终端号", name = "signValue", allowableValues = "range[8,8]", type = "Long", required = true)
//                                            String gatewayNo,
//
//                                    @RequestParam(name = "signValue", required = false)
//                                    @NotBlank(message = RefundQueryRespConsts.SIGNATURE_MISMATCH)
//                                    @Size(min = 64, max = 64, message = RefundQueryRespConsts.SIGNATURE_MISMATCH)
//                                    @ApiParam(value = "签名信息", name = "signValue", allowableValues = "range[64,64]", type = "String", required = true)
//                                            String signature,
//
//                                    @RequestParam(name = "refund_id", required = false)
//                                    @Range(min = 0, max = 99_9999_9999L, message = RefundQueryRespConsts.INVALID_REFUND_ID)
//                                    @ApiParam(value = "退款订单号", name = "refund_id", allowableValues = "range[10,10]", type = "Long", required = true)
//                                            String refundId,
//
//                                    @RequestParam(name = "refund_number", required = false)
//                                    @Size(min = 1, max = 50, message = RefundQueryRespConsts.INVALID_MERCHANT_REFUND_ID)
//                                    @ApiParam(value = "商户退款订单号", name = "refund_number", allowableValues = "range[1,50]", type = "String", required = true)
//                                            String merchantRefundId) {
//
//        logger.info("--------- Start退款信息查询 [RefundId:{},MerchantRefundId:{}] ---------", refundId, merchantRefundId);
//
//        // 1.获取请求参数并校验
//        // 1.(1) 补充参数获取
//        String clientIp = StringEscapeUtils.unescapeXml(IpUtils.getIpAddress(request));
//        Long OptionalRefundId = Optional.ofNullable(refundId).map(Long::valueOf).orElse(null);
//        logger.debug("退款信息查询请求参数: [account={}, terminal={}, signValue={}, refund_id={}, refund_number={}, Client-IP={}]",
//                merchantNo, gatewayNo, signature, refundId, merchantRefundId, clientIp);
//        // 1.(2) 补充参数校验
//        // 退款ID和商户退款ID (二选一)
//        if (refundId == null && StringUtils.isBlank(merchantRefundId)) {
//            String code = RefundQueryRespConsts.BOTH_REFUND_ID_AND_MERCHANT_REFUND_ID_ARE_EMPTY;
//            String message = RefundQueryRespConsts.REFUND_ERROR_MAP.get(code);
//            ConstraintViolation<?> constraintViolation = ConstraintViolationImpl.forParameterValidation(null, null, null,
//                    code, null, null, null, null, null, null,
//                    new Object[]{merchantNo, gatewayNo, signature, refundId, merchantRefundId}, null);
//            Set<ConstraintViolation<?>> constraintViolations = new HashSet<>();
//            constraintViolations.add(constraintViolation);
//            throw new ConstraintViolationException(message, constraintViolations);
//        }
//
//
//        // 2.组合条件并查询
//        RefundInfoQueryConditionDTO condition = new RefundInfoQueryConditionDTO();
//        condition.setMerchantNo(Long.valueOf(merchantNo));
//        condition.setGatewayNo(Long.valueOf(gatewayNo));
//        condition.setSignature(signature);
//        condition.setRefundId(OptionalRefundId);
//        condition.setMerchantRefundId(merchantRefundId);
//        condition.setClientIp(clientIp);
//        RefundInfoDTO refundInfo = refundService.findRefundInfo(condition);
//
//
//        // 3.封装数据并返回
//       RefundInfoVO vo = new RefundInfoVO();
//        vo.setAccount(merchantNo);
//        vo.setTerminal(gatewayNo);
//        vo.setSignValue(signature);
//        vo.setRefundId(refundId);
//        vo.setRefundNumber(merchantRefundId);
//        vo.setRefundQueryNo(refundInfo.getBankRefundId());
//        vo.setRefundCheck(refundInfo.getCode());
//        vo.setRefundDescription(refundInfo.getDescription());
//
//        logger.info("--------- End退款信息查询 [RefundId:{},MerchantRefundId:{}] ---------", refundId, merchantRefundId);
//        return vo;
//    }
//}
