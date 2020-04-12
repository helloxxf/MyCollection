package com.xxf.collection.link;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class MyLinkList {

    //头节点
    private Node first;

    //尾结点
    private Node last;

    private int size;

    public int size() {
        return size;
    }

    public boolean add(Object object) {
        Node node = new Node();
        if (first == null) {
            node.next = null;
            node.prev = null;
            node.setData(object);
            first = node;
            last = node;
            size++;
        } else {
            node.prev = last;
            node.next = null;
            node.setData(object);
            last.next = node;
            last = node;
            size++;
        }
        return true;
    }

    public Node getLast() {
        return last;
    }

    public Node getFirst() {
        return first;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Node {

        //下个节点
        public Node next;

        //上个节点
        public Node prev;

        //存放的数据
        private Object data;

    }
}
