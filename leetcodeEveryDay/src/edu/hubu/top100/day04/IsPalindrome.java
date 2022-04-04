package edu.hubu.top100.day04;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 回文链表
 **/
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {

        if(head == null) return true;
        ListNode mid = findMid(head);
        ListNode reverse = reverse(mid.next);

        ListNode p1 = head;
        ListNode p2 = reverse;
        boolean result = true;
        while(result && p2 != null){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // mid.next = reverse(reverse);
        return result;
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public ListNode reverse(ListNode head){
        ListNode node = head;
        ListNode pre = null;
        ListNode after = null;
        while(node != null){
            after = node.next;
            node.next = pre;
            pre = node;
            node = after;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode node1 = ListNodeBuilder.build("1 3 3 2 1");
        System.out.println(new IsPalindrome().isPalindrome(node1));
    }
}
