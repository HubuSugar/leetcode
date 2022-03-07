package edu.hubu.top100.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-07
 * @Description:
 **/
public class Merge {

    public int[][] merge(int[][] intervals) {

        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curStart > end) {
                result.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            } else {
                end = Math.max(end, curEnd);
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] merge = new Merge().merge(intervals);
        printArray(merge);

        int[][] intervals1 = new int[][]{
                {1,4},
                {4,5}
        };
        int[][] merge1 = new Merge().merge(intervals1);
        printArray(merge1);

    }

    public static void printArray(int[][] arrays) {
        for (int[] ints : arrays) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

}
