package edu.hubu.hubuSugar.extend;

import java.math.BigDecimal;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-22
 * @Description: 实现一个开平方根的函数
 **/
public class MySqrt {

    public Double sqrt(double target,int precision){
        if(target < 0){
            throw new RuntimeException("target must be greater than 0");
        }

        return doSqrt(target,0,target,precision);
    }

    private Double doSqrt(double num,double left, double right,  int precision) {
        while (left < right) {
            double middle = (left + right) / 2.0;

            if(Math.abs(middle * middle - num) < 0.00001){
                return middle;
            }
            if (middle * middle < num ) {
                left = middle;
                right = num / middle;
            } else if (middle * middle > num ) {
                right = middle;
                left = num / middle;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        Double sqrt = mySqrt.sqrt(2, 10);
        System.out.println(sqrt);
    }
}
