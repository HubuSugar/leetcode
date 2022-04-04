package edu.hubu.top100.day04;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-03
 * @Description: 实现前缀树
 **/
public class Trie {

    private boolean end = false;
    private final Trie[] subNodes;

    public Trie() {
        subNodes = new Trie[26];
    }

    public void insert(String word) {
        Trie temp = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if(subNodes[index] == null){
                subNodes[index] = new Trie();
            }

            temp = temp.subNodes[index];
            if(i == chars.length - 1){
                temp.setEnd(true);
            }
        }

    }

    public boolean search(String word) {
        Trie node = getNode(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {

        Trie node = getNode(prefix);
        return node != null;
    }


    public Trie getNode(String text){
        char[] chars = text.toCharArray();
        int position = 0;
        int length = chars.length;
        Trie node = this;
        while(position < length){
            char c = chars[position];
            node = node.getSubNode(c);

            if(node == null){
                return null;
            }
            position++;
        }
        return node;
    }


    public boolean isEnd() {
        return end;
    }

    public void setSubNodes(Character c, Trie trie){
        subNodes.put(c, trie);
    }

    public Trie getSubNode(char c){
        return subNodes.get(c);
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public static void main(String[] args) {

        /**
         * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
         * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
         *
         * [null, null, true, false, true, null, true]
         */
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));


    }
}
