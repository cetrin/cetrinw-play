package com.cetrinw.liu.demo.photobook;

import java.util.Scanner;

/**
 * Created by Cetrin Wang on 2016/4/21.
 * 简单电话簿
 *
 * 请用面向对象方法设计并实现一个简单电话簿，包括如下功能：
 * 1.能设置并以文件保存若干姓名、联系电话和电邮地址。
 * 2.根据输入的姓名，在已经保存的文件中查询相应的联系电话和电邮地址，并显示查询结果。
 * 3.根据输入的电话号码，在已经保存的文件中查询相应的联系人姓名，并显示查询结果
 */
public class Main {
    public static void main(String[] args) {
        Person p=new Person("刘琛",685743,"949397097qqcom");
        Person pp=new Person("王哲钦",685733,"1544684651qqcom");
        System.out.println("请输入一个姓名");
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        if(a.equals(p.getName())){
            p.show();
        }else if(a.equals(pp.getName())){
            pp.show();
        }else{
            System.out.println("输入的姓名错误");
        }
        System.out.println("请输入一个号码");
        String m=sc.next();
        int b=Integer.parseInt(m);
        if(b==p.getPhonenumber()){
            p.show();
        }else if(b==pp.getPhonenumber()){
            pp.show();
        }else{
            System.out.println("输入的号码错误");
        }
    }
}
