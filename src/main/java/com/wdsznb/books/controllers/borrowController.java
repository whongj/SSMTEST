package com.wdsznb.books.controllers;

import com.wdsznb.books.beans.BookBean;
import com.wdsznb.books.beans.UserBean;
import com.wdsznb.books.beans.connection.UserProductConnection;
import com.wdsznb.books.services.BookService;
import com.wdsznb.books.services.imp.BookborrowService;

import com.wdsznb.books.tools.Tools;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpMassTagMessage;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${wanghongjie} on 2017/5/17.
 */
@Controller
@RequestMapping("/borrowBook")
public class borrowController {

    @Autowired
    private BookborrowService bookborrowService;
    @Autowired
    private WxMpService wxMpService;


//    迷茫中，再想.想。。。  你总之得和微信的OPENID联系起来啊。。。用session也好----登录的时候就把openID放进去
//    一个解决办法，我们可以每次获取code，然后获取openid，然后就美滋滋，用openid当WXsession的key。
//    @Autowired
//    BooksearchService booksearchService;
//
//    @ResponseBody
//    @RequestMapping(value = "/get",method = RequestMethodGET)
//    public String getborrowBook(@RequestBody BookBean bookBean){
//        if (booksearchService.ifhasnext(bookBean)) {
//            booksearchService.borrowbook();
//            wxusertag+
//
//        }
//        return null;
//    }


    /**
     * 显示某用户的购物车
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showcart")
    @ResponseBody
    public ArrayList<UserProductConnection> showcart(HttpServletRequest request,
                                                     HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            ArrayList<UserProductConnection> conns = bookborrowService.getAUserAOlendbooks(user.getWxid());

            return conns;
        }
        request.setAttribute("message", "您没有登陆，没有办法操作");
        return null;

    }


    /**
     * state 0 用户未登录
     * code 0 借书失败
     * code 1 借书成功
     * 借阅一本书籍
     *
     * @param request
     * @param response
     * @param bname
     * @return
     */

    @RequestMapping("/user/borrow")
    public @ResponseBody
    String borrowThing(HttpServletRequest request,
                       HttpServletResponse response,  String bname) throws WxErrorException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        UserProductConnection userProductConnection = new UserProductConnection();
        if (user != null) {
            int judge;
            userProductConnection.setUid(user.getWxid());
            userProductConnection.setDate(Tools.getNowTime_Format());
            userProductConnection.setBname(bname);
            userProductConnection.setState(1);
            String result = bookborrowService.borrow(userProductConnection);
            if ("借书成功！".equals(result)) {
//                request.setAttribute("message", product.getName() + "购买成功");
//                将给用户打上借书组标签
                String[] a = {user.getWxid()};

                Boolean res = this.wxMpService.getUserTagService().batchTagging(100L, a);


                return "{\"code\":\"1\"}";
            }

            return "{\"code\":\"0\"}";
        }

        return "{\"state\":\"0\"}";//用户未登录
    }
// 用户扫描事件，这个需要我自己去找一下微信的生成二维码。。。然后在ScannerHandler中处理--将state变成2 。但是
//    @RequestMapping("/Admain/scan")
//    public String Admain

//改变用户借书状态

    /**
     * state =1 在购物车中，但没有被管理员确认，
     * state =2 被管理员确认，已被借走
     * <p>
     * code 1:成功改变
     * code 2：失败改变
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("Admain/changestate")
    public String Admainchangestate(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        UserBean user = (UserBean) httpSession.getAttribute("user");
        if (user != null) {
            bookborrowService.changestate(user.getWxid());
            return "{\"code\":\"1\"}";
        } else {

            return "{\"code\":\"0\"}";        }
    }

    /**
     * 还书失败 {code：0}
     * 还书成功{code：1}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/returnbook")
    @ResponseBody
    public String ReturnBook(HttpServletResponse response, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserBean user = (UserBean) httpSession.getAttribute("user");
        if (user != null) {
            String result = bookborrowService.returnBook(user.getWxid());
            if ("您没有要还的书".equals(result)) {
                return "{\"code\":\"0\"}";
            } else {
                return "{\"code\":\"1\"}";
            }
        }
        return "{\"code\":\"0\"}";
    }
}


