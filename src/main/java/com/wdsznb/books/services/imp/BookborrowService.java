package com.wdsznb.books.services.imp;

import com.wdsznb.books.beans.connection.UserProductConnection;

import com.wdsznb.books.mappers.UserProductConnectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ${wanghongjie} on 2017/5/17.
 */
@Service("BooksearchService")
public class BookborrowService {
    @Autowired
    UserProductConnectionMapper userProductConnectionMapper;

    public  String borrow (UserProductConnection userProductConnection){
        if (userProductConnectionMapper.getAUserProductByUserIdstateis1(userProductConnection.getUid()).size()>=2){
            return "对不起，您一次只能借两本书";
        }else if (userProductConnectionMapper.getAUserProductByUserIdstateis2(userProductConnection.getUid()).size()!=0){
            return "对不起，请先还书，再借书";
        }
        userProductConnectionMapper.insert(userProductConnection);
        return "借书成功！";
    }

    public String returnBook(String uid) {
        if (userProductConnectionMapper.getAUserProductByUserIdstateis2(uid).size() == 0) {
            return "您没有需要还的书";
        }else{
            userProductConnectionMapper.delete(uid);
            return "您已还书！欢迎下次再来";
        }
    }

    /**
     * 管理员得到所有的书籍，确认后，state才会变为2
     * 这个二维码还是用微信自己生成才好，可以得到一个event
     * @param uid
     * @return
     */
    public ArrayList<UserProductConnection> getAUserAOlendbooks(String uid) {
        return userProductConnectionMapper.getAUserProductByUserIdstateis1(uid);
    }

    /**
     * 管理员确认后，将图书从未借，变成为还
     * @param id
     * @return
     */
    public int changestate(String id) {
        return userProductConnectionMapper.updatestate(id);
    }



}
