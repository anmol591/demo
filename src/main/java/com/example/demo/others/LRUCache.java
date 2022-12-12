package com.example.demo.others;

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedListNode {
    int key;
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int key,int value){
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        DoublyLinkedListNode obj1 = (DoublyLinkedListNode) obj;
        return obj1.key == this.key && obj1.value == this.value;
    }
}

public class LRUCache {
    Map<Integer,DoublyLinkedListNode> map = new HashMap<>();
    DoublyLinkedListNode head,tail;
    int capacity,count;

    public LRUCache(int size){
        this.capacity = size;
        this.count = 0;
        this.head = new DoublyLinkedListNode(0,0);
        this.tail = new DoublyLinkedListNode(0,0);
        head.next = tail;
        tail.prev = head;
        count = 0;
    }

    public void addNodeToHead(DoublyLinkedListNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void deleteNode(DoublyLinkedListNode node){
       node.prev.next = node.next;
       node.next.prev = node.prev;
    }

    public int get(int key){
       if(map.containsKey(key)){
           DoublyLinkedListNode node = map.get(key);
           int result = node.value;
           addNodeToHead(node);
           return result;
       }
       return -1;
    }

    public void set(int key,int value){
        if(map.get(key)!=null){
            DoublyLinkedListNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeToHead(node);
        }else{
            DoublyLinkedListNode node = new DoublyLinkedListNode(key,value);
            map.put(key,node);
            if(count < capacity){
                addNodeToHead(node);
                count++;
            }else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addNodeToHead(node);
            }
        }

    }

    public int LruElement(){
        return tail.prev.key;
    }

    public int MUsedElement(){
        return head.next.key;
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1,3);
        lruCache.set(2,8);
        lruCache.set(3,9);
        lruCache.set(4,7);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.LruElement());
        //System.out.println(lruCache.MUsedElement());
    }
}
