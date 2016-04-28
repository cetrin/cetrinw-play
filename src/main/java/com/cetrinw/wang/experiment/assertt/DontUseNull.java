package com.cetrinw.wang.experiment.assertt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cetrin Wang on 2016/4/28.
 * 去掉烦人的if(XX != null)
 */
public class DontUseNull {

    /**
     * 使用断言，运行时需要加入-ea
     *
     * @param str
     */
    public static void getCharLength(String str) {
        assert str != null : "字符串不能为空";
        System.out.println(str.length());
    }

    /**
     * 使用断言，运行时需要加入-ea
     */
    public static Map<String, Object> getMap() {
        return new HashMap<String, Object>();
    }

    public static void main(String[] args) {
//        getCharLength(null);
        Map map = getMap();
        System.out.println(map.size());
    }
}
