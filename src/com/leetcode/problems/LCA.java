package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by weifengc on 7/17/16.
 */
public class LCA {



    //  Definition for a binary tree node.
    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return method1(root, p, q);
        }
        //idea, put the path of target node to root to a stack,
        //pop the stack and find out the last equal element.

        private TreeNode method1(TreeNode root, TreeNode n1, TreeNode n2){
            if(root == null){
                return null;
            }else if(n1 == null || n2 == null){
                return null;
            }

            ArrayList<TreeNode> s1 = toQueue(root, n1, new ArrayList<TreeNode>() );
            ArrayList<TreeNode> s2 = toQueue(root, n1, new ArrayList<TreeNode>() );

            TreeNode res = root;
            while(!s1.isEmpty() && !s2.isEmpty()){
                if(s1.get(0) == s2.get(0) ){
                    res = s1.remove(0);
                    s2.remove(0);
                }else{
                    break;
                }
            }

            return res;
        }


        private ArrayList<TreeNode> toQueue(TreeNode root, TreeNode n, ArrayList<TreeNode> list ){
            //check base case
            if(root == null){
                return null;
            }else if(n == null){
                return null;
            }
            if(root == n){
                list.add(root);
                return list;
            }

            ArrayList<TreeNode> leftCopy = new ArrayList<>();
            ArrayList<TreeNode> rightCopy = new ArrayList<>();
            Collections.copy(leftCopy, list);
            Collections.copy(rightCopy, list);


            ArrayList<TreeNode> left = toQueue(root.left, n, leftCopy);
            ArrayList<TreeNode> right = toQueue(root.right, n, rightCopy );

            if(left != null){
                return left;
            }else{
                return left;
            }
        }


    }
    
    
}
