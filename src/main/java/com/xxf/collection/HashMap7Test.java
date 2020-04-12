package com.xxf.collection;

import com.xxf.collection.imap.impl.HashMap;

public class HashMap7Test {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
//        hashMap.put("1", 1);
//        System.out.println(hashMap.get(1));
//        hashMap.put("2", "2");
//        System.out.println(hashMap.get("2"));
        for (int i = 0; i < 1000; i++) {
            hashMap.put(i, i + "");
            System.out.println(hashMap.get(i));
        }

        System.out.println(hashMap.size());
    }
}
