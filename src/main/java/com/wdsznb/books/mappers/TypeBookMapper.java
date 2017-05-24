package com.wdsznb.books.mappers;
import com.wdsznb.books.beans.BookBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/4/23.
 */
@Repository
public interface TypeBookMapper {
    @Select("SELECT * from books where btype=#{btype}")
    public List<BookBean> getALLTypeBooks(@Param("btype") String btype);
}
