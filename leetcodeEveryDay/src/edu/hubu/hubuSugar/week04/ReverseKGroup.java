package edu.hubu.hubuSugar.week04;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;


/**
 * @author: sugar
 * @date: 2021/12/13
 * @descript:k个一组翻转链表
 */
public class ReverseKGroup {

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseKGroup(ListNode head,int k){
        if(head == null) return null;
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        while(head != null){
            ListNode tail = pre;
            for(int i = 0;i < k;i++){
                tail = tail.next;
                //如果最后一组待翻转的链表长度不够k
                if(tail == null){
                    return newHead.next;
                }
            }
            //先保存下一组翻转的链表的头节点
            ListNode after = tail.next;
            //翻转head -> ... -> tail之间的链表，返回翻转后的链表头和尾
            ListNode[] listNodes = reverseKone(head, tail);
            head = listNodes[0];
            tail = listNodes[1];

            pre.next = head;
            tail.next = after;
            pre = tail;
            head = tail.next;
        }

        return newHead.next;
    }

    /**
     * 翻转一段链表
     * @param head
     * @param tail
     * @return
     */
    private ListNode[] reverseKone(ListNode head,ListNode tail){
        //尾节点的下一个节点
        ListNode pre = tail.next;
        //待翻转链表的头节点
        ListNode p = head;
        while(pre != tail){
            ListNode after = p.next;
            p.next = pre;
            pre = p;
            p = after;
        }
        return new ListNode[]{tail,head};
    }


    public static void main(String[] args) {
        ListNode build = ListNodeBuilder.build("1 2 3 4 5 6");
        ListNode listNode = new ReverseKGroup().reverseKGroup(build, 3);
        System.out.println(listNode);
    }

}
