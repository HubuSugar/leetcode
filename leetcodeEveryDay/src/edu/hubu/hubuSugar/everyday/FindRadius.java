package edu.hubu.hubuSugar.everyday;

import java.util.Arrays;

/**
 * @author: sugar
 * @date: 2021/12/20
 * @descript: 找到最小的供暖半径-475-middle
 */
public class FindRadius {

    public int findRadius(int[] houses, int[] heaters){
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int len1 = houses.length;
        int len2 = heaters.length;
        boolean[] flag = new boolean[houses[len1 - 1] + 1];
        for (int house : houses) {
            flag[house] = true;
        }
        for (int i = 0; i < len2; i++) {
            int heater = heaters[i];
            int start = heater - 1;
            int end = heater + 1;
            if (i + 1 < len2) {

            }

        }


        return 0;
    }

    public static void main(String[] args) {

    }
}
