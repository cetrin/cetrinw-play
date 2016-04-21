package com.cetrinw.liu.demo.photobook;

/**
 * Created by Dell-pc on 2016/4/21.
 */
public class Person {
    private String name;
    private int phonenumber;
    private String email;
    public Person(){
        super();
    }
    public Person(String name,int phonenumber,String email){
        super();
        this.name=name;
        this.phonenumber=phonenumber;
        this.email=email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getPhonenumber(){
        return phonenumber;
    }
    public void setPhonenumber(int phonenumber){
        this.phonenumber=phonenumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void show(){
        System.out.println(name+"---"+phonenumber+"---"+email);
    }
}
