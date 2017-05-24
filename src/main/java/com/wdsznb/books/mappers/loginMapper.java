package com.wdsznb.books.mappers;

import com.wdsznb.books.beans.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by ${wanghongjie} on 2017/5/13.
 */
@Repository
public interface loginMapper {
    @Select("SELECT * FROM user WHERE wxid= #{wxid} and pwd=#{pwd}")
    public UserBean login(@Param("phonenum") String phonenum, @Param("pwd") String pwd);
}
