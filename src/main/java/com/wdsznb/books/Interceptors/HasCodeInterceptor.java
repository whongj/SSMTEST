package com.wdsznb.books.Interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;


/**
 * Created by Tyranitarx on 2017/4/12.
 */
public class HasCodeInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String myurl=httpServletRequest.getRequestURL().toString();
        String WXurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf5e53f9271098f64&redirect_uri="+ URLEncoder.encode(myurl,"UTF-8")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        if(httpServletRequest.getParameter("code")==null){
            httpServletResponse.sendRedirect(WXurl);
        }
        else {
            System.out.println("----------------->this is the WXCODE:" +
                    httpServletRequest.getParameter("code"));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
