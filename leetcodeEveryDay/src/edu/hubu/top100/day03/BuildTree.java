package edu.hubu.top100.day03;

import edu.hubu.hubuSugar.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-01
 * @Description:
 **/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        return  buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        //先序遍历的根节点
        int preRoot = preOrder[preLeft];

        //中序遍历的根节点
        int i = 0;
        for (; i < preOrder.length; i++) {
            if (preRoot == inOrder[i]) {
                break;
            }
        }

        TreeNode root = new TreeNode(preRoot);

        root.left = buildTree(preOrder, inOrder, preLeft + 1, preLeft + i - inLeft, inLeft, i - 1);
        root.right = buildTree(preOrder, inOrder, preLeft + i - inLeft + 1, preRight, i + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
       int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        System.out.println(new BuildTree().buildTree(preorder, inorder));
    }
}
