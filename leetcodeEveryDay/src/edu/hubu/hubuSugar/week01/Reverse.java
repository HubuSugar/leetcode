package edu.hubu.hubuSugar.week01;

import java.util.ArrayList;

/**
 * @Author: huxiaoge
 * @Date: 2021-10-26
 * @Description: 整数反转 Easy
 **/
public class Reverse {

    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int num = x % 10;
            x /= 10;
            if(result > Integer.MAX_VALUE / 10){
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10){
                return 0;
            }

            result = result * 10 + num;
        }
        return result;
    }


    public static void main(String[] args) {
        int reverse = new Reverse().reverse(1563847412);
        System.out.println(reverse);
    }
}
