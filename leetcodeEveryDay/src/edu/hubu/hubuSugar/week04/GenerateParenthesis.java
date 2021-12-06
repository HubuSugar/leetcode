package edu.hubu.hubuSugar.week04;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-24
 * @Description: 括号生成
 **/
public class GenerateParenthesis {

    /**
     * 使用回溯法
     * 卡特兰数的经典应用 h(n) = h(0)h(n-1) + h(1)h(n - 2) + .... + h(n - 1)h(0) n >= 2
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) return result;
        helper(0,0,n,new StringBuilder(),result);
        return result;
    }

    private void helper(int left,int right,int max,StringBuilder parenthesis,List<String> result){
        if(parenthesis.length() == 2 * max){
            result.add(parenthesis.toString());
            return;
        }
        //如果左括号的个数小于n，那么可以放置一个左括号
        if(left < max){
            parenthesis.append("(");
            helper(left + 1,right,max,parenthesis,result);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }
        //如果右括号的个数小于左括号的个数
        if(right < left){
            parenthesis.append(")");
            helper(left,right + 1,max,parenthesis,result);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(2));
    }
}
