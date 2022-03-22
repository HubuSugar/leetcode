package edu.hubu.hubuSugar.week03;

import edu.hubu.common.ListNode;
import edu.hubu.common.ListNodeBuilder;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-23
 * @Description: 删除链表的倒数第k个节点
 **/
public class RemoveNthFromEnd {

    /**
     * 本题的主要思想是通过双指针找到链表的倒数第k个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1、首先找到倒数第k个节点
        ListNode mark = head;
        ListNode follow = head;
        int index = 0;
        while(index < n){
            if(mark == null){
                //说明链表长度不超过n
                return head;
            }
            mark = mark.next;
            index++;
        }
        ListNode result = new ListNode();
        ListNode tail = result;
        //结束这个循环时说明mark指针已经走到了链表的第k个节点
        while(mark != null){
            //mark指针和follow指针同时移动，当mark移动到链表结尾时，此时follow指针刚好指向链表的倒数第k个节点
            mark = mark.next;
            //记录链表的尾结点
            tail.next = follow;
            tail = tail.next;
            follow = follow.next;
        }
        //2、删除follow节点
        tail.next = follow == null ? null : follow.next;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode build = ListNodeBuilder.build("1 2 3 4 5 6");
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(build, 6));
    }
}
