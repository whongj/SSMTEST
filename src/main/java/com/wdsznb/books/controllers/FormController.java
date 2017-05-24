package com.wdsznb.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tyranitarx on 2017/4/11.
 */
@Controller
public class FormController {
    //uri页面跳转方式
    @RequestMapping(value = "/{formName}")
    public String loginform(@PathVariable String formName){
        return formName;
    }
}
