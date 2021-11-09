package edu.hubu.hubuSugar.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-09
 * @Description: 罗马数字转整数
 **/
public class RomanToInt {

    /**
     * 这一题在解析字符串时不用考虑，40 90 60 70.。。这种情况，
     * 只需要考虑，后一个字符代表的值是否比前一个字符大
     * @param s
     * @return
     */
    public int romanToInt(String s){
        if(s.length() == 0) {
            return 0;
        }
        Map<String,Integer> dic = new HashMap<>();
        dic.put("M",1000);
        dic.put("D",500);
        dic.put("C",100);
        dic.put("L",50);
        dic.put("X",10);
        dic.put("V",5);
        dic.put("I",1);
        int result = 0;
        int len = s.length();
        for(int i = 0;i < len;i++){
            int value = dic.get(String.valueOf(s.charAt(i)));
            int j = i + 1;
            if(j < len && value < dic.get(String.valueOf(s.charAt(j)))){
                result = result - value;
            }else{
                result = result + value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
    }
}
