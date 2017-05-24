package com.wdsznb.books.services.imp;

import com.wdsznb.books.beans.BookBean;
import com.wdsznb.books.mappers.FirstBookPinyinMapper;
import com.wdsznb.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/5/3.
 */
@Service("FirstBookPinyinService")
public class FirstBookPinyinService implements BookService{
    @Autowired
    private FirstBookPinyinMapper firstBookPinyinMapper;
    @Override
    public List<BookBean> getBooks(String FirstPinyin) {
        return firstBookPinyinMapper.getFirstPinyin(FirstPinyin);
    }
}
