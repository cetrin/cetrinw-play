package com.cetrinw.wang.experiment.list;

/**
 * Created by Cetrin Wang on 2016/4/24.
 */
public class CetrinWArrayList<E> implements CetrinwList<E>{

    /**
     * 数组默认长度
     */
    private static final int DEFAULT_SIZE = 10;

    public CetrinWArrayList(){

    }

    public CetrinWArrayList(int size){
        if(size < 0){
            throw new RuntimeException("数组大小不能小于0");
        }else{

        }
    }

    public void get(int index) {

    }

    public void add(E e) {

    }

    public void remove(int index) {

    }

    public boolean contains(Object o) {
        return false;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }
}
