package com.wdsznb.books.services.imp;

import com.wdsznb.books.beans.UserBean;
import com.wdsznb.books.mappers.UserMapper;
import com.wdsznb.books.mappers.UserRegisterMapper;
import com.wdsznb.books.mappers.WeRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ${wanghongjie} on 2017/5/12.
 */
@Service
public class WeRsgisterService {
    @Autowired
    WeRegisterMapper weRegisterMapper;
    @Autowired
    private UserMapper userMapper;
   public int RsgisterService(UserBean userBean){
       if(userMapper.login(userBean.getPhonenum(),userBean.getPwd())==null)
           return weRegisterMapper.WeRegisterUser(userBean);
       else
           return 0;
   }
}
