package com.xxf.collection.tree;

/**
 * 红黑树
 * 1、每个节点或者是黑色，或者是红色。
 * 2、根节点是黑色。
 * 3、每个叶子节点是黑色。 [注意：这里叶子节点，是指为空的叶子节点！]
 * 4、如果一个节点是红色的，则它的子节点必须是黑色的。
 * 5、从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑色节点。
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    //根节点
    private Node root;

    //树中元素个数
    private int N;

    //红色
    private static final String RED = "red";

    //黑色
    private static final String BLACK = "black";

    //获取元素个数
    public int size() {
        return N;
    }

    /**
     * 判断当前节点是否为红色
     *
     * @param node
     * @return
     */
    public boolean isRed(Node node) {
        //nil / null 默认黑色
        if (node == null)
            return false;
        //新增进来节点全是红色
        return RED.equals(node.color);
    }

    /**
     * 左旋转
     *
     * @param l
     * @return
     */
    private Node rolateLeft(Node l) {
        //取l的右节点命名为x
        Node x = l.right;
        //x的左节点变为l的右节点
        l.right = x.left;
        //x的左节点为l
        x.left = l;
        //x的颜色变为l的颜色
        x.color = l.color;
        //l的颜色变为红色
        l.color = RED;
        return x;
    }

    /**
     * 右旋转
     *
     * @param r
     * @return
     */
    private Node rolateRight(Node r) {
        //取l的右节点命名为x
        Node x = r.left;
        //x的右节点变为r的节点
        r.left = x.right;
        //x的左节点为l
        x.right = r;
        //x的颜色变为l的颜色
        x.color = r.color;
        //l的颜色变为红色
        r.color = RED;
        return x;
    }

    /**
     * 颜色反转
     *
     * @param h
     */
    private void flipColor(Node h) {
        //当前节点变为红色
        h.color = RED;
        //左子节点和右子节点变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;

    }


    /**
     * 在整个树上完成插入操作
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        //根节点颜色变为黑色
        root.color = BLACK;
    }

    /**
     * 在指定树上完成插入操作
     *
     * @param h
     * @param key
     * @param value
     */
    public Node put(Node h, Key key, Value value) {
        //判断h是否为空， 如果为空则直接返回一个红色节点
        if (h == null) {
            //元素数量加1
            N++;
            return new Node(key, value, null, null, RED);
        }
        //不为空则比较
        int cmp = key.compareTo((Key) h.key);
        if (cmp < 0) {
            //继续往左
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            //继续往右
            h.right = put(h.right, key, value);
        } else {
            //发生值得替换
            h.value = value;
        }

        //进行左旋， 当前节点的左节点为黑色，右节点为红色，需要进行左旋
        if ( !isRed(h.left) && isRed(h.right)) {
           h = rolateLeft(h);
        }

        //右旋， 当前节点的左节点为红色并且左节点的左节点也为红色
        if (isRed(h.left) && isRed(h.left.left)) {
           h = rolateRight(h);
        }

        //颜色反转： 当前节点的左节点为红色，右节点为红色，则当前节点变为红色， 左右子节点变为黑色
        if (isRed(h.left) && isRed(h.right)) {
            flipColor(h);
        }
        return h;
    }

    /**
     * 遍历树获取值
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 指定节点获取值
     * @param h
     * @param key
     * @return
     */
    public Value get(Node h, Key key) {
        if (h == null) {
            return null;
        }
        int cmp = key.compareTo((Key) h.key);
        if (cmp < 0) {
            //继续往做查找
            return (Value) get(h.left, key);
        } else if (cmp > 0) {
            //继续往右查找
            return (Value) get(h.right, key);
        } else {
            //如果相等则是找到值
            return (Value) h.value;
        }
    }

    //节点
    public class Node<Key, Value> {

        //存储键
        private Key key;

        //存储值
        private Value value;

        //左节点
        private Node left;

        //右节点
        private Node right;

        //颜色
        private String color;

        public Node(Key key, Value value, Node left, Node right, String color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

}
