package com.cetrinw.liu.demo.photobook;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cetrin Wang on 2016/4/21.
 * 简单电话簿
 * <p>
 * 请用面向对象方法设计并实现一个简单电话簿，包括如下功能：
 * 1.能设置并以文件保存若干姓名、联系电话和电邮地址。
 * 2.根据输入的姓名，在已经保存的文件中查询相应的联系电话和电邮地址，并显示查询结果。
 * 3.根据输入的电话号码，在已经保存的文件中查询相应的联系人姓名，并显示查询结果
 */
public class Main {

    private List<Person> list;//输入的电话簿集合
    private String filePath;

    public Main(String filePath) {
        this.list = new ArrayList<Person>();
        this.filePath = filePath;
        this.savePerson();
    }

    /**
     * 打印控制台信息,并获的输入值
     * @return
     */
    private String printConsole(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * 保存联系人信息
     */
    private void savePerson(){
        boolean flag = true;
        while(flag){
            String name = printConsole("请输入一个姓名:");
            String phone = printConsole("请输入一个号码:");
            String email = printConsole("请输入一个Email地址:");

            Person p = new Person();
            p.setName(name);
            p.setPhoneNumber(phone);
            p.setEmail(email);

            this.list.add(p);

            String confirm = printConsole("是否继续添加(Y/N):");
            //忽略大小写比较
            if (!confirm.equalsIgnoreCase("Y")) {
                flag = false;
            }
        }
    }

    /**
     * 将List写成txt文件
     */
    public void wirtePhotoBook(){
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            for (Person person : list) {
                writer.write(person.getName()+"\t"+person.getPhoneNumber()+"\t"+person.getEmail());
                writer.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main("D:\\db\\test\\phonebook.txt");
        main.wirtePhotoBook();
    }

}
