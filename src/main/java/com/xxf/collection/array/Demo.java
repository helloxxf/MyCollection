package com.xxf.collection.array;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//数组存链表
public class Demo {
    /**
     *数组： 采用一段连续的存储单元来存储数据，
     * 特点：查询快（根据下表查找的所以复杂度 为 O(1)) , 插入、删除慢（O(n))
     * @param args
     */
    public static void main(String[] args) {

        Entry[] entries = new Entry[16];
        entries[0] =  new Entry("1", "a", 1, null);
        entries[1] =  new Entry("2", "b", 2, null);;
        System.out.println(entries[0]);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Entry {
        private String key;

        private Object value;

        private int hash;

        private Entry next;
    }
}
