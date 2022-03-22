package edu.hubu.hubuSugar.week01;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @Author: huxiaoge
 * @Date: 2021-09-28
 * @Description: 链表的两数相加
 **/
public class AddTwoNums {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //表示进位
        int further = 0;
        int remain = 0;
        ListNode current = head;
        while (l1 != null && l2 != null) {
            remain = (l1.val + l2.val + further) % 10;
            further = (l1.val + l2.val + further) / 10;

            current.next = new ListNode(remain, null);
            current = current.next;

            l1 = l1.next;
            l2 = l2.next;
        }


        if (l2 != null) {
            while (l2 != null) {
                remain = (l2.val + further) % 10;
                further = (l2.val + further) / 10;
                current.next = new ListNode(remain, null);
                current = current.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            while (l1 != null) {
                remain = (l1.val + further) % 10;
                further = (l1.val + further) / 10;
                current.next = new ListNode(remain, null);
                current = current.next;
                l1 = l1.next;
            }
        }

        if (further > 0) {
            current.next = new ListNode(further, null);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeBuilder.build("9 9 9 9 9 9 9");
        ListNode l2 = ListNodeBuilder.build("9 9 9 9");
        ListNode listNode = new AddTwoNums().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
