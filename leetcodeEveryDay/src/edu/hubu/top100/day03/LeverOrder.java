package edu.hubu.top100.day03;

import edu.hubu.hubuSugar.common.ListNode;
import edu.hubu.hubuSugar.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: huxiaoge
 * @Date: 2022-04-01
 * @Description: 二叉树的层次遍历
 **/
public class LeverOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> one = new ArrayList<>();
            int levelSize = queue.size();
            for(int i = 0; i < levelSize;i++){
                TreeNode cur = queue.poll();
                assert cur != null;
                one.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            result.add(one);
        }
        return result;
    }

    /**
     * 用一个指针记录每层最右边节点
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode pRight = root;
        TreeNode last = null;
        List<Integer> one = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            one.add(cur.val);

            if(cur.left != null){
                queue.add(cur.left);
                last = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                last = cur.right;
            }

            if(cur == pRight){
                result.add(new ArrayList<>(one));
                one = new ArrayList<>();
                pRight = last;
            }

        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(3);
        TreeNode node32 = new TreeNode(4);
        TreeNode node34 = new TreeNode(5);

        root.left = node21;
        root.right = node22;
        node21.left = null;
        node21.right = node32;
        node22.left = null;
        node22.right = node34;

        System.out.println(new LeverOrder().levelOrder1(root));
    }
}
