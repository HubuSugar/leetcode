package edu.hubu.hubuSugar.common;

/**
 * @Author: huxiaoge
 * @Date: 2021-09-28
 * @Description: 用于快速生成链表
 **/
public class ListNodeBuilder {

    private static final String DEFAULT_SPLITER = " ";
    private static final ListNode DEFAULT_HEAD = new ListNode(-1,null);

    public static ListNode build(String nodeStr){
       return build(nodeStr,false,DEFAULT_SPLITER);
    }

    public static ListNode build(String nodeStr,boolean withHead){
        return build(nodeStr,withHead,DEFAULT_SPLITER);
    }

    public static ListNode build(String nodeStr,String spliter){
        return build(nodeStr,false,spliter);
    }

    public static ListNode build(String nodeStr,boolean withHead,String spliter){
        return buildWithHead(nodeStr,withHead,spliter);
    }

    private static ListNode buildWithHead(String nodeStr,boolean withHead,String spliter){
        assert nodeStr != null;
        String[] values = nodeStr.split(spliter);
        ListNode current;
        if(withHead){
            current = DEFAULT_HEAD;
            for (String s : values) {
                int value = Integer.parseInt(s.trim());
                current.next = new ListNode(value, null);
                current = current.next;
            }
            return DEFAULT_HEAD;
        }else{
            int len = values.length;
            if(len <= 0){
                return null;
            }
            int value = Integer.parseInt(values[0]);
            ListNode head = new ListNode(value,null);
            current = head;
            for(int i = 1;i < len;i++){
                int data = Integer.parseInt(values[i].trim());
                current.next = new ListNode(data, null);
                current = current.next;
            }
            return head;
        }
    }
}
