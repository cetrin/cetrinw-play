package com.cetrinw.util;

import java.sql.Blob;

/**
 * Created by Cetrin Wang on 2016/4/21.\
 * String工具类
 */
public class StrUtils {
    /**
     * 把BLOB转成String
     * @param blob
     * @return
     */
    public static String blob2String(Blob blob){
        try {
            if(blob == null || blob.length()==0){
                return "";
            }else{
                String content = new String(blob.getBytes((long)1, (int)blob.length()), "GBK");
                return content.trim();
            }
        } catch (Exception e) {
            return "";
        }
    }
}
