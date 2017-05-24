package com.wdsznb.books.mappers;

import com.wdsznb.books.beans.BookBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/5/2.
 */
@Repository
public interface FirstBookPinyinMapper {
    @Select("select * from books where get_first_pinyin_char(bname) = #{Pinyin}")
    public List<BookBean> getFirstPinyin(@Param("Pinyin") String Pinyin);
}
