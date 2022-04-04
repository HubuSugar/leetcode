package edu.hubu.top100.day04;

import edu.hubu.hubuSugar.common.TreeNode;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-04
 * @Description: 翻转二叉树
 **/
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        doInvert(root);
        return root;
    }
    public void doInvert(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        doInvert(root.left);
        doInvert(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right =right1;

        System.out.println(new InvertTree().invertTree(root));

    }

}
