package edu.hubu.hubuSugar.week04;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @author: sugar
 * @date: 2021/12/8
 * @descript: 两两交换链表中的节点
 */
public class SwapPairs {

    /**
     * 使用递归法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode two = head.next;
        ListNode three = head.next.next;

        two.next = head;
        head.next = swapPairs(three);
        return two;
    }

    /**
     * 迭代法
     * @param head
     */
    public ListNode swapPairs1(ListNode head){
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode newHead = new ListNode();
        newHead.next = head;
        //每次交换temp的后两个节点
        //交换前 temp -> node1 -> node2
        //交换后 temp -> node2 -> node1
        ListNode temp = newHead;
        while(temp.next != null && temp.next.next != null){
            ListNode node1= temp.next;
            ListNode node2 = temp.next.next;

            //将node2接到temp节点后面
            temp.next = node2;
            //将之前的node2之后的节点拼接到node1之后
            node1.next = node2.next;
            //将node1拼接到node2之后
            node2.next = node1;
            //temp移动到现有的node1
            temp = node1;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode build = ListNodeBuilder.build("1 2 3 4");
        ListNode listNode = new SwapPairs().swapPairs1(build);
        System.out.println(listNode);
    }
}
