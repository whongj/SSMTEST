package com.wdsznb.books.services;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;

/**
 * Created by ${wanghongjie} on 2017/5/14.
 */
public class tagservice {
    protected WxMpService wxService =new WxMpServiceImpl();


    private Long tagId = 2L;
    public void test() throws WxErrorException {
        WxUserTag wxUserTag = new WxUserTag();
        String tagName = "测试标签";
        WxUserTag res = this.wxService.getUserTagService().tagCreate(tagName);
        System.out.println(res);
        this.tagId = res.getId();
        System.out.println(tagId);
    }





}
