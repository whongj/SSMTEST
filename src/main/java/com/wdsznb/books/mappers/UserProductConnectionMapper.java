package com.wdsznb.books.mappers;

import com.wdsznb.books.beans.connection.UserProductConnection;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${wanghongjie} on 2017/5/18.
 */
@Repository
public interface UserProductConnectionMapper {


    /**
     * 查询未还书籍
     *
     * @param userid
     * @return
     */
    @Select("SELECT * from lendbooks where uid=#{uid} AND state =2")
    public ArrayList<UserProductConnection> getAUserProductByUserIdstateis2(@Param("uid") String userid);


    /**
     * 查询购物车中书籍
     *
     * @param uerid
     * @return
     */
    @Select("SELECT * from lendbooks where uid = #{uid} AND state =1")
    public ArrayList<UserProductConnection> getAUserProductByUserIdstateis1(@Param("uid") String uerid);

    /**
     * 插入一条数据
     * state默认为1，说明没有借走
     *
     * @param object
     * @return
     */
    @Insert("INSERT INTO lendbooks(bname,uid,lenddate,state) values(#{bname},#{uid},#{lenddate},#{state)")
    public int insert(UserProductConnection object);

    /**
     * 通过ID进行修改数据
     *
     * @param object
     * @return
     */
    @Update("UPDATE lendbooks set uid=#{uid},bname=#{bname},lenddate=#{date}")
    public int update(UserProductConnection object);

    /**
     * 还书完成，删除
     *
     * @param userid
     * @return
     */
    @Delete("DELETE from lendbooks where uid =#{userid}")
    public int delete(String userid);


    @Update("Update lendbooks set state =2 where uid=#{uid}")
    public int updatestate(String uid);

}






