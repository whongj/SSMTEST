package com.wdsznb.books.controllers;

import com.wdsznb.books.mappers.BookIsbnMapper;
        import com.wdsznb.books.services.imp.BookDetailClientService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.Map;

/**
 * Created by Tyranitarx on 2017/5/2.
 */
@Controller
public class BookDetailController{
    @Autowired
    @Qualifier("BookDetailClinetService")
    private BookDetailClientService bookDetailClientService;
    @Autowired
    private BookIsbnMapper bookIsbnMapper;
    @ResponseBody
    @RequestMapping("/getBookDetail")
    public Map getBookDetail(@RequestBody Map<String,String> BookName){
        String bisbn=bookIsbnMapper.getALLTypeBooks(BookName.get("bname"));
        //图书信息服务接口
        return bookDetailClientService.doPost(bisbn,"UTF-8");
    }
}
