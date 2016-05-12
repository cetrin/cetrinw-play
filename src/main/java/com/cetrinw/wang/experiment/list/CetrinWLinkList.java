package com.cetrinw.wang.experiment.list;


/**
 * Created by Cetrin Wang on 2016/5/12.
 * 链表实现
 */
public class CetrinWLinkList<E> implements CetrinwList<E>{



    /**
     *链表大小指针
     */
    private int capacity;

    /**
     * 开始节点
     */
    private Node<E> startNode;

    /**
     * 结束节点
     */
    private Node<E> endNode;


    public CetrinWLinkList(){
        this.init();
    }

    /**int
     * 实现链表节点内部类
     * @param <E>
     */
    private static class Node<E>{
        E e;//元素值
        Node<E> prev;//上一个元素
        Node<E> next;//下一个元素

        Node(E e,Node<E> prev,Node<E> next){
            this.e = e;
            this.prev = prev;
            this.next = next;
        }
    }

    public E get(int index) {
        return findNode(index).e;
    }

    public void add(E e) {
        add(e,this.capacity);
    }

    public void remove(int index) {
        removeNode(index);
    }

    public void insert(int index, E e) {
        insertNode(index,e);
    }

    public boolean contains(Object o) {
        return false;
    }

    public int size() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return this.capacity == 0;
    }

    public void clearList() {
        this.init();
    }

    /**
     * 初始化节点，使开始节点指向结束节点
     */
    private void init(){
        this.startNode = new Node<E>(null,null,null);
        this.endNode = new Node<E>(null,startNode,null);
        this.startNode.next = this.endNode;
        this.capacity = 0 ;
    }

    /**
     * 查找节点
     * @param index
     * @return
     */
    private Node<E> findNode(int index){
        Node<E> e;

        if(index < 0 || index > this.capacity) throw new IndexOutOfBoundsException();

        if(index < this.capacity/2) {
            e = startNode.next;
            for (int i = 0; i < index; i++) {
                e = e.next;
            }
        }else{
            e = endNode;
            for (int i = this.capacity; i > index; i--) {
                e = e.prev;
            }
        }
        return e;
    }

    private void add(E e,int index){
        addNode(e,findNode(index));
    }

    /**
     * 增加数据
     * @param e
     */
    private void addNode(E e,Node<E> prev){
        Node<E> newNode = new Node<E>(e,prev.prev,prev);
        newNode.prev.next = newNode;
        prev.prev = newNode;
        this.capacity++;//数量指针+1
    }

    /**
     * 移除数据
     * @param index
     */
    private void removeNode(int index){
        Node<E> n = findNode(index);
        Node<E> prev = n.prev;
        Node<E> next = n.next;
        prev.next = next;
    }

    private void insertNode(int index,E e){
        Node<E> newNode = new Node<E>(e,null,null);

        Node<E> n = findNode(index);
        Node<E> prev = n.prev;
        Node<E> next = n.next;

        prev.next = newNode;
        n.next = next;
    }
}
