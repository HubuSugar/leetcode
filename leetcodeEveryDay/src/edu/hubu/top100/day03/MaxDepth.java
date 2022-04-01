package edu.hubu.top100.day03;

import edu.hubu.hubuSugar.common.TreeNode;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-01
 * @Description: 二叉树的最大深度
 **/
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(3);
        TreeNode node32 = new TreeNode(4);
        TreeNode node34 = new TreeNode(5);

        node21.left = null;
        node21.right = node32;
        node22.left = null;
        node22.right = node34;
        root.left = node21;
        root.right = node22;

        System.out.println(new MaxDepth().maxDepth(root));
    }


}
