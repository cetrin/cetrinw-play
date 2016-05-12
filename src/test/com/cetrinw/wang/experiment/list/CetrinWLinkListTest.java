package com.cetrinw.wang.experiment.list;

import org.junit.Test;

/**
 * Created by Cetrin Wang on 2016/5/12.
 */
public class CetrinWLinkListTest {

    CetrinwList<String> list = new CetrinWLinkList<String>();

    @Test
    public void add() throws Exception {
        list.add("haha");
        list.add("xixi");
        list.add("lala");
        list.add("jiji");
        System.out.println(list.get(2));
    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void contains() throws Exception {

    }

    @Test
    public void size() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void clearList() throws Exception {

    }

}