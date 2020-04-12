package com.xxf.collection.link;

public class MyLinkListTest {
    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.add("1");
        myLinkList.add("2");
        myLinkList.add("3");
        myLinkList.add("4");
        myLinkList.add("5");
        System.out.println(myLinkList.getFirst().getData());
        System.out.println(myLinkList.getLast().getData());
        System.out.println(myLinkList.size());
    }
}
