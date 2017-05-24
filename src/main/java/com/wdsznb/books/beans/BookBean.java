package com.wdsznb.books.beans;

import java.io.Serializable;

/**
 * Created by Tyranitarx on 2017/4/22.
 */
public class BookBean implements Serializable {
    private int bid;
    private String bisbn;
    private String bname;
    private String btype;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBisbn() {
        return bisbn;
    }

    public void setBisbn(String bisbn) {
        this.bisbn = bisbn;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }
}
