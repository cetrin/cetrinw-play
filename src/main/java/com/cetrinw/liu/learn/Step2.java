package com.cetrinw.liu.learn;

/**
 * Created by Cetrin Wang on 2016/4/21.
 * Session 2
 * 写一个带参方法,传入一个String类型文本,并在main方法打印
 */
public class Step2 {
    /**
     * 对输入文本进行打印
     * @param str 需要打印的内容
     */
    private static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        print("Hello World!");
        print("Hello Liu Chen!");
    }
}
