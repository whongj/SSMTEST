package com.wdsznb.books.wx;

import com.wdsznb.books.config.MainConfig;
import com.wdsznb.books.services.imp.WeixinService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.impl.WxMpUserTagServiceImpl;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;


import java.util.List;

/**
 * Created by ${wanghongjie} on 2017/5/14.
 */
public class test {

    public static void main(String[] args) throws WxErrorException {
        MainConfig wxMpConfig;
        WeixinService weixinService = new WeixinService();
//        weixinService.init();
//        获取一个用户的openid；

        final WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxfb012ef31e49ca72");// 设置微信公众号的appid
        config.setSecret("bb4971f64931e9df153bfe3fc2b4f349");// 设置微信公众号的app corpSecret
        config.setToken("wxpdsznb");// 设置微信公众号的token
        config.setAesKey("NCoxgdTrDgDR623ywqpVWJvzudaMJfdQXOzGgUeqcte");// 设置消息加解密密钥
        weixinService.setWxMpConfigStorage(config);
        weixinService.getQrcodeService();
        WxMpUserTagServiceImpl wxMpUserTagService = new WxMpUserTagServiceImpl(weixinService);
//        wxMpUserTagService.tagCreate("借书组");
//        wxMpUserTagService.tagCreate("剩余7天组");

        List<WxUserTag> list =wxMpUserTagService.tagGet();
        System.out.println(list);

    }
}
