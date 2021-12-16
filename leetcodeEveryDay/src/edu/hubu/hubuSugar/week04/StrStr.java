package edu.hubu.hubuSugar.week04;

/**
 * @author: sugar
 * @date: 2021/12/14
 * @descript: 实现java中的indexOf函数
 */
public class StrStr {

    /**
     * 遍历源字符串的解法
     * @param hayStack
     * @param needle
     * @return
     */
    public int strStr(String hayStack,String needle){
        if(needle == null || needle.length() == 0){
            return 0;
        }
        int result = -1;
        int len = hayStack.length();
        int len1 = needle.length();
        int i = 0;
        while(i < len){
            int k = 0;
            if(hayStack.charAt(i) != needle.charAt(k)){
                i++;
            }else{
                int j = i;
                while(k < len1 && j < len && hayStack.charAt(j) == needle.charAt(k)){
                    j++;
                    k++;
                }
                if(k == len1){
                    result = i;
                    break;
                }
                if(j == len){
                    return -1;
                }
                if(hayStack.charAt(j) != needle.charAt(k)){
                    i++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("", ""));
    }
}
