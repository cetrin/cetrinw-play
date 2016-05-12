package com.cetrinw.wang.experiment.reflection;

/**
 * Created by Cetrin Wang on 2016/4/28.
 */

class ReflectionClass {

    private String name;

    public ReflectionClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Name extends ReflectionClass {

    public Name(String name) {
        super(name);
    }
}

public class Reflection {
    public static void main(String[] args) {
        ReflectionClass r1 = new ReflectionClass("Jeff");
        ReflectionClass r2 = new Name("Boss");
        System.out.println(r1.getClass().getName() + " " + r1.getName());
        System.out.println(r2.getClass().getName() + " " + r2.getName());
    }
}

