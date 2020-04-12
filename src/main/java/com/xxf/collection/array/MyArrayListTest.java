package com.xxf.collection.array;


public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        System.out.println(myArrayList.get(2));
        System.out.println(myArrayList.size());
    }
}
