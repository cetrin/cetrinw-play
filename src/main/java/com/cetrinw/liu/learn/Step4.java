package com.cetrinw.liu.learn;

/**
 * Created by Cetrin Wang on 2016/4/21.
 * Session 4
 * 实现基本的加减乘除
 */
public class Step4 {
    public static int add(int a,int b){
        return a+b;
    }
    public static int sub(int a,int b){
        return a-b;
    }
    public static int mul(int a,int b){
        return a*b;
    }
    public static int div(int a,int b){
        return a/b;
    }

    public static void main(String[] args) {
        int a=63;
        int b=12;
        System.out.println(add(a,b));
        System.out.println(sub(a,b));
        System.out.println(mul(a,b));
        System.out.println(div(a,b));
    }
}
