package com.wdsznb.books.Interceptors;

import com.wdsznb.books.beans.UserBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**问题：到底注册怎么确认？
 * 2.登录到底拿手机号还是怎样？
 * 3.登录去向不明
 * Created by Tyranitarx on 2017/5/10.
 */
public class IfLoginInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";

        if(request.getRequestURI().contains("/register")||request.getRequestURI().contains("/login"))
            return true;

        HttpSession session=request.getSession();
        UserBean user=(UserBean) session.getAttribute("user");
        if(user!=null){
            return true;
        }
        else
        {

            String message="对不起您没有登陆";
            request.setAttribute("message", message);
            request.getRequestDispatcher(basePath+"/showUserlogin");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }
}