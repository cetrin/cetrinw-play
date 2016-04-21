package com.cetrinw.liu.learn;

/**
 * Created by Cetrin Wang on 2016/4/21.
 * session3
 * 写一个方法,接受两个int参数,并返回相加的结果,把结果在main方法里面输出出来
 */
public class Step3 {
    public static int add(int a,int b){
        return a+b;
    }
    public static void main(String[] args) {
        int a=6;
        int b=3;
        System.out.println(add(a,b));
    }
}
