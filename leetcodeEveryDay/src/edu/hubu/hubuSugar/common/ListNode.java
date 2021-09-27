package edu.hubu.hubuSugar.common;

/**
 * @Author: huxiaoge
 * @Date: 2021-09-28
 * @Description: 链表结构
 **/
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return val +
                " -> " + next ;
    }
}
