package com.xxf.collection.tree;

//红黑树测试
public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> redBlackTree = new RedBlackTree();
        redBlackTree.put("a", "a");
        redBlackTree.put("b", "zs");
        redBlackTree.put("c", "ls");
        redBlackTree.put("d", "we");
        System.out.println(redBlackTree.get("a"));
        System.out.println(redBlackTree.get("b"));
        System.out.println(redBlackTree.get("c"));
        System.out.println(redBlackTree.get("d"));
        System.out.println(redBlackTree.size());
    }
}
