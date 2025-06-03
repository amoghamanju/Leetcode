/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        int leftheight=getheight(root.left);
        int rightheight=getheight(root.right);

        if(Math.abs(leftheight-rightheight)>1)
        {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }   
    private int getheight(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int leftheight=getheight(node.left);
        int rightheight=getheight(node.right);

        return Math.max(leftheight,rightheight)+1;
    }
}