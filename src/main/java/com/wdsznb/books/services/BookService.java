package com.wdsznb.books.services;

import com.wdsznb.books.beans.BookBean;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/4/23.
 */
public interface BookService {
    public List<BookBean> getBooks(String bmessage);
}
