package com.wdsznb.books.services;

import com.wdsznb.books.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/4/5.
 */
public interface UserService {
   UserBean login(String loginname, String password);
}
