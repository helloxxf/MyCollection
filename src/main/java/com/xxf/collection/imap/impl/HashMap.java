package com.xxf.collection.imap.impl;

import com.xxf.collection.imap.Map;

public class HashMap<K, V> implements Map<K, V> {

    private Entry[] table;

    private int size = 0;

    public HashMap() {
        this.table = new Entry[16];
    }

    /**
     * 1、key查询hash值
     * 2、hash取模下标
     * 3、通过下标找到数组对象
     * 4、判断是否为空进行存储
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry entry = table[index];
        if (entry == null) {
            table[index] = new Entry(k, v, index, null);
        } else {
            table[index] = new Entry(k, v, index, entry);
        }
        size++;
        return (V) table[index].getValue();
    }

    @Override
    public V get(K k) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            return null;
        }
        return find(k, entry);
    }

    private int hash(K k) {
        int i = k.hashCode() % 16;
        return Math.abs(i);
    }

    private V find(K k, Entry<K, V> entry) {
        if (k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            if (entry.next != null) {
                return find(entry.next.k, entry.next);
            }
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }


    class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry<K, V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

}
