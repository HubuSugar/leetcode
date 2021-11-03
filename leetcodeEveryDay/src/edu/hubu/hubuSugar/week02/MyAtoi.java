package edu.hubu.hubuSugar.week02;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-02
 * @Description: 字符串转换整数
 **/
public class MyAtoi {

    /**
     * 思路比较清晰的一种解法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int result = 0;
        if(s == null || s.length() == 0){
            return result;
        }
        int len = s.length();
        int flag = 1;   //用于记录结果的正负
        boolean hasSign = false;   //用于记录是否出现正、负号
        boolean hasNum = false;   //用于记录是否出现过数字
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(cur == ' '){
                //如果出现过数字或者 + -号
                if(hasNum || hasSign){
                    return result * flag;
                }
            }else if(cur == '+' || cur == '-'){
                //出现过数字，表示出现的 + -号是数字后的符号，不符合要求
                if(hasNum){
                    return result * flag;
                }
                //出现多个+ -号的情况
                if(hasSign){
                    return 0;
                }
                hasSign = true;
                flag = cur == '-' ? -1 : 1;
            }else if(cur >= '0' && cur <= '9'){
                hasNum = true;
                int num = Integer.parseInt(String.valueOf(cur));
                //如果是正数计算的时候越界：分为两种情况（1）乘以10的时候超过范围，（2）乘以10之后 + 当前值（num）的时候超出范围
                if(result * flag > Integer.MAX_VALUE / 10 || (result * flag == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)){
                    return Integer.MAX_VALUE;
                }

                if(result * flag < Integer.MIN_VALUE / 10 || (result * flag == Integer.MIN_VALUE / 10 && num * flag < Integer.MIN_VALUE % 10)){
                    return Integer.MIN_VALUE;
                }
                result  = result * 10 + num;
            }else{
                return flag * result;
            }
        }
        return flag * result;
    }


    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        int i = myAtoi.myAtoi(
                "-2147483649");
        System.out.println(i);
    }

}
