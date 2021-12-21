package edu.hubu.hubuSugar.week05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sugar
 * @date: 2021/12/21
 * @descript: 串联所有单词
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int len = s.length();
        int wordsLen = words.length;
        int eachWordLen = words[0].length();
        int subLen = eachWordLen * wordsLen;
        for (int i = 0; i <= len - subLen; i++) {
            String substring = s.substring(i, i + subLen);
            if(matchWords(substring,words,eachWordLen)){
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 判断是否匹配
     * @param s
     * @param words
     * @return
     */
    private boolean matchWords(String s,String[] words,int eachWordLen){
        boolean[] flag = new boolean[words.length];
        for(int i = 0;i <= s.length() - eachWordLen;i+=eachWordLen){
            String subStr = s.substring(i, i + eachWordLen);
            for(int j = 0;j < words.length;j++){
                if(!flag[j] && words[j].equals(subStr)){
                    flag[j] = true;
                    break;
                }
            }
        }
        for (boolean b : flag) {
            if(!b){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new FindSubstring().findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }

}
