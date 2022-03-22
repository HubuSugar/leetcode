package edu.hubu.top100.day03;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-09
 * @Description: 二叉搜索树的种类
 **/
public class NumTrees {
    /**
     * 卡塔兰数
     * f(n + 1) = 2(2 n + 1) / n + 2 * f(n)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        long count = 1;
        for(int i = 0; i < n;i++){
            count = count * 2 * (2L * i + 1) / (i + 2);
        }
        return (int)count;
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }
}
