package com.wdsznb.books.services.imp;

import com.wdsznb.books.beans.UserBean;
import com.wdsznb.books.services.UserService;
import com.wdsznb.books.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2017/4/5.
 */
@Service("PhoneLoginService")
public class PhoneLoginService implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserBean login(String phoneNum, String pwd) {

        return userMapper.login(phoneNum,pwd);
    }
}
