package edu.hubu.hubuSugar.everyday;

/**
 * @author: sugar
 * @date: 2021/12/17
 * @descript: 换酒问题-1518-easy
 */
public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int remain = numBottles;
        int count = numBottles;
        while(remain >= numExchange){
            count += remain / numExchange;
            remain = (remain % numExchange) +  (remain / numExchange);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new NumWaterBottles().numWaterBottles(9, 3));
    }
}
