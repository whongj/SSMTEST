package com.wdsznb.books.controllers;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpQrcodeService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpQrcodeServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

/**
 * 通过WxQRService，得到一个临时二维码。这个二维码发送给客户。然后，通过扫描该二维码，知道这个客户是谁，然后通过这个的formuser（即OPENID）从数据库中查询这货借了
 * 几本书
 * Created by ${wanghongjie} on 2017/5/22.
 */
@Controller
@RequestMapping("/Qrcode")
public class WxQRController {
    @Autowired
    WxMpService wxMpService;
    WxMpQrcodeService wxMpQrcodeService = new WxMpQrcodeServiceImpl(wxMpService);


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getQrcode(String OpenID) throws WxErrorException, FileNotFoundException {
        WxMpQrCodeTicket ticket = this.wxMpService.getQrcodeService().qrCodeCreateLastTicket(1);
        File file = this.wxMpService.getQrcodeService().qrCodePicture(ticket);
        InputStream inputStream = new FileInputStream(file);
        WxMediaUploadResult res = wxMpService.getMaterialService().mediaUpload(WxConsts.MASS_MSG_IMAGE, "image", inputStream);
        return res.getMediaId();

    }

}

