package com.wdsznb.books.mappers;

import com.wdsznb.books.beans.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by ${wanghongjie} on 2017/5/12.
 */
@Repository
public interface WeRegisterMapper {
    @Insert("Insert into user (phonenum,pwd,wxid,name,ubirth) values(#{phonenum},#{pwd},#{wxid},#{name},#{ubirth})")
    @Options(useGeneratedKeys=true)
    public int WeRegisterUser(UserBean userBean);
}
