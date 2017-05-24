package com.wdsznb.books.beans.connection;
/**
 *
 *借书类，若state=1，则表示已加入购物车，但是没有支付押金。
 * 若state=2，则表示已经支付押金，但是没有还书
 * 如果还书，则使用delete，从表中删除数据
 * Created by ${wanghongjie} on 2017/5/18.
 */
public class UserProductConnection  {

    private String uid;

    private String bname;

    private String date;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
//    private String id;
//    private String name;
    private int state;


//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }


}
