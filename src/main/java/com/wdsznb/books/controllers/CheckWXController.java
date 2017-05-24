package com.wdsznb.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tyranitarx on 2017/5/9.
 */
//@Controller
//public class CheckWXController {
//    @Autowired
//    @Qualifier("CheckWXService")
//    private CheckWXService checkWXService;
//    @RequestMapping("/CheckWX")
//    public void CheckWX(@RequestParam("signature")String signature,
//                                @RequestParam("timestamp")String timestamp,
//                                @RequestParam("nonce")String nonce,
//                                @RequestParam("echostr")String echostr,
//                                HttpServletResponse response){
//        try {
//
//            if (checkWXService.checkSignature(signature, timestamp, nonce)){
//                response.getWriter().print(echostr);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
