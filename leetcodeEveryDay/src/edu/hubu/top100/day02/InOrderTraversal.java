package edu.hubu.top100.day02;

import edu.hubu.hubuSugar.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huxiaoge
 * @Date: 2022-03-09
 * @Description: 二叉树的中序遍历
 **/
public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root,result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result){
        if(root != null) {
            helper(root.left,result);
            result.add(root.val);
            helper(root.right,result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);

        right1.left = new TreeNode(3,null,null);
        right1.right = null;

        root.left = null;
        root.right = right1;

        System.out.println(new InOrderTraversal().inorderTraversal(root));
    }
}
