package edu.hubu.top100.day02;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-07
 * @Description: 爬楼梯：每次可以爬一阶或者两介
 **/
public class ClimbStairs {

    /**
     * 超时
     * 当前这一步台阶只可能是从倒数第一阶爬一步上来或者倒数第二阶爬两步上来
     * 递推公式： f(n) = f(n - 1) + f(n - 2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        if(n == 1 || n == 2) return n;
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for(int i = 2; i < n;i++){
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs1(5));
    }
}
