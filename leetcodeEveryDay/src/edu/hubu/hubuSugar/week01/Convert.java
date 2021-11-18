package edu.hubu.hubuSugar.week01;

/**
 * @Author: huxiaoge
 * @Date: 2021-10-16
 * @Description: 按照Z字形排列
 **/
public class Convert {

    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0){
            return "";
        }


        Character[][] res = new Character[numRows][];

        /**
         * 2 * rowNums - 2 就会循环一轮
         * 每循环一次，就增加 rowNums - 1 列
         */
        int count = 0;
        int groups = 0;
        for(int i = 0; i < s.length();i++){
            count++;
            if(2 * numRows - 2 == count){
                count=0;
                groups++;
            }

            res[count][groups] = s.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (Character[] re : res) {
            for (Character character : re) {
                sb.append(character);
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String paypalishring = new Convert().convert("PAYPALISHRING", 3);
        System.out.println(paypalishring);
    }

}
