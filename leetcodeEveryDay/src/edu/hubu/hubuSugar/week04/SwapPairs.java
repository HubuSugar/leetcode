package edu.hubu.hubuSugar.week04;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @author: sugar
 * @date: 2021/12/8
 * @descript: 两两交换链表中的节点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head){
        if(head == null) return null;
        ListNode res = new ListNode();
        ListNode cur = res;
        ListNode next;
        while (head != null){
            ListNode after = head.next;
            if(after == null){
                break;
            }
            next = after.next;
            cur.next = after;

            //下一个head的位置

            after.next = head;
            cur = head;
            head = next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode build = ListNodeBuilder.build("1 2 3 4");
        ListNode listNode = new SwapPairs().swapPairs(build);
        System.out.println(listNode);
    }
}
