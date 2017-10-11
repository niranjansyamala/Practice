package com.practice.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {


    class MyLRUCache extends LinkedHashMap {


        MyLRUCache(int initialCapacity,
                   float loadFactor,
                   boolean accessOrder) {
            super(initialCapacity, loadFactor, accessOrder);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return true;
        }
    }
}
