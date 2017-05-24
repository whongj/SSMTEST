package com.wdsznb.books.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * Created by Tyranitarx on 2017/5/2.
 */
@Repository
public interface BookIsbnMapper {
    @Select("SELECT bisbn from books where bname=#{bname}")
    public String getALLTypeBooks(@Param("bname") String bname);
}
