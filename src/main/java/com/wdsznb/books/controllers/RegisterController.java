package com.wdsznb.books.controllers;

import com.wdsznb.books.services.imp.MessageValidateService;
import com.wdsznb.books.services.imp.PhoneRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.Random;


/**
 * Created by Tyranitarx on 2017/4/22.
 */

/*
 *  注册控制器
 */
@Controller
public class RegisterController {
@Autowired
@Qualifier("PhoneRegisterService")
private PhoneRegisterService registerService;
    @RequestMapping("/phoneregist")
    public String PhoneRegister(@RequestBody Map<String,String> user, HttpServletRequest request)throws IOException,ServletException{
        //若返回值为0则用户存在
        if(registerService.register(user.get("phonenum"),user.get("pwd"))>0){
            if(user.get("messagenum").equals(request.getSession().getAttribute("code"))) {
                //短信验证码相匹配
                return "{\"code\":\"1\"}";
            }
                else {
                //短信验证码不匹配返回2
                return "{\"code\":\"2\"}";
            }
        }
         else {
            //用户存在返回标识符0
            return "{\"code\":\"0\"}";
        }
}
}
