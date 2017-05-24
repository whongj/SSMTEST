package com.wdsznb.books.controllers;

/**
 * Created by ${wanghongjie} on 2017/5/11.
 */
/**
 * 返回前台H5调用JS支付所需要的参数，公众号支付调用此接口
 *
 * @param response
 * @param request
 */

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.util.SignUtils;
import com.wdsznb.books.util.ReturnModel;
import com.wdsznb.books.util.XMLUtil;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Controller
public class PaymentController extends GenericController{

    //apiclient_cert.p12证书存放路径
    private static final String CERTIFICATE_LOCATION = "   ";

    @Autowired
    protected WxPayConfig payConfig;
    @Autowired
    protected WxPayService payService;

    @RequestMapping(value = "getJSSDKPayInfo")
    public void getJSSDKPayInfo(HttpServletResponse response,
                                HttpServletRequest request) {
        ReturnModel returnModel = new ReturnModel();
        WxPayUnifiedOrderRequest prepayInfo = new WxPayUnifiedOrderRequest();
        prepayInfo.setOpenid(request.getParameter("openid"));
        prepayInfo.setOutTradeNo(request.getParameter("out_trade_no"));
        prepayInfo
                .setTotalFee(Integer.valueOf(request.getParameter("total_fee")));
        prepayInfo.setBody(request.getParameter("body"));
        prepayInfo.setTradeType(request.getParameter("trade_type"));
        prepayInfo.setSpbillCreateIp(request.getParameter("spbill_create_ip"));
        //TODO(user) 填写通知回调地址
        prepayInfo.setNotifyURL("");

        try {
            Map<String, String> payInfo = this.payService.getPayInfo(prepayInfo);
            returnModel.setResult(true);
            returnModel.setDatum(payInfo);
            renderString(response, returnModel);
        } catch (WxErrorException e) {
            returnModel.setResult(false);
            returnModel.setReason(e.getError().toString());
            renderString(response, returnModel);
            this.logger.error(e.getError().toString());
        }
    }

    /**
     * 微信通知支付结果的回调地址，notify_url
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "getJSSDKCallbackData")
    public void getJSSDKCallbackData(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            synchronized (this) {
                Map<String, String> kvm = XMLUtil.parseRequestXmlToMap(request);
                if (SignUtils.checkSign(kvm,
                        this.payConfig.getMchKey())) {
                    if (kvm.get("result_code").equals("SUCCESS")) {
                        //TODO(user) 微信服务器通知此回调接口支付成功后，通知给业务系统做处理
                        logger.info("out_trade_no: " + kvm.get("out_trade_no") + " pay SUCCESS!");
                        response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[ok]]></return_msg></xml>");
                    } else {
                        this.logger.error("out_trade_no: "
                                + kvm.get("out_trade_no") + " result_code is FAIL");
                        response.getWriter().write(
                                "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[result_code is FAIL]]></return_msg></xml>");
                    }
                } else {
                    response.getWriter().write(
                            "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[check signature FAIL]]></return_msg></xml>");
                    this.logger.error("out_trade_no: " + kvm.get("out_trade_no")
                            + " check signature FAIL");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}