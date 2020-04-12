package com.xxf.hashmap.tree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> redBlackTree = new RedBlackTree();
        redBlackTree.put("a", "a");
        redBlackTree.put("b", "zs");
        redBlackTree.put("c", "ls");
        redBlackTree.put("c", "we");
        System.out.println(redBlackTree.get("c"));

        System.out.println(redBlackTree.get("b"));
        System.out.println(redBlackTree.get("a"));
    }
}
