package com.wdsznb.books.controllers;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpUserTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${wanghongjie} on 2017/5/15.
 */
//
//@Controller
//@RequestMapping(value = "/wxusertag")
//public class wxusertag {
//    @Autowired
//    WxMpService wxMpService;
//    WxMpUserTagServiceImpl wxMpUserTagService = new WxMpUserTagServiceImpl(wxMpService);
//    if("借书成功"){
//        wxMpUserTagService.batchTagging("借书组", openid);
//        return "{\"code\":\"1\"}";
//    }
//    else{
//        return "{\"code\":\"0\"}";
//
//    }
//
//}
