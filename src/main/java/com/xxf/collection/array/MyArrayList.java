package com.xxf.collection.array;

/**
 * 底层通过数组实现ArrayList， 默认大小为10， 扩容为原来1.5倍
 */
public class MyArrayList {

    //数组
    private Object[] elementData;

    //数组长度
    private int size;

    //初始化一个默认大小为10的数组
    public MyArrayList() {
        elementData = new Object[10];
    }

    //自定初始化大小
    public MyArrayList(int l) {
        elementData = new Object[l];
    }

    /**
     * 新增数据
     * @param object
     */
    public void add(Object object) {
        //当数组容量不够的时候
        if (size >= elementData.length) {
            //扩容， 创建新的数据
            Object[] objects = new Object[elementData.length * 2]; // ArrayList是1.5
            //复制（不能丢掉原来的数据）
            System.arraycopy(elementData, 0, objects, 0, size);
            elementData = objects;
        }
        elementData[size++] = object;

    }

    /**
     * 集合大小
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 获取值
     * @param index
     * @return
     */
    public Object get(int index) {
        return elementData[index];
    }


}
