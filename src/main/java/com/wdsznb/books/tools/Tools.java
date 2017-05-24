package com.wdsznb.books.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${wanghongjie} on 2017/5/18.
 */

    public class Tools {

        public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String getNowTime_Format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        return sdf.format(new Date());
    }

    }
