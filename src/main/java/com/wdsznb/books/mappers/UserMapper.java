package com.wdsznb.books.mappers;

import com.wdsznb.books.beans.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/4/5.
 */
@Repository
public interface UserMapper {
    /**
     *
     * @param phonenum
     * @param pwd
     * @return
     */
    @Select("SELECT * FROM user WHERE phonenum= #{phonenum} and pwd=#{pwd}")
    public UserBean login(@Param("phonenum") String phonenum, @Param("pwd") String pwd);
}
