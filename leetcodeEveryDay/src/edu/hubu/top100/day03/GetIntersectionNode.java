package edu.hubu.top100.day03;

import edu.hubu.hubuSugar.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-02
 * @Description: 两个链表的交叉节点
 **/
public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = headA;
        while(tmp != null){
            visited.add(tmp);
            tmp = tmp.next;
        }

        tmp = headB;
        while(tmp != null){
            if(visited.contains(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }

        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode head1 = headA;
        ListNode head2 = headB;
        while(head1 != head2){
            head1 = head1 == null ? headB : head1.next;
            head2 = head2 == null ? headA : head2.next;
        }

        return head1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode head11 = new ListNode(3);
        ListNode head12 = new ListNode(5);
        ListNode head13 = new ListNode(6);
        ListNode head14 = new ListNode(7);
        ListNode head15 = new ListNode(2,null);
        head14.next = head15;
        head13.next = head14;
        head12.next = head13;
        head11.next = head12;
        headA.next = head11;

        ListNode headB = new ListNode(8);
        ListNode head22 = new ListNode(4);
        headB.next = head22;
        head22.next = head13;

        System.out.println(new GetIntersectionNode().getIntersectionNode1(headA, headB));
    }

}
