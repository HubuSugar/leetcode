package edu.hubu.hubuSugar.extend;

/**
 * @author: sugar
 * @date: 2022/3/22
 * @description: 实现一个数的开平方函数
 */
public class Sqrt {

    public double sqrt(double x){
        if(x < 0){
            throw new RuntimeException("value: " + x + " must be greater than zero");
        }
        return doSqrt(0, x, x);
    }

    public double doSqrt(double low, double high, double x){
        while(low < high){
            double middle = (low + high) / 2.0;
            if( Math.abs( middle * middle - x) < 0.00001){
                return middle;
            }

            if(middle * middle < x){
                low = middle;
                high = x / middle;
            }else if(middle * middle > x){
                high = middle;
                low = x / middle;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(3));
    }

}
