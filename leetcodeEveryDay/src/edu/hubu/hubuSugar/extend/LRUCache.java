package edu.hubu.hubuSugar.extend;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: sugar
 * @date: 2022/4/25
 * @description: LRU Cache
 */
public class LRUCache {
    private final int size;
    private final Map<Integer,Node> maps;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.size = capacity;
        maps = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = maps.get(key);
        if(node == null){
            return 0;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = maps.get(key);
        //如果不存在
        if(node == null){
            //如果超出缓存大小
            if(maps.size() >= size){
                removeTail();
            }
            node = new Node(key, value);
        }

        node.value = value;
        maps.put(key, node);
        moveToHead(node);
    }


    public void remove(int key){
        Node node = maps.get(key);
        if(node != null){
            removeNode(node);
        }
        maps.remove(key);
    }

    public void removeNode(Node node){

        if(node.next != null){
            node.next.pre = node.pre;
        }

        if(node.pre != null){
            node.pre.next = node.next;
        }

    }

    public void removeTail(){
        if(tail == null)
            return;
        Node tail = this.tail.pre;
        if(tail == null){
            head = null;
        }else{
            tail.next = null;
        }
    }

    public void moveToHead(Node node){
        if(node == head)
            return;
        if(node == tail){
            tail = node.pre;
        }

        //不为头结点
        if(node.pre != null){
           node.pre.next = node.next;
        }
        //不为尾结点
        if(node.next != null){
            node.next.pre = node.pre;
        }

        //头结点或者尾结点中有一个为空
        if(head == null || tail == null){
            head = tail = node;
            return;
        }

        //将node节点放在双向链表的开始
        node.next = head;
        head.pre = node;
        head = node;
        node.pre = null;
    }


    static class Node{
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
}



