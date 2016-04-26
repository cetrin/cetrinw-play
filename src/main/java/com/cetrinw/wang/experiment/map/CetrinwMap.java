package com.cetrinw.wang.experiment.map;

/**
 * Created by Cetrin Wang on 2016/4/25.
 */
public interface CetrinwMap<K,V> {
    int size();
    void put(K k ,V v);
    V get(K k);
    void remove(Object k);

    interface Entry<K,V>{
        K getKey();
        V getValue();
        void setKey();
        void setValue();
    }
}
