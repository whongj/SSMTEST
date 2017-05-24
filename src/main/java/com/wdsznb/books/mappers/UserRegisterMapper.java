package com.wdsznb.books.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Tyranitarx on 2017/4/21.
 */
@Repository
public interface UserRegisterMapper {
    /**
     * @param phonenum
     * @param pwd
     * @return
     */
    @Insert("Insert into user (phonenum,pwd) values(#{phonenum},#{pwd})")
    public int RegisterUser(@Param("phonenum") String phonenum, @Param("pwd") String pwd);


    @Delete("DELETE from user where wxid=#{wxid}")
    public int DeleteUser(@Param("wxid") String wxid);

}