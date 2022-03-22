package edu.hubu.hubuSugar.week03;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-24
 * @Description: 合并两个有序链表
 **/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //需要返回的链表头
        ListNode head = new ListNode();
        //定义一个指针记录链表的尾结点
        ListNode tail = head;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                tail.next = l2;
                //l2指针向后移动，比较下一个较大的元素
                l2 = l2.next;
            }else{
                tail.next = l1;
                l1 = l1.next;
            }
            //tail指针向后移动
            tail = tail.next;
        }
        //当两个链表中还剩下一个链表元素不为空，将它拼接到链表尾部
        if(l1 != null){
            tail.next = l1;
        }
        if(l2 != null){
            tail.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeBuilder.build("1 2 4");
        ListNode l2 = ListNodeBuilder.build("0 3 3");
        System.out.println(new MergeTwoLists().mergeTwoLists(l1, l2));
    }
}
