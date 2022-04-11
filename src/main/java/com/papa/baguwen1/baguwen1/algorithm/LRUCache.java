package com.papa.baguwen1.baguwen1.algorithm;

import java.util.*;
//146. LRU 缓存
public class LRUCache {
    class Rnode {
        private int key;
        private int value;
        private Rnode next;
        private Rnode pre;
    }
    private int capacity;
    private Map<Integer, Rnode> map = new HashMap<>();
    Rnode head;
    Rnode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Rnode();
        tail = new Rnode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Rnode rnode = map.get(key);
        if (rnode == null){
            return -1;
        }
        moveToHead(rnode);
        return rnode.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Rnode rnode = map.get(key);
            rnode.value = value;
            moveToHead(rnode);
            map.put(key, rnode);
            return;
        } else {
            Rnode rnode = new Rnode();
            rnode.key = key;
            rnode.value = value;
            insertHead(rnode);
            map.put(key, rnode);
            if (map.size() > capacity){
                Rnode tmp = removeTail();
                map.remove(tmp.key);
            }
        }
    }

    private void removeNode(Rnode rnode){
       rnode.pre.next = rnode.next;
       rnode.next.pre = rnode.pre;
    }
    private void moveToHead(Rnode rnode){
        removeNode(rnode);
        insertHead(rnode);
    }
    private Rnode removeTail(){
        Rnode temp = tail.pre;
        removeNode(temp);
        return temp;
    }
    private void insertHead(Rnode rnode){
        Rnode temp = head.next;
        head.next = rnode;
        rnode.pre = head;
        rnode.next = temp;
        temp.pre = rnode;
    }
    private void display(){
        Rnode tmp = head;
        while (tmp.next != null){
            System.out.print(tmp.value + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(1, 1); // 缓存是 {1=1, 2=2}
        lRUCache.put(2, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}
