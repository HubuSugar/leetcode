package edu.hubu.hubuSugar.extend;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @author: sugar
 * @date: 2021/12/8
 * @descript: 反转链表
 */
public class ReverseList {

    public ListNode reverse(ListNode head){

        if(head == null) return null;
        ListNode after = head;
        ListNode pre = null;
        while(head != null){
            after = head.next;
            head.next = pre;
            pre = head;
            head = after;
        }
        return pre;

    }

    public static void main(String[] args) {
        ListNode build = ListNodeBuilder.build("1 2 3 4");
        ListNode reverse = new ReverseList().reverse(build);
        System.out.println(reverse);
    }
}
