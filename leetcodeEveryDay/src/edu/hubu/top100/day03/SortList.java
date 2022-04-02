package edu.hubu.top100.day03;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @author: sugar
 * @date: 2022/4/2
 * @description: 单链表排序
 */
public class SortList {

    /**
     * 使用归并算法
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        if(head == null) return null;
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        //虚拟头结点
        ListNode newHead = new ListNode();
        newHead.next = head;

        for(int subLength = 1; subLength < length; subLength <<= 1){
            ListNode prev = newHead;
            ListNode cur = newHead.next;
            while(cur != null){
                //第一个链表的头
                ListNode head1 = cur;
                for(int i = 1; i < subLength && cur.next != null; i++){
                    cur = cur.next;
                }
                //第二个链表的头
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for(int i = 1; i < subLength && cur != null && cur.next != null; i++){
                    cur = cur.next;
                }

                //保存下一组链表的开始节点
                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }

                //合并链表并排序，并将尾指针移动到排序后的链表末尾
                prev.next = merge(head1,head2);
                while(prev.next != null){
                    prev = prev.next;
                }
                cur = next;
            }
        }

        return newHead.next;
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode merge = new ListNode();
        ListNode cur = merge;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return merge.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNodeBuilder.build("4 2 1 3");
        System.out.println(new SortList().sortList(node));
    }
}
