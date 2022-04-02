package edu.hubu.top100.day03;

import edu.hubu.hubuSugar.common.ListNode;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-01
 * @Description: 环的入口节点
 **/
public class DeleteCycle {

    /**
     * 链表的头结点到环的入口节点的距离 = 快慢指针相遇点到环的入口节点的距离
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        //小于三个节点不能构成环
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        }
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }

    public static void main(String[] args) {

    }
}
