package com.wdsznb.books.services.imp;

import com.wdsznb.books.beans.BookBean;
import com.wdsznb.books.mappers.TypeBookMapper;
import com.wdsznb.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/4/23.
 */
@Service("TypeBookService")
public class TypeBookService implements BookService{
    @Autowired
    private TypeBookMapper typeBookMapper;
    @Override
    public List<BookBean> getBooks(String btype){
        return typeBookMapper.getALLTypeBooks(btype);
    }
}

