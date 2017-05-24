package com.wdsznb.books.wx.menu;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMenuService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpMenuServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

/**
 * Created by ${wanghongjie} on 2017/5/13.
 */
public class testMenu {

    public static void main(String[] args) throws WxErrorException {
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMenu wxMenu = new WxMenu();
        WxMpMenuService wxMpMenuService = new WxMpMenuServiceImpl(wxMpService);

// 设置菜单

    }
}
