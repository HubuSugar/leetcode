package edu.hubu.hubuSugar.week05;

/**
 * @author: sugar
 * @date: 2021/12/16
 * @descript: 两数相除
 */
public class Divide {

    /**
     * 暴力解法：每次从被除数中减去除数，然后将减去的次数加1
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide1(int dividend,int divisor){
        int sign = resultSign(dividend,divisor);
        if(divisor == 0) throw new RuntimeException("divided by zero");
        int count = 0;
        long divided = Math.abs((long)dividend);
        long divide = Math.abs((long)divisor);
        while(divided >= divide){
            count++;
            if(count * sign == Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(count * sign == Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            divided = divided - divide;
        }
        return count * sign;
    }

    /**
     * 基于二分搜索法，除数每次乘以2
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend,int divisor){




        return 0;
    }

    /**
     * 判断两数相除后结果的符号
     * @param
     */
    private int resultSign(int dividend,int divisor){
        return (((dividend ^ divisor) >> 31 ) & 0x1) == 1 ? -1 : 1;
    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648, -1));
    }
}
