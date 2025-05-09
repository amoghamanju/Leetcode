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
    public int goodNodes(TreeNode root) {
       return dfs(root,new ArrayList<>());
    }
    private int dfs(TreeNode node, List<Integer> path)
    {
        if (node==null)return 0;
        boolean isgood=true;
        for(int val:path)
        {
            if(val>node.val)
            {
                isgood=false;
                break;
            }
        }
        path.add(node.val);

        int left=dfs(node.left, path);
        int right= dfs(node.right, path);
        path.remove(path.size()-1);

        return (isgood?1:0)+left+right;
    }
}