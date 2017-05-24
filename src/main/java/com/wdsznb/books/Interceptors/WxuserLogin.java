package com.wdsznb.books.Interceptors;

import me.chanjar.weixin.common.session.WxSessionManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.W;

/**
 * Created by ${wanghongjie} on 2017/5/18.
 */


//问题：似乎不能获取WxSessionManager-----按正常方式获取就行
//public class WxuserLogin implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object handler) throws Exception {
//        String path = request.getContextPath();
//        String basePath = request.getScheme() + "://"
//                + request.getServerName() + ":" + request.getServerPort()
//                + path + "/";
//
//        if(request.getRequestURI().contains("/register")||request.getRequestURI().contains("/login"))
//            return true;
//
//        WxSessionManager sessionManage
//            sessionManager.getSession(wxMessage.getFromUserName());
//        HttpSession session=request.getSession();
//        User user=(User) session.getAttribute("user");
//        if(user!=null){
//            return true;
//        }
//        else
//        {
//
//            String message="对不起您没有登陆";
//            request.setAttribute("message", message);
//            request.getRequestDispatcher(basePath+"/showUserlogin");
//            return false;
//        }
//
//    }
//
//
//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request,
//                                HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        // TODO Auto-generated method stub
//
//    }
//}
