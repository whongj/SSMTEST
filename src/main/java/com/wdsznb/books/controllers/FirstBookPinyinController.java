package com.wdsznb.books.controllers;

import com.wdsznb.books.beans.BookBean;
import com.wdsznb.books.services.imp.FirstBookPinyinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/5/3.
 * 根据书籍名称首字母进行图书搜索
 */
@Controller
public class FirstBookPinyinController {
    @Autowired
    @Qualifier("FirstBookPinyinService")
    private FirstBookPinyinService firstBookPinyinService;
    @ResponseBody
    @RequestMapping("/getFirstPinyinBooks")
    public Map<String,BookBean> getFirstPinyinBooks(@RequestBody Map<String,String> FirstPinyin){
                Map<String,BookBean> bookjson=new HashMap<String, BookBean>();
                String firstPinyin=FirstPinyin.get("firstpinyin");
                List<BookBean> books=firstBookPinyinService.getBooks(firstPinyin);
                Iterator<BookBean> bookBeanIterator=books.iterator();
                int i=1;
                while (bookBeanIterator.hasNext()){
                    BookBean book=bookBeanIterator.next();
            bookjson.put(Integer.toString(i),book);
            i++;
        }
        return bookjson;
    }
}
