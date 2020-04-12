package com.xxf.collection.link;

//链表节点
public class Link {

    public Link next;

    private Object data;

    public Link(Object o) {
        this.data = o;
    }

    /**
     * 链表是一种物理存储单元非连续、非顺序的存储结构
     * 特点： 1、插入、删除快（O(1)), 查找慢（O(n)
     * @param args
     */
    public static void main(String[] args) {
        Link Link = new Link(1);
        Link.next = new Link(2);
        Link.next.next = new Link(3);
        System.out.println(Link.next.data);
    }
}
