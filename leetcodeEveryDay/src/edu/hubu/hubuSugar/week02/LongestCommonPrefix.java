package edu.hubu.hubuSugar.week02;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-09
 * @Description: 最长公共前缀
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs){
        String result = "";
        if(strs == null || strs.length == 0) return result;
        int j = 0;
        while(true){
            boolean stop = false;
            String first = strs[0];
            Character cur = null;
            if(j >= first.length()){
                stop = true;
            }else{
                cur = first.charAt(j);
            }
            for(int i = 1;i < strs.length;i++){
                String temp = strs[i];
                if(j >= temp.length() || cur == null || cur != temp.charAt(j)){
                    stop = true;
                    break;
                }
            }
            if(stop){
                result = first.substring(0,j);
                break;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flow", "flower", "flight"}));
    }
}
