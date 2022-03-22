package edu.hubu.hubuSugar.common;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-09
 * @Description:
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
