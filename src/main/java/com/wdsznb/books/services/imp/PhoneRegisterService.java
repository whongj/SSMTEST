package com.wdsznb.books.services.imp;

import com.wdsznb.books.mappers.UserMapper;
import com.wdsznb.books.mappers.UserRegisterMapper;
import com.wdsznb.books.services.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2017/4/22.
 */
@Service("PhoneRegisterService")
public class PhoneRegisterService implements UserRegisterService {
    @Autowired
    private UserRegisterMapper registerMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public int register(String phonenum, String pwd) {
        if(userMapper.login(phonenum,pwd)==null)
        return registerMapper.RegisterUser(phonenum,pwd);
        else
            return 0;
    }
}
