package edu.hubu.hubuSugar.week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-08
 * @Description: 整数转罗马数字
 **/
public class IntToRoman {

    /**
     * 用了个笨办法ac了
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        List<String> res = new ArrayList<>();
        int flag = 1;
        while (num != 0) {
            int remain = num % 10;

            if (remain != 0) {
                if (flag == 1) {
                    if (remain < 4) {
                        for (int i = 0; i < remain; i++) {
                            res.add("I");
                        }
                    } else if (remain == 4) {
                        res.add("IV");
                    } else if (remain == 5) {
                        res.add("V");
                    } else if (remain < 9) {
                        StringBuilder tmp = new StringBuilder();
                        for (int i = 0; i <= remain - 6; i++) {
                            tmp.append("I");
                        }
                        tmp.insert(0, "V");
                        res.add(tmp.toString());
                    } else {
                        res.add("IX");
                    }
                } else if (flag == 10) {
                    if (remain < 4) {
                        for (int i = 0; i < remain; i++) {
                            res.add("X");
                        }
                    } else if (remain == 4) {
                        res.add("XL");
                    } else if (remain == 5) {
                        res.add("L");
                    } else if (remain < 9) {
                        StringBuilder tmp = new StringBuilder();
                        for (int i = 0; i <= remain - 6; i++) {
                            tmp.append("X");
                        }
                        tmp.insert(0, "L");
                        res.add(tmp.toString());
                    } else {
                        res.add("XC");
                    }

                } else if (flag == 100) {
                    if (remain < 4) {
                        for (int i = 0; i < remain; i++) {
                            res.add("C");
                        }
                    } else if (remain == 4) {
                        res.add("CD");
                    } else if (remain == 5) {
                        res.add("D");
                    } else if (remain < 9) {
                        StringBuilder tmp = new StringBuilder();
                        for (int i = 0; i <= remain - 6; i++) {
                            tmp.append("C");
                        }
                        tmp.insert(0, "D");
                        res.add(tmp.toString());
                    } else {
                        res.add("CM");
                    }

                } else if (flag == 1000) {
                    if (remain < 4) {
                        for (int i = 0; i < remain; i++) {
                            res.add("M");
                        }
                    }
                }


            }
            flag *= 10;
            num = num / 10;

        }

        StringBuilder result = new StringBuilder();
        for(int i = res.size() - 1;i >=0;i--){
            result.append(res.get(i));
        }
        return result.toString();
    }

    public Map<Integer, String> dic() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        return map;
    }

    public static void main(String[] args) {

        System.out.println(new IntToRoman().intToRoman(1994));
    }
}