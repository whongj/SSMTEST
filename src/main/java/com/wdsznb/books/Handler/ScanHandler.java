package com.wdsznb.books.Handler;

import com.wdsznb.books.beans.connection.UserProductConnection;
import com.wdsznb.books.builder.TextBuilder;
import com.wdsznb.books.services.imp.BookborrowService;
import com.wdsznb.books.services.imp.WeixinService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

/**
 * 
 * 扫码事件：
 *
 *
 */
@Component
public abstract class ScanHandler extends AbstractHandler {
    @Autowired
    BookborrowService bookborrowService;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException {
        //TODO 对扫码事件进行处理

        WeixinService weixinService = new WeixinService();
        ArrayList<UserProductConnection> aUserAOlendbooks=bookborrowService.getAUserAOlendbooks(wxMessage.getFromUser());
        try {
            return new TextBuilder().build("您要借阅的书籍有"+aUserAOlendbooks, wxMessage,weixinService );
    } catch (Exception e) {
        this.logger.error(e.getMessage(), e);
    }
        return null;
    }
}
