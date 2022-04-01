package edu.hubu.top100.day03;

import edu.hubu.hubuSugar.common.TreeNode;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-01
 * @Description: 给定一颗二叉树判断是否是镜像二叉树
 **/
public class IsSymmetric {

    /**
     * 当前节点的左子树的值等于右子树的值
     * 并且左子树的左节点 等于 右子树的右节点
     * 左子树的右节点 等于 右子树的左节点
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isMirror(left.right,right.left) && isMirror(left.left, right.right);
    }

    public static void main(String[] args) {
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(4);
        TreeNode node33 = new TreeNode(4);
        TreeNode node34 = new TreeNode(3);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        root.left = node21;
        root.right = node22;
        node21.left = node31;
        node21.right = node32;
        node22.left = node33;
        node22.right = node34;

        System.out.println(new IsSymmetric().isSymmetric(root));
    }

}
