package edu.hubu.hubuSugar.everyday;

import java.util.HashMap;

/**
 * @author: sugar
 * @date: 2022/5/12
 * @description: 最大字符串乘积
 */
public class MaxMultiple {

    public int maxMultiple(String[] s){
        int max = 0;
        int len = s.length;
        for(int i = 0; i < len; i++){
            boolean exist = false;
            String cur = s[i];
            for(int j = i + 1; j < len;j++){
                String target = s[j];
                for(int k = 0; k < target.length();k++){
                   if(cur.contains(String.valueOf(target.charAt(k)))){
                       exist = true;
                        break;
                   }
                }
                if(!exist){
                    max = Math.max(cur.length() * target.length(), max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] s = {"iwdvpbn","hk","iuop","iikd","kadgpf"};
        System.out.println(new MaxMultiple().maxMultiple(s));
    }
}
