package com.wdsznb.books.controllers;
import com.wdsznb.books.beans.UserBean;
import com.wdsznb.books.services.imp.PhoneLoginService;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;


/**
 * Created by Tyranitarx on 2017/4/5.
 */
@Controller
public class LoginController {

    @Autowired
    @Qualifier("PhoneLoginService")
    private PhoneLoginService loginService;

    @ResponseBody
    @RequestMapping("/phonelogin")
    public String UserLogin(@RequestBody HashMap<String, String> user) throws IOException, ServletException {

        //简单的登录验证匹配
        if (loginService.login(user.get("phonenum"), user.get("pwd")) == null) {
            return "{\"code\":\"0\"}";
        } else {
            return "{\"code\":\"1\"}";
        }
    }}
//到底登录要靠什么？openID就是个摆设吗？
//
//    @RequestBody
//    @RequestMapping("/login") }
//    public String Login(RequestBody )
//
//
//      }