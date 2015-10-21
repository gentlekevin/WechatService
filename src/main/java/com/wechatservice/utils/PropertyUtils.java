package com.wechatservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuchao15 on 2015/10/18.
 */
public class PropertyUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formateDate (Date date) {
        return simpleDateFormat.format(date);
    }
}
