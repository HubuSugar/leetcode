package edu.hubu.top100.day05;

import jdk.nashorn.internal.ir.SplitReturn;

/**
 * @author: sugar
 * @date: 2022/4/17
 * @description: 买卖股票的最佳时机含有冷冻期
 */
public class MaxProfit {

    /**
     * 对于第i天结束，当前的累计最大收益为f[i]
     * f[i]存在以下三种情况：
     * f[i][0]: 当前持有一支股票--> 有可能是第i-1天持有的，或者是第i天买入的（说明第 i- 1天不持有股票并且不处于冷冻期）
     * f[i][0] = max(f[i - 1][0], f[i - 1][2] - prices[i]) 减去prices[i] 是扣除当天买入股票的成本
     * f[i][1]： 当前不持有股票并且处于冷冻期 --> 说明第 i- 1天肯定持有一支股票
     * f[i][1] = f[i - 1][0] + prices[i]  加上prices[i]是累计当天卖出股票获得的收益
     * f[i][2]：当前不持有股票，并且不处于冷冻期 --> 说明当天没有进行任何操作，也就是第i- 1天不持有股票
     * f[i][2] = max(f[i - 1][1], f[i - 1][2])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][2]);
    }

    /**
     * 空间优化, 用三个变量保存上一次的的累计利润
     * @param prices
     */
    public int maxProfit1(int[] prices){
        if(prices.length == 1) return 0;
        int length = prices.length;
        int p0 = -prices[0];
        int p1 = 0, p2 = 0;
        for(int i = 1; i< length;i++){
           int newP0 = Math.max(p0, p2 - prices[i]);
           int newP1 = p0 + prices[i];
           int newP2 = Math.max(p1, p2);
           p0 = newP0;
           p1 = newP1;
           p2 = newP2;
        }
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(new MaxProfit().maxProfit1(prices));
    }

}
