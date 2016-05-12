package com.cetrinw.wang.experiment.map;

import java.util.Map;


/**
 * Created by Cetrin Wang on 2016/4/25.
 */
public class CetrinwHashMap<K, V> implements CetrinwMap<K, V> {

    /**
     * 默认大小
     */
    private static final int DEFALUT_SIZE = 1 << 4;

    /**
     * 当前游标
     */
    private int current;

    static class Node<K, V> implements Map.Entry {
        K key;
        V value;
        Node<K, V> node;

        public Node(K key, V value, Node<K, V> node) {
            this.key = key;
            this.value = value;
            this.node = node;
        }

        public Object getKey() {
            return null;
        }

        public Object getValue() {
            return null;
        }

        public Object setValue(Object value) {
            return null;
        }

    }

    public int size() {
        return this.current;
    }

    public void put(K k, V v) {
//        Node<K, V> node = new Node<K, V>(k, )
    }

    public V get(K k) {
        return null;
    }

    public void remove(Object k) {

    }

}