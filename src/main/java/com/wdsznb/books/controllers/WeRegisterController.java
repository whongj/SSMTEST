package com.wdsznb.books.controllers;

import com.wdsznb.books.beans.UserBean;
import com.wdsznb.books.services.CoreService;
import com.wdsznb.books.services.imp.WeRsgisterService;
import com.wdsznb.books.util.ReturnModel;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSession;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by ${wanghongjie} on 2017/5/12.
 */
@Controller
@RequestMapping(value = "/WeRegister")
public class WeRegisterController extends GenericController {
    @Autowired
    protected WxMpService wxMpService;

    @Autowired
    WeRsgisterService weRsgisterService;

    /**
     * 用code换取oauth2的openid
     * 详情请见: http://mp.weixin.qq.com/wiki/1/8a5ce6257f1d3b2afb20f83e72b72ce9.html
     *
     * @param response
     * @param code     code
     *                 <p>
     *                 <p>
     *                 https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfb012ef31e49ca72&redirect_uri=WWW.XXXXX.COM/getRegister&response_type=code&scope=snsapi_bas
     *                 e#wechat_redirect   -----让用户点击这个
     *                 https://redirect_uri/?code=CODE  用户跳转至
     */
    @RequestMapping(value = "/getRegister")
    public String RegisterController(HttpServletResponse response, @RequestParam(value = "code") String code, HttpServletRequest request) {
//        ReturnModel returnModel = new ReturnModel();
//        UserBean userBean = new UserBean();
        WxMpOAuth2AccessToken accessToken;

        try {
            accessToken = this.wxMpService.oauth2getAccessToken(code);
            String openid = accessToken.getOpenId();

            request.setAttribute("wxid", openid);

//            returnModel.setResult(true);

            return "forward:/Rrgister";
//崩溃。。。为啥非要搞个这。。。
        } catch (WxErrorException e) {
//            returnModel.setResult(false);
//            returnModel.setReason(e.getError().toString());
//            renderString(response, returnModel);

        this.logger.error(e.getError().toString());
        return "错误页面";
        }
        }



    @RequestMapping("/Register")
//    request 这里是wxid
    public ModelAndView zhongjiReister(@RequestBody UserBean userBean, ModelAndView modelAndView){
        if (weRsgisterService.RsgisterService(userBean)>0) {
            modelAndView.addObject("state", "注册成功");
            modelAndView.setViewName("success");


        }else{

            modelAndView.addObject("state", "注册失败，请从新注册");

            modelAndView.setViewName("error");
        }
        return modelAndView;

    }

}



