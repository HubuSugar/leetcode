package edu.hubu.hubuSugar.week04;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.ListNodeBuilder;

/**
 * @author: sugar
 * @date: 2021/12/7
 * @descript: 合并k个有序链表
 */
public class MergeKLists {

    /**
     * 合并两个listnode
     */
    public ListNode mergeTwoList(ListNode p1,ListNode p2){
        if(p1 == null) return p2;
        if(p2 == null) return p1;
        ListNode head = new ListNode();
        ListNode cur = head;
        while(p1 != null && p2 != null){
            if(p1.val >= p2.val){
                cur.next = p2;
                p2 = p2.next;
            }else{
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        if(p1 == null){
            cur.next = p2;
        }
        if(p2 == null){
            cur.next = p1;
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode first = lists[0];
        for(int i = 1;i < lists.length;i++){
            first = mergeTwoList(first,lists[i]);
        }
        return first;
    }

    public static void main(String[] args) {

        ListNode build = ListNodeBuilder.build("1 3 5 7");
        ListNode build1 = ListNodeBuilder.build("2 4 6");
        ListNode build2 = ListNodeBuilder.build("1 3 6");
        ListNode[] lists = new ListNode[3];
        lists[0] = build;
        lists[1] = build1;
        lists[2] = build2;
        ListNode listNode = new MergeKLists().mergeKLists(lists);
        System.out.println(listNode);

    }
}
