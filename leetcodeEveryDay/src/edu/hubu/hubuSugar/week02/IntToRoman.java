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
     * 用了个笨办法ac了(穷举法)，目前换成了滑动窗口，耗时好像更长了，但是通用性提高了
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        //分别表示0 - 1000;
        String[] base = new String[]{"","I","V","X","L","C","D","M"};

        int flag = 0;

        List<String> res = new ArrayList<>();
        while(num != 0){

            int remain = num % 10;
            if(remain == 0){
                res.add(base[0]);
            }else if (remain < 4) {
                for (int i = 0; i < remain; i++) {
                    res.add(base[flag * 2 + 1]);
                }
            } else if (remain == 4) {
                String tmp = base[flag * 2 + 1] + base[flag * 2 + 2];
                res.add(tmp);
            } else if (remain == 5) {
                res.add(base[flag * 2 + 2]);
            } else if (remain < 9) {
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i <= remain - 6; i++) {
                    tmp.append(base[flag * 2 + 1]);
                }
                tmp.insert(0, base[flag * 2 + 2]);
                res.add(tmp.toString());
            } else {
                String tmp = base[flag * 2 + 1] + base[flag * 2 + 3];
                res.add(tmp);
            }
            flag++;
            num = num / 10;
        }
        StringBuilder result = new StringBuilder();
        for(int i = res.size() - 1 ;i >= 0;i--){
            result.append(res.get(i));
        }

        return result.toString();
    }


    public static void main(String[] args) {

        System.out.println(new IntToRoman().intToRoman(58));
    }
}